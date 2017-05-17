package milkyway.SaveableSerializing.ItemStacks.Lower_1_7.ItemData;

import milkyway.SaveableSerializing.Parser.SaveableData;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Developer_Unlocated on 2017-04-17.
 */
public class EnchantArray implements SaveableData,ItemValidator{
    private List<Enchants> myEnchant = new ArrayList<>();
    public EnchantArray(){}
    public EnchantArray(ItemStack stack){
        for(Enchantment ment : stack.getEnchantments().keySet())
            myEnchant.add(new Enchants(ment,stack.getEnchantmentLevel(ment)));

    }
    @Override
    public void writeBy(StringBuilder builder) {
        for(Enchants a : myEnchant)
            a.appendSubSet(builder);
    }

    @Override
    public void appendTo(List<String> builded) {

    }

    @Override
    public String getName() {
        return "EnchantArray";
    }

    @Override
    public void appendObject(String str, SaveableData data) {
        if(str.equals("Enchant"))
            myEnchant.add((Enchants) data);
    }

    @Override
    public Object getOriginal() {
        return null;
    }

    @Override
    public SaveableData getNewInstance() {
        return new EnchantArray();
    }

    @Override
    public void setToItemStack(ItemStack stack) {
        for(Enchants a : myEnchant){
            Enchantment enchantData = Enchantment.getById(a.id);
            if(enchantData != null)
                stack.addUnsafeEnchantment(enchantData,a.level);
        }
    }
}
