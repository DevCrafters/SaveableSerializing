package milkyway.SaveableSerializing.Java8.Collections.List;

import milkyway.SaveableSerializing.Java8.API.GenericsResolver;
import milkyway.SaveableSerializing.Java8.Exceptions.CollectionsNullException;
import milkyway.SaveableSerializing.Java8.Exceptions.TypeNotSupportedException;
import milkyway.SaveableSerializing.Parser.NullSaveableData;
import milkyway.SaveableSerializing.Parser.SaveableData;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Developer_Unlocated on 2017-05-11.
 */
public class SaveableArrayList extends SaveableList{
    public SaveableArrayList(List list) throws CollectionsNullException,TypeNotSupportedException {
        super(list,"ArrayList");
    }
    public SaveableArrayList(){
        super("ArrayList");
    }

    @Override
    public String getName() {
        return "Java8_SaveableArrayList";
    }


    @Override
    public SaveableData getNewInstance() {
        return new SaveableLinkedList();
    }

}
