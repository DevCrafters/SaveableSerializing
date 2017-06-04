package milkyway.SaveableSerializing.Parser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Developer_Unlocated on 2017-04-18.
 */
public class SaveableDataWriter {
    final private File targetFile;
    public SaveableDataWriter(File target){
        targetFile = target;
    }
    private     List<SaveableData> toWrite = new ArrayList<>();
    public void add(SaveableData data){
        if(data != null)
            toWrite.add(data);
    }
    public void clearObject(){
        toWrite.clear();
    }

    /**
     * 해당 메소드는 {@link SaveableData}를 String으로 반환해줍니다.
     * This Method return String from  {@link SaveableData}.
     * @Since SaveableSerialize 0.3.1
     *
     */
    public static String getSaveableAsString(SaveableData data){
        StringBuilder builder = new StringBuilder();
        data.appendSubSet(builder);
        return builder.toString();
    }
    public void flush(){
        try{
            if(targetFile.exists())
                targetFile.delete();
            targetFile.getParentFile().mkdirs();
            targetFile.createNewFile();

            BufferedWriter writer = new BufferedWriter(new FileWriter(targetFile));
            StringBuilder builder = new StringBuilder();
            for(SaveableData dat : toWrite)
            {
                writer.append("start subset ").append(dat.getName()).append("\n");
                dat.writeBy(builder);
                writer.append(builder);
                writer.append("end subset\n");
                builder = new StringBuilder();
            }

            writer.flush();
            writer.close();
            toWrite.clear();
            }catch (Exception ex){}
    }
}
