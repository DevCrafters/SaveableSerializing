package milkyway.SaveableSerializing.Parser;

import milkyway.SaveableSerializing.Java8.Collections.List.SaveableArrayList;
import milkyway.SaveableSerializing.Java8.Collections.List.SaveableLinkedList;

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
    }

    private void registerList(){
        StaticSaveableDataRegistry.getHandle().registerSaveable(new SaveableArrayList());
        StaticSaveableDataRegistry.getHandle().registerSaveable(new SaveableLinkedList());
    }
}
