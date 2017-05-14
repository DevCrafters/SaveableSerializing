package milkyway.SaveableSerializing.Java8.Object;

import milkyway.SaveableSerializing.Parser.SaveableData;

import java.util.List;

/**
 * Created by Developer_Unlocated on 2017-05-14.
 */
public class SaveableDefaultObject implements SaveableData{
    public String object;
    public SaveableDefaultObject(String object){
        this.object = object;
    }
    @Override
    public void writeBy(StringBuilder builder) {
        builder.append("`").append(object).append("\n");
    }

    @Override
    public void appendTo(List<String> builded) {
        object = builded.get(0).substring(1,builded.get(0).length());
    }

    @Override
    public String getName() {
        return "Java8_DefaultObject";
    }

    @Override
    public void appendObject(String str, SaveableData data) {

    }

    @Override
    public Object getOriginal() {
        return null;
    }
    public SaveableDefaultObject(){}
    @Override
    public SaveableData getNewInstance() {
        return new SaveableDefaultObject();
    }
}
