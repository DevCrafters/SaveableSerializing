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
            }catch (Exception ex){}
    }
}
