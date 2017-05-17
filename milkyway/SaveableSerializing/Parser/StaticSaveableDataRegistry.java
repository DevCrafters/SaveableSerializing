package milkyway.SaveableSerializing.Parser;



import java.util.HashMap;

/**
 * Created by Developer_Unlocated on 2017-04-18.
 */
public class StaticSaveableDataRegistry {
    private static StaticSaveableDataRegistry handle = null;
	/**
	*   반드시 이 선언부에 사용하실 클래스의 인스턴스를 등록해 주셔야 합니다.
	*   등록되지 않은 인스턴스의 경우,NullSaveableData로 처리되어 눌값이 반환됩니다.
     *
     *  You must register your custom Saveable Object's instance here.
     *  If {@link SaveableDataReader} read unregistered object,SaveableReader will return {@link NullSaveableData}
	*/
    public static StaticSaveableDataRegistry getHandle(){
        if(handle == null)
        {
            handle = new StaticSaveableDataRegistry();
            new MinecraftParser_Lower152().register();
            new MinecraftParser_All().register();
            new Java8_Parser().register();
        }
        return handle;
    }
	private StaticSaveableDataRegistry(){}

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
