package milkyway.SaveableSerializing.Java8.API;

import milkyway.SaveableSerializing.Parser.SaveableData;

/**
 * Created by Developer_Unlocated on 2017-05-11.
 */
public interface TypeResolver {
    public boolean canResolve(Object obj);
    public Object resolve(Object obj);
    public class StringResolver implements TypeResolver{

        @Override
        public boolean canResolve(Object obj) {
            return obj == null || obj instanceof String;
        }
        public Object resolve(Object obj){
            return obj;
        }
    }
    public class IntegerResolver implements TypeResolver{

        @Override
        public boolean canResolve(Object obj) {
            return obj == null || obj instanceof Integer;
        }
        public Object resolve(Object obj){
            if(obj != null && obj instanceof String)
                try{return Integer.parseInt((String)obj);}catch (Exception ex){}
            return obj;
        }
    }
    public class ByteResolver implements TypeResolver{

        @Override
        public boolean canResolve(Object obj) {
            return obj == null ||obj instanceof Byte;
        }
        public Object resolve(Object obj){
            if(obj != null && obj instanceof String)
                try{return Byte.parseByte((String)obj);}catch (Exception ex){}
            return obj;
        }
    }
    public class DoubleResolver implements TypeResolver{

        @Override
        public boolean canResolve(Object obj) {
            return obj == null || obj instanceof Double;
        }
        public Object resolve(Object obj){
            if(obj != null && obj instanceof String)
                try{return Double.parseDouble((String)obj);}catch (Exception ex){}
            return obj;
        }
    }
    public class FloatResolver implements TypeResolver{

        @Override
        public boolean canResolve(Object obj) {
            return obj == null || obj instanceof Float;
        }
        public Object resolve(Object obj){
            if(obj != null && obj instanceof String)
                try{return Float.parseFloat((String)obj);}catch (Exception ex){}
            return obj;
        }
    }

    public class EmprtyResolver implements TypeResolver{

        @Override
        public boolean canResolve(Object obj) {
            return true;
        }
        public Object resolve(Object obj){
            return obj;
        }
    }
    public class SaveableResolver implements TypeResolver{

        @Override
        public boolean canResolve(Object obj) {
            return obj == null || obj instanceof SaveableData;
        }
        public Object resolve(Object obj){
            return obj;
        }
    }
}
