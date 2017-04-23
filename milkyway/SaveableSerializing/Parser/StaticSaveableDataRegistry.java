package milkyway.SaveableSerializing.Parser;

import milkyway.ItemManagerAdvanced.API.ItemType;
import milkyway.ItemManagerAdvanced.API.TopItems;
import milkyway.ItemManagerAdvanced.Datas.DataTypes.ListRGB;
import milkyway.ItemManagerAdvanced.Datas.DataTypes.ListSaveable;
import milkyway.ItemManagerAdvanced.Datas.DataTypes.RGBColor;
import milkyway.ItemManagerAdvanced.Datas.ItemData.EnchantArray;
import milkyway.ItemManagerAdvanced.Datas.ItemData.Enchants;
import milkyway.ItemManagerAdvanced.Datas.ItemData.FireworkEffects;
import milkyway.ItemManagerAdvanced.Datas.ItemData.ItemMetas.*;
import milkyway.ItemManagerAdvanced.Datas.ItemData.ItemStacks;

import java.util.HashMap;

/**
 * Created by Developer_Unlocated on 2017-04-18.
 */
public class StaticSaveableDataRegistry {
    private static StaticSaveableDataRegistry handle = new StaticSaveableDataRegistry();
	/**
	*   반드시 이 선언부에 사용하실 클래스의 인스턴스를 등록해 주셔야 합니다.
	*   등록되지 않은 인스턴스의 경우,NullSaveableData로 처리되어 눌값이 반환됩니다.
	*/
	private StaticSaveableDataRegistry(){
        registerSaveable(new ListRGB());
        registerSaveable(new ListSaveable());
        registerSaveable(new RGBColor());
        registerSaveable(new DefaultMeta());
        registerSaveable(new FireworkEffectsMeta());
        registerSaveable(new FireworksMeta());
        registerSaveable(new HeadMeta());
        registerSaveable(new LeatherArmoursMeta());
        registerSaveable(new PotionMeta());
        registerSaveable(new SaveableBookMeta());
        registerSaveable(new SaveableEnchantBook());
        registerSaveable(new EnchantArray());
        registerSaveable(new Enchants());
        registerSaveable(new FireworkEffects());
        registerSaveable(new ItemStacks());
        registerSaveable(new NullSaveableData());
        registerSaveable(new PotionEffects());
        registerSaveable(new ItemType(false,false));
        registerSaveable(new TopItems());
    }
    public static StaticSaveableDataRegistry getHandle(){
        return handle;
    }
    private HashMap<String,SaveableData> tempDAta = new HashMap<>();
    public void registerSaveable(SaveableData data){
        if(data.getName() == null)
            return;
        tempDAta.put(data.getName(),data);
    }

    public SaveableData getDataWithNewInstance(String data){
        if(!tempDAta.containsKey(data))
            return new NullSaveableData();
        return tempDAta.get(data).getNewInstance();
    }

}
