package milkyway.SaveableSerializing.Parser;

/**
 * Created by Developer_Unlocated on 2017-05-08.
 *
 * 이 클래스는 {@link StaticSaveableDataRegistry}에서의 객체 인스턴스 개별 등록을 위한 인터페이스입니다.
 *
 * This class use at register Saveable Object's instance at {@link StaticSaveableDataRegistry}
 */
public interface ParserRegistry {
    public void register();
}
