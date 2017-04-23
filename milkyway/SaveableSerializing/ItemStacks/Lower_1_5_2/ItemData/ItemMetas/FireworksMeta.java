package milkyway.ItemManagerAdvanced.ItemStacks.Lower_1_5_2.ItemData.ItemMetas;

import milkyway.ItemManagerAdvanced.Datas.ItemData.FireworkEffects;
import milkyway.ItemManagerAdvanced.Datas.SaveableData;
import org.bukkit.FireworkEffect;
import org.bukkit.inventory.meta.FireworkEffectMeta;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Developer_Unlocated on 2017-04-18.
 */
public class FireworksMeta extends SubMeta{
    List<FireworkEffects> facts = new ArrayList<>();
    int power = 0;
    @Override
    public void writeBy(BufferedWriter builder) throws IOException {
        builder.append(String.valueOf(power)).append("\n");
        for(FireworkEffects a : facts)
            a.appendSubSet(builder);
    }

    @Override
    public void appendTo(List<String> builded) {
        try{
            power = Integer.parseInt(builded.get(0));
        }catch (Exception ex){}
    }

    @Override
    public String getName() {
        return "SubMeta-Fireworks";
    }

    @Override
    public void appendObject(String str, SaveableData data) {
        if(data instanceof FireworkEffects)
            facts.add((FireworkEffects) data);
    }

    @Override
    public SaveableData getNewInstance() {
        return new FireworksMeta();
    }

    @Override
    public void setTo(ItemMeta meta) {
        if(meta instanceof FireworkMeta){
            FireworkMeta metas = (FireworkMeta) meta;
            metas.setPower(power);
            for(FireworkEffects a : facts)
            metas.addEffect((FireworkEffect) a.getOriginal());
        }
    }

    @Override
    public SubMeta setFrom(ItemMeta meta) {
        if(meta instanceof FireworkMeta){
            FireworkMeta metas = (FireworkMeta) meta;
            power = metas.getPower();
            for(FireworkEffect eff : metas.getEffects())
                facts.add(new FireworkEffects(eff));
        }
        return this;
    }
}
