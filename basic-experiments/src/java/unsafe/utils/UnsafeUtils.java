package unsafe.utils;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by newton on 11/29/2015.
 * The class intended to acquire unsafe handle
 */
public class UnsafeUtils {

    public static Unsafe getUnsafeHandle() {
        Unsafe unsafe = null;
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            unsafe = (Unsafe) f.get(null);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return unsafe;
    }

    public static Object getInstance(Class clz) {
        Unsafe unsafe = getUnsafeHandle();
        try {
            return unsafe.allocateInstance(clz);
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object invokePrivateMethod(Object instance, String methodName){
        Object retObject=null;
        try {
            //trying to invoke method using reflection
            Method method=instance.getClass().getDeclaredMethod(methodName);
            method.setAccessible(true);
            retObject=method.invoke(instance);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return retObject;
    }
    /**
     * Todo for all data base types  B C D F I J S Z
     * http://docs.oracle.com/javase/specs/jvms/se8/html/jvms-4.html#jvms-4.3.2-200
     */
    public static void setPrivateVariable(Object instance, String privateField, Object value){
        Unsafe unsafe = getUnsafeHandle();
        Field f = getField(instance, privateField);
        unsafe.putObject(instance, unsafe.objectFieldOffset(f), value); // memory corruption
    }

    private static Field getField(Object instance, String privateField) {
        Field f = null;
        try {
            f = instance.getClass().getDeclaredField(privateField);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return f;
    }

}
