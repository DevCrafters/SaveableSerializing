package milkyway.SaveableSerializing.Java8.API;

import milkyway.SaveableSerializing.Java8.Exceptions.CollectionsNullException;
import milkyway.SaveableSerializing.Java8.Exceptions.TypeNotSupportedException;
import milkyway.SaveableSerializing.Parser.NullSaveableData;
import milkyway.SaveableSerializing.Parser.SaveableData;

import java.lang.reflect.Type;
import java.util.*;

/**
 * Created by Developer_Unlocated on 2017-05-10.
 */
public class GenericsResolver {
    public enum ItemType{
        String(new TypeResolver.StringResolver(),"SaveableNxNullPointerItemObject"),Integer(new TypeResolver.IntegerResolver(),0),Double(new TypeResolver.DoubleResolver(),0d)
        ,Float(new TypeResolver.FloatResolver(),0f),Byte(new TypeResolver.ByteResolver(),(byte)0),Saveable(new TypeResolver.SaveableResolver(),new NullSaveableData()),Empty(new TypeResolver.EmprtyResolver(),new NullSaveableData());
        private ItemType(TypeResolver resolver,Object nullDefault){
            solver = resolver;
            this.nullDefault = nullDefault;
        }
        public TypeResolver getResolver(){
            return solver;
        }
        private final Object nullDefault;
        public Object getNullDefaultObject(){
            return nullDefault;
        }
        private final TypeResolver solver;
    }

    public static ItemType resolveGenerics(List list) throws TypeNotSupportedException,CollectionsNullException {
        if(list.size() <= 0)
            return ItemType.Empty;
        for(Object entrys : list)
        {
            if(entrys != null)
                return resolve(entrys);
        }
        throw new CollectionsNullException();

    }
    public static ItemType[] resolveGenerics(Map map) throws TypeNotSupportedException,CollectionsNullException {
        if(map.size() <= 0)
            return new ItemType[]{ItemType.Empty,ItemType.Empty};
        Map.Entry entry =  new ArrayList<Map.Entry>(map.entrySet()).get(0);
        for(Object entrys : map.entrySet())
        {
            Map.Entry ent = (Map.Entry) entrys;
            if(ent.getKey() != null && ent.getValue() != null)
            {
                entry = ent;
                break;
            }
        }
        if(entry == null)
            throw new CollectionsNullException();
        return new ItemType[]{resolve(entry.getKey()),resolve(entry.getValue())};

    }
    public static ItemType resolve(Object obj) throws TypeNotSupportedException{
        if(obj instanceof String)
            return ItemType.String;
        if(obj instanceof Integer)
            return ItemType.Integer;
        if(obj instanceof Double)
            return ItemType.Double;
        if(obj instanceof Float)
            return ItemType.Float;
        if(obj instanceof Byte)
            return ItemType.Byte;
        if(obj instanceof SaveableData)
            return ItemType.Saveable;
        throw new TypeNotSupportedException();
    }

}

