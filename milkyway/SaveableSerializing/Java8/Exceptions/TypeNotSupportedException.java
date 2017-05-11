package milkyway.SaveableSerializing.Java8.Exceptions;

/**
 * Created by Developer_Unlocated on 2017-05-11.
 */
public class TypeNotSupportedException extends ExceptionTranslated{
    public TypeNotSupportedException() {
        super("Collections parser only supported java basic type(String,Inetger,Double..) and Saveable Data. ");
    }
}
