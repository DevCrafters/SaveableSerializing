package milkyway.SaveableSerializing.ItemStacks.Upper_1_7.ItemData.ItemMetas;

import milkyway.SaveableSerializing.Parser.SaveableData;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.List;

/**
 * Created by Developer_Unlocated on 2017-04-18.
 */
public class HeadMeta extends SubMeta {
    String owner = "Player";
    @Override
    public void writeBy(StringBuilder builder) {
        builder.append(owner).append("\n");
    }

    @Override
    public void appendTo(List<String> builded) {
        try{
            owner = builded.get(0);
        }catch (Exception ex){}
    }

    @Override
    public String getName() {
        return "SubMeta-HeadMeta";
    }

    @Override
    public void appendObject(String str, SaveableData data) {

    }

    @Override
    public SaveableData getNewInstance() {
        return new HeadMeta();
    }

    @Override
    public void setTo(ItemMeta meta) {
        if(meta instanceof SkullMeta)
            ((SkullMeta)meta).setOwner(owner);
    }

    @Override
    public SubMeta setFrom(ItemMeta meta) {
        if(meta instanceof SkullMeta)
            owner = ((SkullMeta)meta).getOwner();
        return this;
    }
}
