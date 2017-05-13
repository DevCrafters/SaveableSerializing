package milkyway.SaveableSerializing.Java8.Reflection;

import milkyway.SaveableSerializing.Parser.SaveableData;

import java.util.List;

/**
 * Created by Developer_Unlocated on 2017-05-11.
 */
public class SaveablePackage  implements SaveableData {
    private String packageName = null;
    public SaveablePackage(Class clas){
        packageName = clas.getName();
    }
    @Override
    public void writeBy(StringBuilder builder) {
        builder.append(packageName).append("\n");
    }

    @Override
    public void appendTo(List<String> builded) {
        try{
            packageName = builded.get(0);
        }catch (Exception ex){}
    }

    @Override
    public String getName() {
        return "Java8_Reflection_Package";
    }

    @Override
    public void appendObject(String str, SaveableData data) {

    }

    @Override
    public Object getOriginal() {
        if(packageName != null)
                return Package.getPackage(packageName);
        return null;
    }
    public SaveablePackage(){}
    @Override
    public SaveableData getNewInstance() {
        return new SaveablePackage();
    }
}
