package milkyway.SaveableSerializing.Java8.Reflection;

import milkyway.SaveableSerializing.Parser.SaveableData;

import java.util.List;

/**
 * Created by Developer_Unlocated on 2017-05-11.
 */
public class SaveableClass implements SaveableData{
    private String className = null;
    public SaveableClass(Class clas){
        className = clas.getName();
    }
    @Override
    public void writeBy(StringBuilder builder) {
        builder.append(className).append("\n");
    }

    @Override
    public void appendTo(List<String> builded) {
        try{
            className = builded.get(0);
        }catch (Exception ex){}
    }

    @Override
    public String getName() {
        return "Java8_Reflection_Class";
    }

    @Override
    public void appendObject(String str, SaveableData data) {

    }

    @Override
    public Object getOriginal() {
        if(className != null)
            try {
                return Class.forName(className);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        return null;
    }
    public SaveableClass(){}
    @Override
    public SaveableData getNewInstance() {
        return new SaveableClass();
    }
}
