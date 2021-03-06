package milkyway.SaveableSerializing.ItemStacks.Upper_1_7.ItemData;


import milkyway.SaveableSerializing.ItemStacks.Upper_1_7.ItemData.ItemMetas.DefaultMeta;
import milkyway.SaveableSerializing.Parser.SaveableData;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Developer_Unlocated on 2017-04-17.
 */
public class ItemStacks implements SaveableData {
    DefaultMeta meta;
    int id = 0;
    int durability = 0;
    EnchantArray array;
    int amount = 0;

    public ItemStacks(ItemStack sta){
        meta = new DefaultMeta(sta.getItemMeta());
        id = sta.getTypeId();
        durability = sta.getDurability();
        amount = sta.getAmount();
        array = new EnchantArray(sta);

    }
    public ItemStacks(){}
    @Override
    public void writeBy(StringBuilder builder) {
        builder.append(String.valueOf(id)).append("\n").append(String.valueOf(durability)).append("\n").append(String.valueOf(amount)).append("\n");
        array.appendSubSet(builder);
        meta.appendSubSet(builder);
    }

    @Override
    public void appendTo(List<String> builded) {
        try{
            id = Integer.parseInt(builded.get(0));
            durability = Integer.parseInt(builded.get(1));
            amount = Integer.parseInt(builded.get(2));
        }catch (Exception e){}
    }

    @Override
    public String getName() {
        return "ItemStack";
    }

    @Override
    public void appendObject(String str, SaveableData data) {
        if(str.equals("EnchantArray"))
            array = (EnchantArray) data;
        else
            meta = (DefaultMeta) data;
    }

    @Override
    public Object getOriginal() {
        ItemStack sta = new ItemStack(Material.getMaterial(id));
        ItemMeta meta = sta.getItemMeta();
        if(meta != null)
            ((DefaultMeta)this.meta).setToMeta(meta);
        sta.setItemMeta(meta);
        sta.setDurability((short) durability);
        sta.setAmount(amount);

        (array).setToItemStack(sta);
        return sta;
    }

    @Override
    public SaveableData getNewInstance() {
        return new ItemStacks();
    }
}
