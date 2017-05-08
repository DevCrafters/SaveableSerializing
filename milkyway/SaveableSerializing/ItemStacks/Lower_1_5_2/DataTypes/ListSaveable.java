package milkyway.SaveableSerializing.ItemStacks.Lower_1_5_2.DataTypes;

import milkyway.SaveableSerializing.Parser.SaveableData;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Developer_Unlocated on 2017-04-17.
 */
public class ListSaveable implements SaveableData{
    public List<String> data = new ArrayList<>();
    public ListSaveable(List<String> data){
        this.data = data;
    }
    @Override
    public void writeBy(BufferedWriter builder) throws IOException {
        for(String n : data)
            builder.append(n).append("\n");
    }
    public ListSaveable(){}
    @Override
    public void appendTo(List<String> builded) {
       for(String n : builded)
           data.add(n);
    }



    @Override
    public String getName() {
        return "List";
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
        return new ListSaveable(new ArrayList<>());
    }
}
