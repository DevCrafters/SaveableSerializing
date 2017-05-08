package milkyway.SaveableSerializing.Parser;

import milkyway.SaveableSerializing.ItemStacks.Lower_1_5_2.DataTypes.ListRGB;
import milkyway.SaveableSerializing.ItemStacks.Lower_1_5_2.DataTypes.ListSaveable;
import milkyway.SaveableSerializing.ItemStacks.Lower_1_5_2.DataTypes.RGBColor;
import milkyway.SaveableSerializing.ItemStacks.Lower_1_5_2.ItemData.EnchantArray;
import milkyway.SaveableSerializing.ItemStacks.Lower_1_5_2.ItemData.Enchants;
import milkyway.SaveableSerializing.ItemStacks.Lower_1_5_2.ItemData.FireworkEffects;
import milkyway.SaveableSerializing.ItemStacks.Lower_1_5_2.ItemData.ItemMetas.*;
import milkyway.SaveableSerializing.ItemStacks.Lower_1_5_2.ItemData.ItemStacks;
import milkyway.SaveableSerializing.ItemStacks.Lower_1_5_2.PotionEffects;

/**
 * Created by Developer_Unlocated on 2017-05-08.
 *
 * 이 클래스는 마인크래프트 1.5.2 이하의 아이템스택을 저장하는 기본 요소들의 인스턴스를 등록해줍니다.
 *
 * This class will be register instance of Minecraft ItemStack lower than 1.5.2.
 */
public class MinecraftParser_Lower152 implements ParserRegistry{
    @Override
    public void register() {
        StaticSaveableDataRegistry.getHandle().registerSaveable(new ListRGB());
        StaticSaveableDataRegistry.getHandle().registerSaveable(new ListSaveable());
        StaticSaveableDataRegistry.getHandle().registerSaveable(new RGBColor());
        StaticSaveableDataRegistry.getHandle().registerSaveable(new DefaultMeta());
        StaticSaveableDataRegistry.getHandle().registerSaveable(new FireworkEffectsMeta());
        StaticSaveableDataRegistry.getHandle().registerSaveable(new FireworksMeta());
        StaticSaveableDataRegistry.getHandle().registerSaveable(new HeadMeta());
        StaticSaveableDataRegistry.getHandle().registerSaveable(new LeatherArmoursMeta());
        StaticSaveableDataRegistry.getHandle().registerSaveable(new PotionMeta());
        StaticSaveableDataRegistry.getHandle().registerSaveable(new SaveableBookMeta());
        StaticSaveableDataRegistry.getHandle().registerSaveable(new SaveableEnchantBook());
        StaticSaveableDataRegistry.getHandle().registerSaveable(new EnchantArray());
        StaticSaveableDataRegistry.getHandle().registerSaveable(new Enchants());
        StaticSaveableDataRegistry.getHandle().registerSaveable(new FireworkEffects());
        StaticSaveableDataRegistry.getHandle().registerSaveable(new ItemStacks());
        StaticSaveableDataRegistry.getHandle().registerSaveable(new NullSaveableData());
        StaticSaveableDataRegistry.getHandle().registerSaveable(new PotionEffects());
    }
}
