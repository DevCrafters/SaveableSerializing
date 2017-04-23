package milkyway.ItemManagerAdvanced.ItemStacks.Lower_1_5_2.ItemData.ItemMetas;

import milkyway.ItemManagerAdvanced.Datas.ItemData.FireworkEffects;
import milkyway.ItemManagerAdvanced.Datas.SaveableData;
import org.bukkit.FireworkEffect;
import org.bukkit.inventory.meta.FireworkEffectMeta;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

/**
 * Created by Developer_Unlocated on 2017-04-18.
 */
public class FireworkEffectsMeta extends SubMeta{
    FireworkEffects me = null;
    @Override
    public void writeBy(BufferedWriter builder) throws IOException {
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
            fire.setEffect((FireworkEffect) me.getOriginal());
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
