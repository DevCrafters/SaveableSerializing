package milkyway.SaveableSerializing.ItemStacks.Lower_1_5_2.ItemData.ItemMetas;


import milkyway.SaveableSerializing.ItemStacks.Lower_1_5_2.DataTypes.RGBColor;
import milkyway.SaveableSerializing.Parser.SaveableData;
import org.bukkit.Color;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

/**
 * Created by Developer_Unlocated on 2017-04-18.
 */
public class LeatherArmoursMeta extends SubMeta{
    RGBColor color = new RGBColor(Color.BLACK);
    @Override
    public void writeBy(StringBuilder builder) throws IOException {
        color.appendSubSet(builder);
    }

    @Override
    public void appendTo(List<String> builded) {

    }

    @Override
    public String getName() {
        return "SubMeta-LeatherArmour";
    }

    @Override
    public void appendObject(String str, SaveableData data) {
        if(data instanceof RGBColor)
            color = (RGBColor) data;
    }

    @Override
    public SaveableData getNewInstance() {
        return new LeatherArmoursMeta();
    }

    @Override
    public void setTo(ItemMeta meta) {
        if(meta instanceof LeatherArmorMeta){
            ((LeatherArmorMeta)meta).setColor((Color) color.getOriginal());
        }
    }

    @Override
    public SubMeta setFrom(ItemMeta meta) {
        if(meta instanceof LeatherArmorMeta){
            color = new RGBColor(((LeatherArmorMeta)meta).getColor());
        }
        return this;
    }
}
