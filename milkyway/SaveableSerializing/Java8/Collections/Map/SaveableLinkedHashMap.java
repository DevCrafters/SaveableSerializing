package milkyway.SaveableSerializing.Java8.Collections.Map;

import milkyway.SaveableSerializing.Java8.API.GenericsResolver;
import milkyway.SaveableSerializing.Java8.Exceptions.CollectionsNullException;
import milkyway.SaveableSerializing.Java8.Exceptions.TypeNotSupportedException;
import milkyway.SaveableSerializing.Parser.SaveableData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Developer_Unlocated on 2017-05-11.
 */
public class SaveableLinkedHashMap extends SaveableHashMap{
    public SaveableLinkedHashMap(HashMap map) throws CollectionsNullException,TypeNotSupportedException {
        super(map,true);
    }
    public SaveableLinkedHashMap(){
        super(true);
    }
    @Override
    public String getName() {
        return "Java8_LinkedHashMap";
    }
    @Override
    public SaveableData getNewInstance() {
        return new SaveableHashMap(true);
    }


}
