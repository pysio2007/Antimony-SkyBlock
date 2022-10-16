package com.greencat.common.key;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import org.lwjgl.input.Keyboard;

public class KeyLoader {
    public static KeyBinding SelectGuiUP;
    public static KeyBinding SelectGuiDown;
    public static KeyBinding SelectGuiEnter;
    public static KeyBinding SelectGuiBack;

    public static KeyBinding OpenClickGUI;

    public static KeyBinding GhostBlock;
    public static KeyBinding SwitchVelocity;
    public static KeyBinding InstantSwitch;
    public static KeyBinding SwitchSecretBot;

    public static KeyBinding HugeScreenshot;

    public KeyLoader()
    {
        KeyLoader.SelectGuiUP = new KeyBinding("Antimony SelectGui上移", Keyboard.KEY_UP, "Antimony-SkyBlock");
        KeyLoader.SelectGuiDown = new KeyBinding("Antimony SelectGui下移", Keyboard.KEY_DOWN, "Antimony-SkyBlock");
        KeyLoader.SelectGuiEnter = new KeyBinding("Antimony SelectGui选中", Keyboard.KEY_RIGHT, "Antimony-SkyBlock");
        KeyLoader.SelectGuiBack = new KeyBinding("Antimony SelectGui返回初级菜单", Keyboard.KEY_LEFT, "Antimony-SkyBlock");

        KeyLoader.OpenClickGUI= new KeyBinding("Antimony 打开ClickGUI", Keyboard.KEY_RSHIFT, "Antimony-SkyBlock");

        KeyLoader.GhostBlock = new KeyBinding("创建Air Ghost Block", Keyboard.KEY_G, "Antimony-SkyBlock");
        KeyLoader.SwitchVelocity = new KeyBinding("Velocity快捷开关", Keyboard.KEY_V, "Antimony-SkyBlock");
        KeyLoader.SwitchSecretBot = new KeyBinding("SecretBot快捷开关", Keyboard.KEY_U, "Antimony-SkyBlock");
        KeyLoader.InstantSwitch = new KeyBinding("使用InstantSwitch", Keyboard.KEY_R, "Antimony-SkyBlock");


        KeyLoader.HugeScreenshot = new KeyBinding("大型截图", Keyboard.KEY_NUMPAD2, "Antimony-SkyBlock");

        ClientRegistry.registerKeyBinding(KeyLoader.SelectGuiUP);
        ClientRegistry.registerKeyBinding(KeyLoader.SelectGuiDown);
        ClientRegistry.registerKeyBinding(KeyLoader.SelectGuiEnter);
        ClientRegistry.registerKeyBinding(KeyLoader.SelectGuiBack);

        ClientRegistry.registerKeyBinding(KeyLoader.GhostBlock);
        ClientRegistry.registerKeyBinding(KeyLoader.SwitchVelocity);
        ClientRegistry.registerKeyBinding(KeyLoader.SwitchSecretBot);
        ClientRegistry.registerKeyBinding(KeyLoader.InstantSwitch);

        ClientRegistry.registerKeyBinding(KeyLoader.OpenClickGUI);


        ClientRegistry.registerKeyBinding(KeyLoader.HugeScreenshot);
    }
}
