package milkyway.SaveableSerializing.ItemStacks.Upper_1_7.ItemData.ItemMetas;

import milkyway.SaveableSerializing.ItemStacks.Upper_1_7.DataTypes.ListSaveable;
import milkyway.SaveableSerializing.Java8.Collections.List.SaveableArrayList;
import milkyway.SaveableSerializing.Java8.Exceptions.CollectionsNullException;
import milkyway.SaveableSerializing.Java8.Exceptions.TypeNotSupportedException;
import milkyway.SaveableSerializing.Parser.SaveableData;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.meta.*;
import org.bukkit.inventory.meta.PotionMeta;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Developer_Unlocated on 2017-04-17.
 */
public class DefaultMeta implements SaveableData{
    String display = null;
    List<String> lore = new ArrayList<>();
    SubMeta meta = null;
    List<String> flag = new ArrayList<>();
    public DefaultMeta(ItemMeta m){
        if(m instanceof BookMeta)
            meta = new SaveableBookMeta().setFrom(m);
        else if(m instanceof PotionMeta)
            meta = new milkyway.SaveableSerializing.ItemStacks.Upper_1_7.ItemData.ItemMetas.PotionMeta().setFrom(m);
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
            try{
                for(ItemFlag flag : m.getItemFlags())
                    this.flag.add(flag.name());
            }catch (Exception ex)
            {}
        }

    }
    public DefaultMeta(){}
    @Override
    public void writeBy(StringBuilder  builder) {
        if(display != null)
        builder.append(display).append("\n");
        new ListSaveable(lore).appendSubSet(builder);
        try {
            new SaveableArrayList(flag).appendSubSet(builder);
        } catch (CollectionsNullException e) {
            e.printStackTrace();
        } catch (TypeNotSupportedException e) {
            e.printStackTrace();
        }
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
        }else if(str.equals("Java8_SaveableArrayList"))
            flag = (List<String>) data.getOriginal();
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
        try{
            for(String n : flag)
                meta.addItemFlags(ItemFlag.valueOf(n));
        }catch (Exception ex){}
        if(this.meta != null)
            this.meta.setTo(meta);

    }
}
