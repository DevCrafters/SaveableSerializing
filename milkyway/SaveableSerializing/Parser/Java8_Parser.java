package milkyway.SaveableSerializing.Parser;

import milkyway.SaveableSerializing.Java8.Collections.List.SaveableArrayList;
import milkyway.SaveableSerializing.Java8.Collections.List.SaveableLinkedList;
import milkyway.SaveableSerializing.Java8.Collections.Map.*;
import milkyway.SaveableSerializing.Java8.Object.SaveableDefaultObject;
import milkyway.SaveableSerializing.Java8.Util.Calendar.SaveableGregorianCalendar;

/**
 * Created by Developer_Unlocated on 2017-05-11.
 *
 * �� Ŭ������ �ڹ� 8 ������ Saveable ��ü�� ������ݴϴ�.
 *
 * This class will be register instance of Java 8's Saveable Object.
 */
public class Java8_Parser implements ParserRegistry {
    @Override
    public void register() {
        registerCollection();
    }
    private void registerCollection(){
        registerList();
        registerMap();
        registerObject();
        registerCalendars();
    }
    private void registerObject(){
        StaticSaveableDataRegistry.getHandle().registerSaveable(new SaveableDefaultObject());
    }
    private void registerList(){
        StaticSaveableDataRegistry.getHandle().registerSaveable(new SaveableArrayList());
        StaticSaveableDataRegistry.getHandle().registerSaveable(new SaveableLinkedList());
    }

    private void registerCalendars(){
        StaticSaveableDataRegistry.getHandle().registerSaveable(new SaveableGregorianCalendar());
    }
    private void registerMap(){
        StaticSaveableDataRegistry.getHandle().registerSaveable(new SaveableEntry());
        StaticSaveableDataRegistry.getHandle().registerSaveable(new SaveableLinkedHashMap());
        StaticSaveableDataRegistry.getHandle().registerSaveable(new SaveableHashMap());
        StaticSaveableDataRegistry.getHandle().registerSaveable(new SaveableMapLocal());
        StaticSaveableDataRegistry.getHandle().registerSaveable(new SaveableTreeMap());
    }
}
