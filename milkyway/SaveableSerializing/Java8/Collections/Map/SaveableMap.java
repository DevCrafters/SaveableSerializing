package milkyway.SaveableSerializing.Java8.Collections.Map;

import milkyway.SaveableSerializing.Java8.API.GenericsResolver;
import milkyway.SaveableSerializing.Java8.Annotation.DeprecatedCause;
import milkyway.SaveableSerializing.Java8.Collections.SaveableCollection;
import milkyway.SaveableSerializing.Java8.Exceptions.TypeNotSupportedException;
import milkyway.SaveableSerializing.Parser.SaveableData;

/**
 * Created by Developer_Unlocated on 2017-05-11.
 */
public abstract class SaveableMap implements SaveableData,SaveableCollection {
    @DeprecatedCause(DeprecratedCause = "Better method implements created.Use getGenericsType(). [ This method will be removed on higher version. ]")
    @Deprecated
    abstract public GenericsResolver.ItemType[] getGenerics();
    abstract public Object get(Object key);
    abstract public boolean put(Object key,Object value) throws TypeNotSupportedException;
    abstract public Object getOrDefault(Object key,Object defaultValue);
    abstract public Object getOrputDefault(Object key,Object defaultValue);
    abstract public Object remove(Object key);
    abstract public boolean containsKey(Object key);
    abstract public boolean containsValue(Object value);

}
