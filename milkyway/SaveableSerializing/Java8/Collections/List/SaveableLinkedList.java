package milkyway.SaveableSerializing.Java8.Collections.List;

import milkyway.SaveableSerializing.Java8.API.GenericsResolver;
import milkyway.SaveableSerializing.Java8.Exceptions.CollectionsNullException;
import milkyway.SaveableSerializing.Java8.Exceptions.TypeNotSupportedException;
import milkyway.SaveableSerializing.Parser.NullSaveableData;
import milkyway.SaveableSerializing.Parser.SaveableData;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Developer_Unlocated on 2017-05-11.
 */
public class SaveableLinkedList extends SaveableList{
    public SaveableLinkedList(List list) throws CollectionsNullException,TypeNotSupportedException {
       super(list,"LinkedList");
    }
    public SaveableLinkedList(){
        super("LinkedList");
    }

    @Override
    public String getName() {
        return "Java8_SaveableLinkedList";
    }


    @Override
    public SaveableData getNewInstance() {
        return new SaveableLinkedList();
    }
}
