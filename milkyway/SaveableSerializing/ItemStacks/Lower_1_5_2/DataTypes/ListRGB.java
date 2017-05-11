package milkyway.SaveableSerializing.ItemStacks.Lower_1_5_2.DataTypes;

import milkyway.SaveableSerializing.Parser.SaveableData;
import org.bukkit.Color;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Developer_Unlocated on 2017-04-18.
 */
public class ListRGB implements SaveableData{
    public ListRGB(){}
    List<RGBColor> color = new ArrayList<>();
    public ListRGB(List<RGBColor> cols,boolean trashValue){
        color = cols;
    }
    public ListRGB(List<Color> cols){
        for(Color colors : cols)
            color.add(new RGBColor(colors));
    }
    @Override
    public void writeBy(StringBuilder  builder) {
        for(RGBColor colors : color)
            colors.appendSubSet(builder);
    }

    @Override
    public void appendTo(List<String> builded) {

    }

    @Override
    public String getName() {
        return "RGBArray";
    }
    @Override
    public void appendObject(String str, SaveableData data) {
        if(str.equals("RGBColor"))
            color.add((RGBColor) data);
    }

    @Override
    public Object getOriginal() {
        List<Color> colors = new ArrayList<>();
       for(RGBColor temp : color)
           colors.add((Color) temp.getOriginal());

        return colors;

    }

    @Override
    public SaveableData getNewInstance() {
        return new ListRGB();
    }
}
