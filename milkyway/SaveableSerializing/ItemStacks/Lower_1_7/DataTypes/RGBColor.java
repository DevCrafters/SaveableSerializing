package milkyway.SaveableSerializing.ItemStacks.Lower_1_7.DataTypes;

import milkyway.SaveableSerializing.Parser.SaveableData;
import org.bukkit.Color;

import java.util.List;

/**
 * Created by Developer_Unlocated on 2017-04-17.
 */
public class RGBColor implements SaveableData{
    public RGBColor(){}
    private int red = 0;
    private int blue = 0;
    private int green = 0;
    public RGBColor(Color col){
        red = col.getRed();
        blue = col.getBlue();
        green = col.getGreen();
    }
    @Override
    public void writeBy(StringBuilder  builder) {
        builder.append(String.valueOf(red)).append("\n");
        builder.append(String.valueOf(blue)).append("\n");
        builder.append(String.valueOf(green)).append("\n");
    }

    @Override
    public void appendTo(List<String> builded) {
        try {
            red = Integer.parseInt(builded.get(0));
            blue = Integer.parseInt(builded.get(1));
            green = Integer.parseInt(builded.get(2));
        }catch (Exception ex){}
    }

    @Override
    public String getName() {
        return "RGBColor";
    }

    @Override
    public void appendObject(String str, SaveableData data) {

    }

    @Override
    public Object getOriginal() {
        return Color.fromRGB(red,green,blue);
    }

    @Override
    public SaveableData getNewInstance() {
        return new RGBColor();
    }
}
