package milkyway.SaveableSerializing.Java8.Collections.Map;

import milkyway.SaveableSerializing.Java8.Exceptions.CollectionsNullException;
import milkyway.SaveableSerializing.Java8.Exceptions.TypeNotSupportedException;
import milkyway.SaveableSerializing.Parser.SaveableData;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Developer_Unlocated on 2017-05-17.
 */
public class SaveableTreeMap extends SaveableMapLocal{
    public SaveableTreeMap(Map map) throws CollectionsNullException,TypeNotSupportedException {
        super(map,"TreeMap");
    }
    public SaveableTreeMap(){
        super(true);
    }
    @Override
    public String getName() {
        return "Java8_LinkedHashMap";
    }
    @Override
    public SaveableData getNewInstance() {
        return new SaveableLinkedHashMap();
    }


}
