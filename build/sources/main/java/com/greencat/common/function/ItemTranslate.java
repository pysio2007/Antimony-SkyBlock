package com.greencat.common.function;

import com.greencat.common.FunctionManager.FunctionManager;
import com.greencat.type.CheckableValue;
import net.minecraft.client.Minecraft;
import scala.tools.nsc.typechecker.Checkable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemTranslate {
    static HashMap<String,String> cacheMap = new HashMap<String, String>();
    public static HashMap<String,String> HighLevelMapping = new HashMap<String,String>();
    public static HashMap<String,String> normalMapping = new HashMap<String,String>();
    public ItemTranslate(){
        HighLevelMapping.put("Golden","黄金");
        HighLevelMapping.put("SkyBlock","空岛生存");
        HighLevelMapping.put("Gemstones","宝石");
        HighLevelMapping.put("Withered","凋灵的");
        HighLevelMapping.put("Overflux","过流");
        HighLevelMapping.put("Spiritual","精神灌注");
        HighLevelMapping.put("Superior","卓越的");
        HighLevelMapping.put("Hardened","硬化的");
        HighLevelMapping.put("Ender","末影");
        HighLevelMapping.put("Personal","个人的");
        HighLevelMapping.put("Titanium","钛");
        HighLevelMapping.put("Management","管理");
        HighLevelMapping.put("Wooden","木制的");
        HighLevelMapping.put("Leaping","飞跃");
        HighLevelMapping.put("Aspect of the End","末影之环");
        HighLevelMapping.put("Aspect of the Dragons","龙之印记");
        HighLevelMapping.put("Aspect of the Void","虚空之征");
        HighLevelMapping.put("Aspect of the Jerry","最强武器杰瑞剑");
        HighLevelMapping.put("Axe of the Shredded","碎裂之斧");
        HighLevelMapping.put("Hyperion","神之刃-[许珀里翁]");
        HighLevelMapping.put("Astraea","神之刃-[阿斯特拉]");
        HighLevelMapping.put("Scylla","神之刃-[锡拉]");
        HighLevelMapping.put("Valkyrie","神之刃-[瓦尔基里]");
        HighLevelMapping.put("Dark Claymore","黑暗克莱莫");
        HighLevelMapping.put("Goldor","戈尔多");
        HighLevelMapping.put("Manage","管理");
        HighLevelMapping.put("Berserker","狂暴战士");
        HighLevelMapping.put("Soulstealer","灵魂窃取者");
        HighLevelMapping.put("Fishing","钓鱼");
        HighLevelMapping.put("Skeletor","骷髅");
        HighLevelMapping.put("Start","开始");
        HighLevelMapping.put("Mineral","矿物");
        HighLevelMapping.put("Fairy Souls","仙女魂");


        normalMapping.put("Helmet","头盔");
        normalMapping.put("Chestplate","胸甲");
        normalMapping.put("Leggings","护腿");
        normalMapping.put("Boots","鞋子");
        normalMapping.put("'s","的");
        normalMapping.put("Maxor","麦克索");
        normalMapping.put("Storm","风暴");
        normalMapping.put("Necron","死灵");
        normalMapping.put("Lord","领主");
        normalMapping.put("Necromancer","死灵法师");
        normalMapping.put("Frozen","冰冻");
        normalMapping.put("Blaze","烈焰人");
        normalMapping.put("Scythe","镰刀");
        normalMapping.put("Summoning","召唤");
        normalMapping.put("Ring","戒指");
        normalMapping.put("Sword","剑");
        normalMapping.put("Bow","弓");
        normalMapping.put("Axe","斧");
        normalMapping.put("Shovel","铲");
        normalMapping.put("Hoe","锄");
        normalMapping.put("Shortbow","短弓");
        normalMapping.put("Soul","灵魂");
        normalMapping.put("Whip","鞭子");
        normalMapping.put("Jade","翡翠");
        normalMapping.put("Amber","黄玉");
        normalMapping.put("Amethyst","紫晶");
        normalMapping.put("Ruby","红玉");
        normalMapping.put("Sapphire","蓝晶");
        normalMapping.put("Jasper","碧玉");
        normalMapping.put("Topaz","黄玉");
        normalMapping.put("Opal","蛋白");
        normalMapping.put("Gemstone","宝石");
        normalMapping.put("Rough","粗糙的");
        normalMapping.put("Flawed","有缺陷的");
        normalMapping.put("Fine","良好的");
        normalMapping.put("Flawless","无瑕的");
        normalMapping.put("Perfect","完美的");
        normalMapping.put("Enchanted","附魔的");
        normalMapping.put("Block","方块");
        normalMapping.put("Coal","煤炭");
        normalMapping.put("Iron","铁");
        normalMapping.put("Gold","金");
        normalMapping.put("Redstone","红石");
        normalMapping.put("Lapis Lazuli","青金石");
        normalMapping.put("Emerald","绿宝石");
        normalMapping.put("Diamond","钻石");
        normalMapping.put("Obsidian","黑曜石");
        normalMapping.put("Mithril","秘银");
        normalMapping.put("Hard","硬的");
        normalMapping.put("Wither","凋灵");
        normalMapping.put("Cloak","披风");
        normalMapping.put("Magma","岩浆");
        normalMapping.put("Necklace","项链");
        normalMapping.put("Belt","腰带");
        normalMapping.put("Bonzo","邦佐");
        normalMapping.put("The Professor","教授");
        normalMapping.put("Thorn","索恩");
        normalMapping.put("Livid","李维德");
        normalMapping.put("Dagger","匕首");
        normalMapping.put("Ice","冰");
        normalMapping.put("Bucket","桶");
        normalMapping.put("Water","水");
        normalMapping.put("Lava","熔岩");
        normalMapping.put("Magical","有魔力的");
        normalMapping.put("Power","能量");
        normalMapping.put("Orb","宝珠");
        normalMapping.put("Mana","法力");
        normalMapping.put("Flux","通量");
        normalMapping.put("Spirit","精神");
        normalMapping.put("Capacitor","电容");
        normalMapping.put("Core","核心");
        normalMapping.put("Mask","面具");
        normalMapping.put("fish","鱼");
        normalMapping.put("Fish","鱼");
        normalMapping.put("Experience","经验");
        normalMapping.put("Bottle","瓶子");
        normalMapping.put("Grand","宏伟的");
        normalMapping.put("Titanic","泰坦");
        normalMapping.put("Upgrade","升级");
        normalMapping.put("Minion","仆从");
        normalMapping.put("Stone","石头");
        normalMapping.put("Fragment","碎片");
        normalMapping.put("Dragon","龙");
        normalMapping.put("Unstable","不稳定的");
        normalMapping.put("Young","年轻的");
        normalMapping.put("Old","年老的");
        normalMapping.put("Strong","强壮的");
        normalMapping.put("Wise","有智慧的");
        normalMapping.put("Holy","神圣的");
        normalMapping.put("Protector","保护者");
        normalMapping.put("Adaptive","自适应的");
        normalMapping.put("Bat","蝙蝠");
        normalMapping.put("Person","人");
        normalMapping.put("Artifact","圣物");
        normalMapping.put("Relic","遗物");
        normalMapping.put("Compactor","压缩器");
        normalMapping.put("Deletor","销毁器");
        normalMapping.put("Crystal","水晶");
        normalMapping.put("Talisman","护身符");
        normalMapping.put("Ancient","远古的");
        normalMapping.put("Giant","巨大的");
        normalMapping.put("Necrotic","腐败的");
        normalMapping.put("Loving","有爱的");
        normalMapping.put("Refined","精炼的");
        normalMapping.put("Gentle","温和的");
        normalMapping.put("Fast","快速的");
        normalMapping.put("Fair","公平的");
        normalMapping.put("Epic","史诗的");
        normalMapping.put("Sharp","锋利的");
        normalMapping.put("Heroic","英勇的");
        normalMapping.put("Spicy","火辣的");
        normalMapping.put("Legendary","传奇的");
        normalMapping.put("Dirty","脏的");
        normalMapping.put("Fabled","传神的");
        normalMapping.put("Suspicious","可疑的");
        normalMapping.put("Gilded","镀金的");
        normalMapping.put("Warped","扭曲的");
        normalMapping.put("Bulky","庞大的");
        normalMapping.put("Salty","咸的");
        normalMapping.put("Treacherous","危险的");
        normalMapping.put("Lucky","幸运的");
        normalMapping.put("Very","更加的");
        normalMapping.put("Highly","更高级的");
        normalMapping.put("Extremely","非常");
        normalMapping.put("Not so","不像那么");
        normalMapping.put("absolutely","完全的");
        normalMapping.put("Even More","甚至更加");
        normalMapping.put("Hasty","轻率的");
        normalMapping.put("Deadly","逝去的");
        normalMapping.put("Rapid","快速的");
        normalMapping.put("Precise","精确的");
        normalMapping.put("Clean","干净的");
        normalMapping.put("Fierce","凶猛的");
        normalMapping.put("Heavy","沉重的");
        normalMapping.put("Super","超级");
        normalMapping.put("Light","轻盈的");
        normalMapping.put("Renowned","有名的");
        normalMapping.put("Submerged","水下的");
        normalMapping.put("Eye","眼");
        normalMapping.put("Lapis","青金石");
        normalMapping.put("Armor","装甲");
        normalMapping.put("Ember","余烬");
        normalMapping.put("Bronze","铜");
        normalMapping.put("Hunter","猎手");
        normalMapping.put("Golem","铁傀儡");
        normalMapping.put("Miner","矿工");
        normalMapping.put("Fairy","仙女");
        normalMapping.put("Salmon","鲑鱼");
        normalMapping.put("Goblin","哥布林");
        normalMapping.put("Heat","热");
        normalMapping.put("Silver","银");
        normalMapping.put("Zombie","僵尸");
        normalMapping.put("End","末地");
        normalMapping.put("Tuxedo","礼服");
        normalMapping.put("Sponge","海绵");
        normalMapping.put("Mastiff","獒");
        normalMapping.put("Tarantula","狼蛛");
        normalMapping.put("Revenant","归来者");
        normalMapping.put("Spooky","毛骨悚然的");
        normalMapping.put("Snow","雪");
        normalMapping.put("Great","伟大的");
        normalMapping.put("Spook","幽灵");
        normalMapping.put("Berserk","狂暴战士");
        normalMapping.put("Mage","法师");
        normalMapping.put("Healer","治疗者");
        normalMapping.put("Archer","弓箭手");
        normalMapping.put("Tank","坦克");
        normalMapping.put("Thunder","雷暴");
        normalMapping.put("Shark Scale","鲨鱼");
        normalMapping.put("Diver","潜水者");
        normalMapping.put("Werewolf","狼人");
        normalMapping.put("Sorrow","忧伤");
        normalMapping.put("Reaper","死神");
        normalMapping.put("Final Destination","终末旅途");
        normalMapping.put("Divan","迪万");
        normalMapping.put("Crimson","深红");
        normalMapping.put("Aurora","极光");
        normalMapping.put("Staff","法杖");
        normalMapping.put("Gun","枪");
        normalMapping.put("Fervor","炽热");
        normalMapping.put("Terror","恐怖");
        normalMapping.put("Head","头饰");
        normalMapping.put("Hat","帽子");
        normalMapping.put("Slime","史莱姆");
        normalMapping.put("Chicken","鸡");
        normalMapping.put("Cow","牛");
        normalMapping.put("Pig","猪");
        normalMapping.put("Sheep","羊");
        normalMapping.put("Tiger","老虎");
        normalMapping.put("Lion","狮子");
        normalMapping.put("Skeleton","骷髅");
        normalMapping.put("Grunt","员工");
        normalMapping.put("Spider","蜘蛛");
        normalMapping.put("Squid","鱿鱼");
        normalMapping.put("Creeper","爬行者");
        normalMapping.put("Ghast","恶魂");
        normalMapping.put("Cube","立方");
        normalMapping.put("man","人");
        normalMapping.put("Pure","纯洁的");
        normalMapping.put("Master","大师");
        normalMapping.put("Star","星星");
        normalMapping.put("Chunk","区块");
        normalMapping.put("Book","书");
        normalMapping.put("Profile","档案");
        normalMapping.put("Go Back","返回");
        normalMapping.put("Witch","女巫");
        normalMapping.put("Kuudra","库德拉");
        normalMapping.put("Follower","追随者");
        normalMapping.put("Key","钥匙");
        normalMapping.put("Heart","心");
        normalMapping.put("Dungeon","地牢");
        normalMapping.put("Potion","药水");
        normalMapping.put("Cookie","曲奇");
        normalMapping.put("Wand","权杖");
        normalMapping.put("Jerry","杰瑞");
        normalMapping.put("Fancy","幻想");
        normalMapping.put("Rogue","盗贼");
        normalMapping.put("Undead","不死的");
        normalMapping.put("Cleaver","砍刀");
        normalMapping.put("Squire","侍从");
        normalMapping.put("Flaming","炽盛");
        normalMapping.put("Knife","刀");
        normalMapping.put("Prismarine","海鳞");
        normalMapping.put("Katana","武士刀");
        normalMapping.put("Voidwalker","虚空行者");
        normalMapping.put("Raider","入侵者");
        normalMapping.put("Firedust","火炬");
        normalMapping.put("Twilight","暮色");
        normalMapping.put("Edible","可食用的");
        normalMapping.put("Mace","狼牙棒");
        normalMapping.put("Voidedge","虚空之境");
        normalMapping.put("Blade","利刃");
        normalMapping.put("Fire","火焰");
        normalMapping.put("Rod","杆");
        normalMapping.put("Scorpion","蝎子");
        normalMapping.put("Foil","铝箔刃");
        normalMapping.put("Shaman","召唤师");
        normalMapping.put("Ornate","华丽的");
        normalMapping.put("Ink","墨囊");
        normalMapping.put("Leap","飞跃");
        normalMapping.put("boom","爆炸");
        normalMapping.put("TNT","炸弹");
        normalMapping.put("Vorpal","虚空之核");
        normalMapping.put("Revelations","启示");
        normalMapping.put("Thick","厚重的");
        normalMapping.put("Midas","迈达斯");
        normalMapping.put("Ghoul","食尸鬼");
        normalMapping.put("Buster","克星");
        normalMapping.put("Yeti","雪人");
        normalMapping.put("Baby","小");
        normalMapping.put("Snowman","雪人");
        normalMapping.put("Silk-Edge","丝绸之缘");
        normalMapping.put("Gauntlet","护手");
        normalMapping.put("Daedalus","代达罗斯");
        normalMapping.put("Phantom","幻影");
        normalMapping.put("Pigman","猪人");
        normalMapping.put("Atomsplit","原子分裂");
        normalMapping.put("Dreadlord","恐惧领主");
        normalMapping.put("Soldier","士兵");
        normalMapping.put("Cutlass","弯刀");
        normalMapping.put("Silent","寂静");
        normalMapping.put("Death","死亡");
        normalMapping.put("Conjuring","魔术");
        normalMapping.put("Commander","指挥官");
        normalMapping.put("Hyper","超级");
        normalMapping.put("Knight","骑士");
        normalMapping.put("Sceptre","权杖");
        normalMapping.put("Spray","喷雾");
        normalMapping.put("Shadow","暗影");
        normalMapping.put("Assassin","刺客");
        normalMapping.put("Fury","狂怒");
        normalMapping.put("Artisanal","木匠");
        normalMapping.put("Machine","机械");
        normalMapping.put("Sniper","狙击手");
        normalMapping.put("Explosive","爆炸");
        normalMapping.put("Hurricane","飓风");
        normalMapping.put("Queen","女王");
        normalMapping.put("Stinger","毒刺");
        normalMapping.put("Rebound","反弹");
        normalMapping.put("Bonemerang","骨之回响");
        normalMapping.put("Last","最终");
        normalMapping.put("Breath","呼吸");
        normalMapping.put("Terminator","终结者之弓");
        normalMapping.put("Rabbit","兔子");
    }
    public String modifyName(String CustomName){
        if(FunctionManager.getStatus("ItemTranslate")) {
            CheckableValue checkableValue = getNameByCache(CustomName);
            if(!checkableValue.check) {
                String modifiedName = CustomName;
                for (Map.Entry<String,String> nameMapping : HighLevelMapping.entrySet()) {
                    modifiedName = modifiedName.replace(nameMapping.getKey(), nameMapping.getValue());
                }
                for (Map.Entry<String,String> nameMapping : normalMapping.entrySet()) {
                    modifiedName = modifiedName.replace(nameMapping.getKey(), nameMapping.getValue());
                }
                if(cacheMap.size() + 1 > 30){
                    cacheMap.clear();
                }
                cacheMap.put(CustomName,modifiedName);
                return modifiedName;
            } else {
                return checkableValue.value;
            }
        }
        return CustomName;
    }
    private CheckableValue getNameByCache(String originalName){
        boolean findValue = false;
        String value = null;
        if(!cacheMap.isEmpty()) {
            for (Map.Entry<String, String> entry : cacheMap.entrySet()) {
                if (entry.getKey().equals(originalName)) {
                    value = entry.getValue();
                    findValue = true;
                    return new CheckableValue(value, findValue);
                }
            }
        }
        return new CheckableValue(value,findValue);
    }
}
