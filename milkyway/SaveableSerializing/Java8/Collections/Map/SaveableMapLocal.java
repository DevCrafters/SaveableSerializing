package milkyway.SaveableSerializing.Java8.Collections.Map;

import milkyway.SaveableSerializing.Java8.API.GenericsResolver;
import milkyway.SaveableSerializing.Java8.Exceptions.CollectionsNullException;
import milkyway.SaveableSerializing.Java8.Exceptions.TypeNotSupportedException;
import milkyway.SaveableSerializing.Parser.SaveableData;

import java.util.*;

/**
 * Created by Developer_Unlocated on 2017-05-11.
 */
public class SaveableMapLocal extends SaveableMap{
    private GenericsResolver.ItemType[] resolver = new GenericsResolver.ItemType[]{GenericsResolver.ItemType.Empty,GenericsResolver.ItemType.Empty};
    private Map<Object,Object> map = new HashMap<>();
    private List<SaveableEntry> tempEntry = new ArrayList<>();
    public SaveableMapLocal(Map mapObj) throws CollectionsNullException,TypeNotSupportedException {
        resolver = GenericsResolver.resolveGenerics(mapObj);
        for(Object entry4 : mapObj.entrySet()){
            Map.Entry entry  = (Map.Entry) entry4;
            tempEntry.add(new SaveableEntry(entry.getKey(),entry.getValue(),resolver));
        }
        finalizeObject();
    }
    public SaveableMapLocal(Map mapObj,String mapType) throws CollectionsNullException,TypeNotSupportedException {
        resolver = GenericsResolver.resolveGenerics(mapObj);
        switch (mapType){
            case "LinkedHashMap":
                map = new LinkedHashMap<>();

                break;
            case "HashMap":
                map = new HashMap<>();
                break;
            case "TreeMap":
                map = new TreeMap<>();
                break;
        }
        for(Object entry4 : mapObj.entrySet()){
            Map.Entry entry  = (Map.Entry) entry4;
            tempEntry.add(new SaveableEntry(entry.getKey(),entry.getValue(),resolver));
        }
        finalizeObject();
    }
    @Deprecated
    public SaveableMapLocal(Map mapObj,boolean isLinked) throws CollectionsNullException,TypeNotSupportedException {
        if(isLinked)
            map = new LinkedHashMap<>();
        resolver = GenericsResolver.resolveGenerics(mapObj);
        for(Object entry4 : mapObj.entrySet()){
            Map.Entry entry  = (Map.Entry) entry4;
            tempEntry.add(new SaveableEntry(entry.getKey(),entry.getValue(),resolver));
        }
        finalizeObject();
        System.out.println(tempEntry.size());
    }
    public SaveableMapLocal(){}
    public SaveableMapLocal(boolean isLinked){
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
    public boolean put(Object key, Object value)  {
        if(key != null){
            if(!resolver[0].getResolver().canResolve(value))
                return false;
            if(value != null){
                if(!resolver[0].getResolver().canResolve(value))
                    return false;
                map.put(key,value);
            }else{
                map.put(null,null);
            }
        }else{
            if(value != null){
                if(!resolver[1].getResolver().canResolve(value))
                    return false;
                map.put(null,value);
            }else{
                map.put(null,null);
            }
        }

        return true;
    }
    @Override
    public Object getOrDefault(Object key, Object defaultValue) {
        return map.getOrDefault(key,defaultValue);
    }

    @Override
    public Object getOrputDefault(Object key, Object defaultValue) {
        if(!map.containsKey(key))
            put(key,defaultValue);
        return get(key);
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
        for(Object n : map.entrySet()){
            new SaveableEntry(((Map.Entry) n).getKey(),((Map.Entry) n).getValue(),resolver).appendSubSet(builder);
        }
    }

    @Override
    public void appendTo(List<String> builded) {
        try{
            resolver[0] = GenericsResolver.ItemType.valueOf(builded.get(0));
            resolver[1] = GenericsResolver.ItemType.valueOf(builded.get(1));
        }catch (Exception ex){}
        finalizeObject();
    }

    @Override
    public String getName() {
        return "Java8_DefaultMap";
    }

    @Override
    public void appendObject(String str, SaveableData data) {
        tempEntry.add((SaveableEntry) data);
    }

    @Override
    public Object getOriginal() {
        return map;
    }

    @Override
    public SaveableData getNewInstance() {
        return new SaveableMapLocal();
    }

    @Override
    public boolean finalizeObject() {
        for(SaveableEntry entry : tempEntry){
            entry.type = resolver;
            if(entry.finalizeObject()) {
                map.put(entry.getKey(), entry.getValue());
                //System.out.println("Finalized entry");
            }

        }
        // System.out.println("Entry Size : " + map.size());
        return true;
    }
}
