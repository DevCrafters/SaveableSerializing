package milkyway.SaveableSerializing.ItemStacks.Lower_1_5_2.ItemData.ItemMetas;

import milkyway.SaveableSerializing.ItemStacks.Lower_1_5_2.PotionEffects;
import milkyway.SaveableSerializing.Parser.SaveableData;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Developer_Unlocated on 2017-04-18.
 */
public class PotionMeta extends SubMeta{
    List<PotionEffects> data = new ArrayList<>();
    @Override
    public void writeBy(StringBuilder builder) {
        for(PotionEffects d : data)
            d.appendSubSet(builder);
    }

    @Override
    public void appendTo(List<String> builded) {

    }

    @Override
    public String getName() {
        return "SubMeta-PotionItemMeta";
    }

    @Override
    public void appendObject(String str, SaveableData data) {
        if(str.equals("PotionItemData"))
            this.data.add((PotionEffects) data);
    }

    @Override
    public void setTo(ItemMeta meta) {
        if(meta instanceof org.bukkit.inventory.meta.PotionMeta){
            org.bukkit.inventory.meta.PotionMeta metar = (org.bukkit.inventory.meta.PotionMeta) meta;
            for(PotionEffects d : data)
                metar.addCustomEffect((PotionEffect)d.getOriginal(),true);
        }
    }

    @Override
    public SubMeta setFrom(ItemMeta meta) {
        if(meta instanceof org.bukkit.inventory.meta.PotionMeta) {
            org.bukkit.inventory.meta.PotionMeta metar = (org.bukkit.inventory.meta.PotionMeta) meta;
            for(PotionEffect ef : metar.getCustomEffects())
                data.add(new PotionEffects(ef));
        }
        return this;
    }

    @Override
    public SaveableData getNewInstance() {
        return new PotionMeta();
    }
}
