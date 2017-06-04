package milkyway.SaveableSerializing.Java8.Collections.Map;

import milkyway.SaveableSerializing.Java8.API.GenericsResolver;
import milkyway.SaveableSerializing.Java8.Collections.SaveableCollection;
import milkyway.SaveableSerializing.Java8.Object.SaveableDefaultObject;
import milkyway.SaveableSerializing.Parser.NullSaveableData;
import milkyway.SaveableSerializing.Parser.SaveableData;

import java.util.List;

/**
 * Created by Developer_Unlocated on 2017-05-13.
 */
public class SaveableEntry implements SaveableData,SaveableCollection{
    Object key ;
    Object value;
    GenericsResolver.ItemType[] type = new GenericsResolver.ItemType[]{GenericsResolver.ItemType.Empty, GenericsResolver.ItemType.Empty};
    public SaveableEntry(Object key, Object value, GenericsResolver.ItemType[] type){
        this.key = key;
        this.value = value;
        this.type = type;
    }
    public SaveableEntry(){

    }
    @Override
    public void writeBy(StringBuilder builder) {
        builder.append(type[0].name()).append("\n");
        builder.append(type[1].name()).append("\n");

        if(type[0] == GenericsResolver.ItemType.Saveable)
            if(key != null)
                ((SaveableData)key).appendSubSet(builder);
            else
                new NullSaveableData().appendSubSet(builder);
        else
        if(key != null)
            new SaveableDefaultObject(key.toString()).appendSubSet(builder);
        else
            new SaveableDefaultObject(type[0].getNullDefaultObject().toString()).appendSubSet(builder);

        if(type[1] == GenericsResolver.ItemType.Saveable)
            if(value != null)
                ((SaveableData)value).appendSubSet(builder);
            else
                new NullSaveableData().appendSubSet(builder);
        else
        if(value != null)
            new SaveableDefaultObject(value.toString()).appendSubSet(builder);
        else
            new SaveableDefaultObject(type[1].getNullDefaultObject().toString()).appendSubSet(builder);

    }
    public Object getKey(){
        return key;
    }

    public Object getValue(){
        return value;
    }
    @Override
    public void appendTo(List<String> builded) {
        try{
            type[0] = GenericsResolver.ItemType.valueOf(builded.get(0));
            type[1] = GenericsResolver.ItemType.valueOf(builded.get(1));
        }catch (Exception ex){}
        if(key != null)
            if(type[0] != GenericsResolver.ItemType.Saveable)
                if(((SaveableDefaultObject)key).object.equals("SaveableNxNullPointerItemObject"))
                    key = null;
                else
                    key = type[0].getResolver().resolve(((SaveableDefaultObject)key).object);
            else
            if(key instanceof NullSaveableData)
                key = null;
        if(value != null)
            if(type[1] != GenericsResolver.ItemType.Saveable)
                if(((SaveableDefaultObject)value).object.equals("SaveableNxNullPointerItemObject"))
                    value = null;
                else
                    value = type[1].getResolver().resolve(((SaveableDefaultObject)value).object);
            else
            if(value instanceof NullSaveableData)
                value = null;
    }
    @Override
    public boolean finalizeObject(){
        if(type[0].getResolver().canResolve(key) && type[1].getResolver().canResolve(value))
            return true;
        return false;
    }

    @Override
    public GenericsResolver.ItemType[] getGenericsType() {
        return new GenericsResolver.ItemType[]{type[0],type[1]};
    }

    @Override
    public String getName() {
        return "Java8_SaveableEntry";
    }

    @Override
    public void appendObject(String str, SaveableData data) {
        if(key == null)
            key = data;
        else
            value = data;
        //  System.out.println("Object appended / " + str);
    }

    @Override
    public Object getOriginal() {
        return null;
    }

    @Override
    public SaveableData getNewInstance() {
        return new SaveableEntry();
    }
}
