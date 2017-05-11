package milkyway.SaveableSerializing.ItemStacks.Lower_1_5_2;

import milkyway.SaveableSerializing.Parser.SaveableData;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

/**
 * Created by Developer_Unlocated on 2017-04-18.
 */
public class PotionEffects implements SaveableData {
    int type;
    int lv;
    int duration;
    public PotionEffects(PotionEffect ef){
        this.type = ef.getType().getId();
        this.lv = ef.getAmplifier();
        this.duration = ef.getDuration();
    }
    public PotionEffects(){}
    @Override
    public void writeBy(StringBuilder builder) {
        builder.append(String.valueOf(type)).append("\n");
        builder.append(String.valueOf(lv)).append("\n");
        builder.append(String.valueOf(duration)).append("\n");
    }

    @Override
    public void appendTo(List<String> builded) {
        try{
            type = Integer.parseInt(builded.get(0));
            lv= Integer.parseInt(builded.get(1));
            duration = Integer.parseInt(builded.get(2));
        }catch (Exception ex){}
    }

    @Override
    public String getName() {
        return "PotionItemData";
    }

    @Override
    public void appendObject(String str, SaveableData data) {

    }

    @Override
    public Object getOriginal() {
        return new PotionEffect(PotionEffectType.getById(type),duration,lv);
    }

    @Override
    public SaveableData getNewInstance() {
        return new PotionEffects();
    }
}
