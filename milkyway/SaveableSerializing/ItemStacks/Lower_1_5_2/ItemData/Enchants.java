package milkyway.SaveableSerializing.ItemStacks.Lower_1_5_2.ItemData;

import milkyway.SaveableSerializing.Parser.SaveableData;
import org.bukkit.enchantments.Enchantment;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

/**
 * Created by Developer_Unlocated on 2017-04-17.
 */
public class Enchants implements SaveableData{
    public int id = 0;
    public int level = 0;
    public Enchants(){}
    public Enchants(Enchantment ench,int lv){
        if(ench != null)
            id = ench.getId();
        level = lv;
    }
    @Override
    public void writeBy(BufferedWriter builder) throws IOException {
        builder.append(String.valueOf(id)).append("\n");
        builder.append(String.valueOf(level)).append("\n");
    }

    @Override
    public void appendTo(List<String> builded) {
        try{
            id = Integer.parseInt(builded.get(0));
            level = Integer.parseInt(builded.get(1));
        }catch (Exception ex){}
    }

    @Override
    public String getName() {
        return "Enchant";
    }

    @Override
    public void appendObject(String str, SaveableData data) {

    }

    @Override
    public Object getOriginal() {
        return null;
    }

    @Override
    public SaveableData getNewInstance() {
        return new Enchants();
    }
}
