package milkyway.SaveableSerializing.Parser;

import milkyway.SaveableSerializing.Java8.Collections.List.SaveableArrayList;
import milkyway.SaveableSerializing.Java8.Collections.List.SaveableLinkedList;
import milkyway.SaveableSerializing.Java8.Collections.Map.SaveableEntry;
import milkyway.SaveableSerializing.Java8.Collections.Map.SaveableHashMap;
import milkyway.SaveableSerializing.Java8.Collections.Map.SaveableLinkedHashMap;

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
    }

    private void registerList(){
        StaticSaveableDataRegistry.getHandle().registerSaveable(new SaveableArrayList());
        StaticSaveableDataRegistry.getHandle().registerSaveable(new SaveableLinkedList());
    }

    private void registerMap(){
        StaticSaveableDataRegistry.getHandle().registerSaveable(new SaveableEntry());
        StaticSaveableDataRegistry.getHandle().registerSaveable(new SaveableLinkedHashMap());
        StaticSaveableDataRegistry.getHandle().registerSaveable(new SaveableHashMap());
    }
}
