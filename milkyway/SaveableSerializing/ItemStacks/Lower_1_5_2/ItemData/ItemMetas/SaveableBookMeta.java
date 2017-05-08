package milkyway.SaveableSerializing.ItemStacks.Lower_1_5_2.ItemData.ItemMetas;


import milkyway.SaveableSerializing.ItemStacks.Lower_1_5_2.DataTypes.ListSaveable;
import milkyway.SaveableSerializing.Parser.SaveableData;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Developer_Unlocated on 2017-04-17.
 */
public class SaveableBookMeta extends SubMeta{
    List<String> page = new ArrayList<>();
    String author = "Mr.Minecraft";
    @Override
    public void writeBy(BufferedWriter builder) throws IOException {
        builder.append(author).append("\n");
        new ListSaveable(page).appendSubSet(builder);
    }

    @Override
    public void appendTo(List<String> builded) {
        if(builded.size() >= 1)
            author = builded.get(0);
    }

    @Override
    public String getName() {
        return "SubMeta-BookMeta";
    }

    @Override
    public void appendObject(String str, SaveableData data) {
        if(str.equals("List"))
            page = ((ListSaveable)data).data;
    }

    @Override
    public SaveableData getNewInstance() {
        return new SaveableBookMeta();
    }

    @Override
    public void setTo(ItemMeta meta) {
        if(meta instanceof BookMeta){
            BookMeta metaSub = (BookMeta) meta;
            metaSub.setAuthor(author);
            metaSub.setPages(page);
        }
    }

    @Override
    public SubMeta setFrom(ItemMeta meta) {
        if(meta instanceof BookMeta)
        {
            BookMeta metaSub = (BookMeta) meta;
            author = metaSub.getAuthor();
            page = metaSub.getPages();
        }
        return this;
    }
}
