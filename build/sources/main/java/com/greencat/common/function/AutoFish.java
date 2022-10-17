package com.greencat.common.function;

import com.greencat.Antimony;
import com.greencat.common.FunctionManager.FunctionManager;
import com.greencat.common.config.ConfigLoader;
import com.greencat.utils.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.init.Items;
import net.minecraft.util.AxisAlignedBB;
import net.minecraftforge.client.event.sound.PlaySoundEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.awt.*;
import java.util.List;
import java.util.Random;

public class AutoFish {
    public void AutoFishEventRegiser(){
        MinecraftForge.EVENT_BUS.register(this);
    }
    Minecraft mc = Minecraft.getMinecraft();
    Utils utils = new Utils();
    Robot robot = new Robot();
    static int Tick = 40;
    Random randomYaw = new Random();
    Random randomPitch = new Random();
    static boolean MoveStatus = false;
    int RandomNumber1 = randomYaw.nextInt(20);
    int RandomNumber2 = randomPitch.nextInt(20);
    static Boolean AutoFishStatus = false;


    public AutoFish() throws AWTException {
        try{
            if (FunctionManager.getStatus("AutoFish")) {
                if (mc.thePlayer.getHeldItem().getItem() == Items.fishing_rod) {
                    this.Tick = 0;
                    //utils.print("Fish now Up");
                }

            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
    @SubscribeEvent
    public void StartTriggerAutoFish(TickEvent.ClientTickEvent event) {
        if (Minecraft.getMinecraft().theWorld != null) {
            if (!FunctionManager.getStatus("AutoFish")){
                AutoFishStatus = false;
            }
        }
    }
    @SubscribeEvent
    public void ClientTick(TickEvent.ClientTickEvent event) {
        if (mc.theWorld != null) {
            if (Tick < 40) {
                if (Tick == 5) {
                    mc.thePlayer.rotationYaw = mc.thePlayer.rotationYaw + RandomNumber1;
                    mc.thePlayer.rotationPitch = mc.thePlayer.rotationPitch + RandomNumber2;
                    KeyBinding.setKeyBindState(Minecraft.getMinecraft().gameSettings.keyBindSneak.getKeyCode(),true);
                } else if (Tick == 10) {
                    try {
                        Minecraft.getMinecraft().playerController.sendUseItem(Minecraft.getMinecraft().thePlayer, Minecraft.getMinecraft().theWorld, Minecraft.getMinecraft().thePlayer.getHeldItem());
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                } else if (Tick == 29) {
                    mc.thePlayer.rotationPitch = mc.thePlayer.rotationPitch - RandomNumber2;
                    if(MoveStatus){
                        KeyBinding.setKeyBindState(Minecraft.getMinecraft().gameSettings.keyBindRight.getKeyCode(),true);
                    } else {
                        KeyBinding.setKeyBindState(Minecraft.getMinecraft().gameSettings.keyBindLeft.getKeyCode(),true);
                    }
                } else if(Tick == 30){
                    if(MoveStatus){
                        KeyBinding.setKeyBindState(Minecraft.getMinecraft().gameSettings.keyBindRight.getKeyCode(),false);
                        KeyBinding.setKeyBindState(Minecraft.getMinecraft().gameSettings.keyBindLeft.getKeyCode(),true);
                    } else {
                        KeyBinding.setKeyBindState(Minecraft.getMinecraft().gameSettings.keyBindLeft.getKeyCode(),false);
                        KeyBinding.setKeyBindState(Minecraft.getMinecraft().gameSettings.keyBindRight.getKeyCode(),true);
                    }
                } else if(Tick == 32){
                    if(MoveStatus){
                        KeyBinding.setKeyBindState(Minecraft.getMinecraft().gameSettings.keyBindLeft.getKeyCode(),false);
                    } else {
                        KeyBinding.setKeyBindState(Minecraft.getMinecraft().gameSettings.keyBindRight.getKeyCode(),false);
                    }
                    MoveStatus = !MoveStatus;
                } else if(Tick == 37){
                    if(Antimony.AutoFishYawState) {
                        mc.thePlayer.rotationYaw = (float) (mc.thePlayer.rotationYaw - RandomNumber1 + 0.3);
                        Antimony.AutoFishYawState = false;
                    } else {
                        mc.thePlayer.rotationYaw = (float) (mc.thePlayer.rotationYaw - RandomNumber1 - 0.3);
                        Antimony.AutoFishYawState = true;
                    }
                } else if (Tick == 39) {
                    try {
                        Minecraft.getMinecraft().playerController.sendUseItem(Minecraft.getMinecraft().thePlayer, Minecraft.getMinecraft().theWorld, Minecraft.getMinecraft().thePlayer.getHeldItem());
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                    KeyBinding.setKeyBindState(Minecraft.getMinecraft().gameSettings.keyBindSneak.getKeyCode(),false);
                }
                Tick = Tick + 1;
            } else {
                Tick = 40;
            }
        }
    }
    @SubscribeEvent
    public void onPacketReceived(PlaySoundEvent event) throws AWTException {
        if(Minecraft.getMinecraft().theWorld != null) {
            if (FunctionManager.getStatus("AutoFish")) {


                if (event.name.equals("game.player.swim.splash")) {
                    if (AutoFishStatus) {
                        float x = event.result.getXPosF();
                        float y = event.result.getYPosF();
                        float z = event.result.getZPosF();
                        List<EntityFishHook> entities = Minecraft.getMinecraft().theWorld.getEntitiesWithinAABB(EntityFishHook.class, new AxisAlignedBB(x - (0.5 / 2d), y - (0.5 / 2d), z - (0.5 / 2d), x + (0.5 / 2d), y + (0.5 / 2d), z + (0.5 / 2d)), null);
                        for (EntityFishHook entity : entities) {
                            if(entity.angler == Minecraft.getMinecraft().thePlayer) {
                                new AutoFish();
                                AutoFishStatus = false;
                                if (ConfigLoader.getAutoFishNotice()) {
                                    utils.print("钓鱼检测状态:关闭");
                                }
                            }
                        }
                    } else {
                        AutoFishStatus = true;
                        if(ConfigLoader.getAutoFishNotice()) {
                            utils.print("钓鱼检测状态:开启");
                        }
                    }
                }
            }
        }
    }
    @SubscribeEvent
    public void PLayerInteract(PlayerInteractEvent event) {
        if(event.action == PlayerInteractEvent.Action.RIGHT_CLICK_AIR || event.action == PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK) {
            try{
                if (Minecraft.getMinecraft().thePlayer.getHeldItem().getItem() == Items.fishing_rod) {
                    if (AutoFishStatus) {
                        AutoFishStatus = false;
                        if(ConfigLoader.getAutoFishNotice()) {
                            utils.print("钓鱼检测状态:关闭");
                        }
                    }
                }
            } catch(NullPointerException e) {
                e.printStackTrace();
            }
        }
    }
}