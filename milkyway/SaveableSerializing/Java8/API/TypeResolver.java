package milkyway.SaveableSerializing.Java8.API;

import milkyway.SaveableSerializing.Parser.SaveableData;

/**
 * Created by Developer_Unlocated on 2017-05-11.
 */
public interface TypeResolver {
    public boolean canResolve(Object obj);
    public class StringResolver implements TypeResolver{

        @Override
        public boolean canResolve(Object obj) {
            return obj instanceof String;
        }
    }
    public class IntegerResolver implements TypeResolver{

        @Override
        public boolean canResolve(Object obj) {
            return obj instanceof Integer;
        }
    }
    public class ByteResolver implements TypeResolver{

        @Override
        public boolean canResolve(Object obj) {
            return obj instanceof Byte;
        }
    }
    public class DoubleResolver implements TypeResolver{

        @Override
        public boolean canResolve(Object obj) {
            return obj instanceof Double;
        }
    }
    public class FloatResolver implements TypeResolver{

        @Override
        public boolean canResolve(Object obj) {
            return obj instanceof Float;
        }
    }

    public class EmprtyResolver implements TypeResolver{

        @Override
        public boolean canResolve(Object obj) {
            return true;
        }
    }
    public class SaveableResolver implements TypeResolver{

        @Override
        public boolean canResolve(Object obj) {
            return obj instanceof SaveableData;
        }
    }
}
