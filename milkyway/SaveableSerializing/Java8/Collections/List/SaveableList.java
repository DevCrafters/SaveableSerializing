package milkyway.SaveableSerializing.Java8.Collections.List;

import milkyway.SaveableSerializing.Java8.API.GenericsResolver;
import milkyway.SaveableSerializing.Java8.Collections.SaveableCollection;
import milkyway.SaveableSerializing.Java8.Exceptions.TypeNotSupportedException;
import milkyway.SaveableSerializing.Parser.SaveableData;

/**
 * Created by Developer_Unlocated on 2017-05-11.
 */
public abstract class SaveableList implements SaveableData,SaveableCollection{
    abstract public GenericsResolver.ItemType getGenerics();
    abstract public int size();
    abstract public void add(int index,Object object) throws TypeNotSupportedException;
    abstract public void add(Object object) throws TypeNotSupportedException;
    abstract public boolean remove(Object obj);
    abstract public Object remove(int obj);
    abstract public boolean contains(Object obj);
    abstract public boolean set(int location,Object obj) throws TypeNotSupportedException;
}
