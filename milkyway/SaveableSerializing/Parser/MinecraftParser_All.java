package milkyway.SaveableSerializing.Parser;

import milkyway.SaveableSerializing.ItemStacks.Upper_1_7.DataTypes.ListRGB;
import milkyway.SaveableSerializing.ItemStacks.Upper_1_7.DataTypes.ListSaveable;
import milkyway.SaveableSerializing.ItemStacks.Upper_1_7.DataTypes.RGBColor;
import milkyway.SaveableSerializing.ItemStacks.Upper_1_7.ItemData.EnchantArray;
import milkyway.SaveableSerializing.ItemStacks.Upper_1_7.ItemData.Enchants;
import milkyway.SaveableSerializing.ItemStacks.Upper_1_7.ItemData.FireworkEffects;
import milkyway.SaveableSerializing.ItemStacks.Upper_1_7.ItemData.ItemMetas.*;
import milkyway.SaveableSerializing.ItemStacks.Upper_1_7.ItemData.ItemStacks;
import milkyway.SaveableSerializing.ItemStacks.Upper_1_7.PotionEffects;

/**
 * Created by Developer_Unlocated on 2017-05-08.
 *
 * 이 클래스는 마인크래프트 모든 버전의 아이템을 저장합니다.
 *
 * This class will be register instance of Minecraft ItemStack lower than 1.5.2.
 */
public class MinecraftParser_All implements ParserRegistry{
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
