package milkyway.SaveableSerializing.Java8.API;

/**
 * Created by Developer_Unlocated on 2017-05-22.
 */
public class WithoutExcpetionParser {
    public static int parse(String toParse,int defaultInteger){
        try{
            return Integer.parseInt(toParse);
        }catch (Exception ex){}
        return defaultInteger;
    }
}
