package milkyway.SaveableSerializing.ItemStacks.Upper_1_7.ItemData.ItemMetas;

import milkyway.SaveableSerializing.ItemStacks.Upper_1_7.ItemData.Enchants;
import milkyway.SaveableSerializing.Parser.SaveableData;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Developer_Unlocated on 2017-04-17.
 */
public class SaveableEnchantBook extends SubMeta {
    List<Enchants> array = new ArrayList<>();
    @Override
    public void writeBy(StringBuilder builder) {
        for(Enchants b : array)
            b.appendSubSet(builder);
    }

    @Override
    public void appendTo(List<String> builded) {

    }

    @Override
    public String getName() {
        return "SubMeta-EnchantedBookMeta";
    }

    @Override
    public void appendObject(String str, SaveableData data) {
        if(str.equals("Enchant"))
            array.add((Enchants) data);
    }

    @Override
    public SaveableData getNewInstance() {
        return new SaveableEnchantBook();
    }

    @Override
    public void setTo(ItemMeta meta) {
        if(meta instanceof EnchantmentStorageMeta){
            EnchantmentStorageMeta enc = (EnchantmentStorageMeta) meta;
            for(Enchants a : array)
            {
                Enchantment ment = Enchantment.getById(a.id);
                if(ment != null)
                    enc.addStoredEnchant(ment,a.level,true);
            }
        }
    }

    @Override
    public SubMeta setFrom(ItemMeta meta) {
        if(meta instanceof EnchantmentStorageMeta){
            EnchantmentStorageMeta enc = (EnchantmentStorageMeta) meta;
            for(Enchantment a : enc.getStoredEnchants().keySet())
                array.add(new Enchants(a,enc.getStoredEnchants().get(a)));
        }
        return this;
    }
}
