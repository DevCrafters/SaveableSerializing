package milkyway.SaveableSerializing.Java8.Collections.Map;

import milkyway.SaveableSerializing.Java8.Exceptions.CollectionsNullException;
import milkyway.SaveableSerializing.Java8.Exceptions.TypeNotSupportedException;
import milkyway.SaveableSerializing.Parser.SaveableData;

import java.util.HashMap;

/**
 * Created by Developer_Unlocated on 2017-05-17.
 */
public class SaveableHashMap extends SaveableMapLocal{
    public SaveableHashMap(HashMap map) throws CollectionsNullException,TypeNotSupportedException {
        super(map,"HashMap");
    }
    public SaveableHashMap(){
        super(true);
    }
    @Override
    public String getName() {
        return "Java8_HashMap";
    }
    @Override
    public SaveableData getNewInstance() {
        return new SaveableHashMap();
    }


}
