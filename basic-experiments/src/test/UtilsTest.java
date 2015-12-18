import sun.misc.Unsafe;
import unsafe.utils.UnsafeUtils;

/**
 * Created by newton on 11/29/2015.
 */
public class UtilsTest {
    public static void main(String[] args) {
        Unsafe unsafe = UnsafeUtils.getUnsafeHandle();
        experiment1();

        //inst2 created without constructor getting executed
        RandomClass inst2 = (RandomClass) UnsafeUtils.getInstance(RandomClass.class);


    }

    private static void experiment1() {
        //inst1 created without constructor getting executed
        RandomClass inst1 = (RandomClass) UnsafeUtils.getInstance(RandomClass.class);
        //try to invoke init method using reflection for initialization
        invokeInit(inst1);
        System.out.println(inst1.getrString());
    }

    private static void invokeInit(RandomClass randomInstance) {
        UnsafeUtils.invokePrivateMethod(randomInstance,"init");
    }
}

class RandomClass {
    private String rString;

    //using unsafe, Constructor never gets a call
    public RandomClass() {
        init();
    }

    private void init() {
        this.rString = "Helloz ";
    }


    public String getrString() {
        return rString;
    }
}