package milkyway.SaveableSerializing.Parser;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

/**
 * Created by Developer_Unlocated on 2017-04-18.
 * 이 클래스는 갈 곳 없는 눌 인스턴스를 거두는 어머니같은 클래스입니다.
 */
public class NullSaveableData implements SaveableData{
    @Override
    public void writeBy(BufferedWriter builder) throws IOException {

    }

    @Override
    public void appendTo(List<String> builded) {

    }

    @Override
    public String getName() {
        return "NullPointer";
    }

    @Override
    public void appendObject(String str, SaveableData data) {

    }

    @Override
    public Object getOriginal() {
        return null;
    }

    @Override
    public SaveableData getNewInstance() {
        return null;
    }
}
