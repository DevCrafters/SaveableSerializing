package milkyway.SaveableSerializing.Java8.Collections;

import milkyway.SaveableSerializing.Java8.API.GenericsResolver;

/**
 * Created by Developer_Unlocated on 2017-05-13.
 */
public interface SaveableCollection {
    boolean finalizeObject();
    GenericsResolver.ItemType[] getGenericsType();
}
