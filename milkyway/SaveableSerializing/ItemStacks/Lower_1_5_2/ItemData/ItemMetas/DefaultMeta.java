package milkyway.SaveableSerializing.ItemStacks.Lower_1_5_2.ItemData.ItemMetas;

import milkyway.SaveableSerializing.ItemStacks.Lower_1_5_2.DataTypes.ListSaveable;
import milkyway.SaveableSerializing.Parser.SaveableData;
import org.bukkit.inventory.meta.*;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Developer_Unlocated on 2017-04-17.
 */
public class DefaultMeta implements SaveableData{
    String display = null;
    List<String> lore = new ArrayList<>();
    SubMeta meta = null;
    public DefaultMeta(ItemMeta m){
        if(m instanceof BookMeta)
            meta = new SaveableBookMeta().setFrom(m);
        else if(m instanceof org.bukkit.inventory.meta.PotionMeta)
            meta = new PotionMeta().setFrom(m);
        else if(m instanceof SkullMeta)
            meta = new HeadMeta().setFrom(m);
        else if(m instanceof FireworkMeta)
            meta = new FireworksMeta().setFrom(m);
        else if (m instanceof LeatherArmorMeta)
            meta = new LeatherArmoursMeta().setFrom(m);
        else if(m instanceof EnchantmentStorageMeta)
            meta = new SaveableEnchantBook().setFrom(m);
        else if(m instanceof FireworkEffectMeta)
            meta = new FireworkEffectsMeta().setFrom(m);
        if(m != null){
            display = m.getDisplayName();
            if(m.hasLore())
                lore = m.getLore();
        }
    }
    public DefaultMeta(){}
    @Override
    public void writeBy(BufferedWriter builder) throws IOException {
        if(display != null)
        builder.append(display).append("\n");
        new ListSaveable(lore).appendSubSet(builder);
        if(meta != null)
            meta.appendSubSet(builder);

    }

    @Override
    public void appendTo(List<String> builded) {
        if(builded.size() >= 1)
            display = builded.get(0);
    }

    @Override
    public String getName() {
        return "ItemMeta";
    }

    @Override
    public void appendObject(String str, SaveableData data) {
        if(data instanceof SubMeta)
            meta = (SubMeta) data;
        else if(str.equals("List")){
            lore = ((ListSaveable)data).data;
        }
    }

    @Override
    public Object getOriginal() {
        return null;
    }

    @Override
    public SaveableData getNewInstance() {
        return new DefaultMeta();
    }

    public void setToMeta(ItemMeta meta){
        meta.setDisplayName(display);
        meta.setLore(lore);
        if(this.meta != null)
            this.meta.setTo(meta);

    }
}
