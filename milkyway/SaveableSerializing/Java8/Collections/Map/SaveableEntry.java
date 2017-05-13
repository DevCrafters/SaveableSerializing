package milkyway.SaveableSerializing.Java8.Collections.Map;

import milkyway.SaveableSerializing.Java8.API.GenericsResolver;
import milkyway.SaveableSerializing.Java8.Collections.SaveableCollection;
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
    public SaveableEntry(){}
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
                builder.append("`").append(key.toString()).append("\n");
            else
                builder.append("`").append(type[0].getNullDefaultObject().toString()).append("\n");

        if(type[1] == GenericsResolver.ItemType.Saveable)
            if(value != null)
                ((SaveableData)value).appendSubSet(builder);
            else
                new NullSaveableData().appendSubSet(builder);
        else
        if(value != null)
            builder.append("`").append(value.toString()).append("\n");
        else
            builder.append("`").append(type[1].getNullDefaultObject().toString()).append("\n");

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
        try{
            String a = builded.get(2);
            a = a.substring(1,a.length());
            if(a.equals("SaveableNxNullPointerItemObject"))
                 key = null;
            else
                key = type[0].getResolver().resolve(a);
        }catch (Exception ex){}
        try{
            String a = builded.get(3);
            a = a.substring(1,a.length());
            if(a.equals("SaveableNxNullPointerItemObject"))
                value= null;
            else
            value = type[1].getResolver().resolve(a);
        }catch (Exception ex){}
    }
    @Override
    public boolean finalizeObject(){
        if(type[0].getResolver().canResolve(key) && type[1].getResolver().canResolve(value))
            return true;
        return false;
    }
    @Override
    public String getName() {
        return "Java8_SaveableEntry";
    }

    @Override
    public void appendObject(String str, SaveableData data) {
        if(key != null)
            key = data;
        else
            value = data;
    }

    @Override
    public Object getOriginal() {
        return null;
    }

    @Override
    public SaveableData getNewInstance() {
        return new SaveableHashMap();
    }
}
