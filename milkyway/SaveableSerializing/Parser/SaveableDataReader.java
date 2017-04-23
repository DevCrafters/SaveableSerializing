package milkyway.SaveableSerializing.Parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Developer_Unlocated on 2017-04-18.
 */
public class SaveableDataReader {
    private final int deepArray;
    final private File targetFile;
    public SaveableDataReader(File target){
        targetFile = target;
        deepArray = 250;
    }
    public SaveableDataReader(File target,int arraySize) throws Exception{
        targetFile = target;
        if(arraySize <= 0)
            throw new Exception("임시 리스트 저장소 깊이는 1 이상이여야 합니다!");
        deepArray = arraySize;
    }
    public List<SaveableData> read(){
        List<String>[] arrayLeft = new List[deepArray];
        int currentdeep = 0;
        List<SaveableData> array = new ArrayList<>();
        try{
            BufferedReader reading = new BufferedReader(new FileReader(targetFile));
            String str;
            List<SaveableData> dataReading = new ArrayList<>();
            arrayLeft[currentdeep] = new ArrayList<>();
            while((str = reading.readLine()) != null){
                if(currentdeep >= deepArray)
                    throw new Exception("이너 메타 개수 상한에 도달하였습니다 : 해당 Reader은 이너 메타가 " + deepArray + "개 이하여지만 인식이 가능합니다.");
                if(dataReading.size() <= 0){
                    if(str.startsWith("start subset "))
                    {
                        SaveableData data = StaticSaveableDataRegistry.getHandle().getDataWithNewInstance(str.substring(13,str.length()));
                        if(data != null)
                            dataReading.add(data);
                        arrayLeft[currentdeep] = new ArrayList<>();
                    }
                }else{
                    if(str.startsWith("start subset "))
                    {
                        SaveableData data = StaticSaveableDataRegistry.getHandle().getDataWithNewInstance(str.substring(13,str.length()));
                        if(data != null)
                        {
                            arrayLeft[++currentdeep] = new ArrayList<>();
                            dataReading.add(data);

                        }
                    }else if(str.equals("end subset")){

                         if(currentdeep == 0){

                             dataReading.get(0).appendTo(arrayLeft[currentdeep]);
                             array.add(dataReading.get(0));
                             dataReading.remove(0);
                         }else{

                            SaveableData obj = dataReading.get(currentdeep);
                            obj.appendTo(arrayLeft[currentdeep]);
                            dataReading.remove(currentdeep--);
                            dataReading.get(currentdeep).appendObject(obj.getName(),obj);
                        }
                        /*
                        if(dataReading.size() == 1)
                        {
                            dataReading.get(0).appendTo(builder);
                            builder.clear();
                            array.add(dataReading.get(0));
                            dataReading.remove(0);
                        }else if(dataReading.size() >= 2){
                            SaveableData obj = dataReading.get(dataReading.size()-1);
                            dataReading.remove(dataReading.size()-1);
                            obj.appendTo(builder);
                            builder.clear();
                            dataReading.get(dataReading.size()-1).appendObject(obj.getName(),obj);
                        }
                         */
                    }else
                        arrayLeft[(currentdeep >= 0) ? currentdeep : 0].add(str);
                }
            }
        }catch (Exception ex){ex.printStackTrace();}
        return array;
    }
}
