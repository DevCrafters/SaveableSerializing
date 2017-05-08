package milkyway.SaveableSerializing.ItemStacks.Lower_1_5_2.ItemData.ItemMetas;

import milkyway.SaveableSerializing.Parser.SaveableData;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * Created by Developer_Unlocated on 2017-04-17.
 */
public abstract  class SubMeta implements SaveableData{
    public abstract void setTo(ItemMeta meta);
    public abstract SubMeta setFrom(ItemMeta meta);
    public Object getOriginal() {
        return null;
    }
}
