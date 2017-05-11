package milkyway.SaveableSerializing.Parser;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

/**
 * Created by Developer_Unlocated on 2017-04-17.
 * 오직 이 클래스를 상속받은 개체만이 SaveableData로 작성이 될 수 있습니다.
 */
public interface SaveableData {
	/**
	* 이 메소드는 이 직렬화 객체가 입력 단계에 이르렀을 때 입력할 내용을 담으면 됩니다.
	* 만약 288과 0을 쓰고 싶다면
	* 메소드 안에 builder.append("288").append("\n").append("0").append("\n"); 식으로 사용해주세요.
	* 이 메소드의 끝은 반드시 \n으로 끝나야 합니다.
	* 만약 서브 메타 클래스가 있을 경우,
	* data.appendSubSet(builder);로 사용하시면 됩니다.
	*/
   void writeBy(StringBuilder builder) ;
   
   /**
   * 이 메소드는 이 직렬화 객체가 파일에서 읽어 들어와졌을 시,읽어진
   * 스트링을 List<String>으로 넣어줍니다.
   * 만약 288,0을 위에서 입력하였고 이 클래스에 다시 넣어주고 싶다면
   * code = Integer.parseInt(builded.get(0));
   * durability = Integer.parseInt(builded.get(1));
   * 식으로 해주면 됩니다.
   */
    void appendTo(List<String> builded);
	/**
	* 이 객체의 직렬화 이름을 돌려줍니다.
	*/
    String getName();
	
	/**
	* 이 객체가 저장할때 서브 레벨 직렬화 객체를 입력했을 경우,
	* List<String>에서 제외하고 이 메소드로 차례대로 불러집니다.
	*/
    void appendObject(String str,SaveableData data);
    default void appendSubSet(StringBuilder build){
        build.append("start subset ").append(getName()).append("\n");
        writeBy(build);
        build.append("end subset\n");
    }
	/**
	* 읽어와진 오브젝트를 원본으로 반환합니다.
    * 유일하게 null이 허용됩니다.
	*/
    Object getOriginal();
	/**
	* 이 객체의 새로운 인스턴스를 받습니다.
	* null이 되면 안되며,반드시 이 객체의 새로운 인스턴스를 반환하세요.
	*/
    SaveableData getNewInstance();
}
