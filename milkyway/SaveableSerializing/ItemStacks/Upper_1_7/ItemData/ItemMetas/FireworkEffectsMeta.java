package milkyway.SaveableSerializing.ItemStacks.Upper_1_7.ItemData.ItemMetas;


import milkyway.SaveableSerializing.ItemStacks.Upper_1_7.ItemData.FireworkEffects;
import milkyway.SaveableSerializing.Parser.SaveableData;
import org.bukkit.FireworkEffect;
import org.bukkit.inventory.meta.FireworkEffectMeta;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

/**
 * Created by Developer_Unlocated on 2017-04-18.
 */
public class FireworkEffectsMeta extends SubMeta {
    FireworkEffects me = null;
    @Override
    public void writeBy(StringBuilder  builder) {
        me.appendSubSet(builder);
    }

    @Override
    public void appendTo(List<String> builded) {

    }

    @Override
    public String getName() {
        return "SubMeta-FireworkEffectsMeta";
    }

    @Override
    public void appendObject(String str, SaveableData data) {
        if(data instanceof FireworkEffects)
            me = (FireworkEffects) data;
    }

    @Override
    public SaveableData getNewInstance() {
        return new FireworkEffectsMeta();
    }

    @Override
    public void setTo(ItemMeta meta) {
        if(meta instanceof FireworkEffectMeta){
            FireworkEffectMeta fire = (FireworkEffectMeta) meta;
            FireworkEffect ef = (FireworkEffect) me.getOriginal();
            if(ef != null)
                 fire.setEffect(ef);
        }
    }

    @Override
    public SubMeta setFrom(ItemMeta meta) {
        if(meta instanceof FireworkEffectMeta){
            FireworkEffectMeta fire = (FireworkEffectMeta) meta;
            me = new FireworkEffects(fire.getEffect());
        }
        return this;
    }
}
