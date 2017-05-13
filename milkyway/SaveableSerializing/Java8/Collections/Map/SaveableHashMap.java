package milkyway.SaveableSerializing.Java8.Collections.Map;

import milkyway.SaveableSerializing.Java8.API.GenericsResolver;
import milkyway.SaveableSerializing.Java8.Exceptions.CollectionsNullException;
import milkyway.SaveableSerializing.Java8.Exceptions.TypeNotSupportedException;
import milkyway.SaveableSerializing.Parser.SaveableData;

import java.util.*;

/**
 * Created by Developer_Unlocated on 2017-05-11.
 */
public class SaveableHashMap extends SaveableMap{
    private GenericsResolver.ItemType[] resolver = new GenericsResolver.ItemType[]{GenericsResolver.ItemType.Empty,GenericsResolver.ItemType.Empty};
    private HashMap<Object,Object> map = new HashMap<>();
    private List<SaveableEntry> tempEntry = new ArrayList<>();
    public SaveableHashMap(HashMap map) throws CollectionsNullException,TypeNotSupportedException {
        resolver = GenericsResolver.resolveGenerics(map);
        for(Object entry4 : map.entrySet()){
            Map.Entry entry  = (Map.Entry) entry4;
            tempEntry.add(new SaveableEntry(entry.getKey(),entry.getValue(),resolver));
        }
        finalizeObject();
    }
    public SaveableHashMap(HashMap map,boolean isLinked) throws CollectionsNullException,TypeNotSupportedException {
        if(isLinked)
            map = new LinkedHashMap();
        resolver = GenericsResolver.resolveGenerics(map);
        for(Object entry4 : map.entrySet()){
            Map.Entry entry  = (Map.Entry) entry4;
            tempEntry.add(new SaveableEntry(entry.getKey(),entry.getValue(),resolver));
        }
        finalizeObject();
    }
    public SaveableHashMap(){}
    public SaveableHashMap(boolean isLinked){
        if(isLinked)
            map = new LinkedHashMap<>();
    }
    @Override
    public GenericsResolver.ItemType[] getGenerics() {
        return new GenericsResolver.ItemType[]{resolver[0],resolver[1]};
    }

    @Override
    public Object get(Object key) {
        return map.get(key);
    }

    @Override
    public Object getOrDefault(Object key, Object defaultValue) {
        return map.getOrDefault(key,defaultValue);
    }

    @Override
    public Object getOrputDefault(Object key, Object defaultValue) {
        if(!map.containsKey(key))
            map.put(key,defaultValue);
        return map.get(key);
    }

    @Override
    public Object remove(Object key) {
        return map.remove(key);
    }

    @Override
    public boolean containsKey(Object key) {
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return map.containsValue(value);
    }

    @Override
    public void writeBy(StringBuilder builder) {
        builder.append(resolver[0].name()).append("\n");
        builder.append(resolver[1].name()).append("\n");
        finalizeObject();
    }

    @Override
    public void appendTo(List<String> builded) {

    }

    @Override
    public String getName() {
        return "Java8_HashMap";
    }

    @Override
    public void appendObject(String str, SaveableData data) {
        if(str.equals("Java8_SaveableEntry"))
            tempEntry.add((SaveableEntry) data);
    }

    @Override
    public Object getOriginal() {
        return map;
    }

    @Override
    public SaveableData getNewInstance() {
        return new SaveableHashMap();
    }

    @Override
    public boolean finalizeObject() {
        for(SaveableEntry entry : tempEntry){
            entry.type = resolver;
            if(entry.finalizeObject())
                map.put(entry.getKey(),entry.getValue());

        }
        return true;
    }
}
