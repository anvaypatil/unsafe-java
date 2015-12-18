/**
 * Created by newton on 12/10/2015.
 */
public class OtherClass {
    public static void main(String[] args) {
        //experiment1();
        experiment2();
    }

    private static void experiment2() {
        final int xvar = 99;
        class InnerLocal {
            int x;
            public InnerLocal() {
                x = xvar;
            }

            public void call() {
                System.out.println("xvar-->" + xvar);
            }
        }
        InnerLocal il;
        il = new InnerLocal();
        il.call();
        //xvar=565;
        il = new InnerLocal();
        il.call();
    }

    private static void experiment1() {
        A a = new A();
        A.InnerA ia = a.new InnerA();
        ia.doSomething();
    }
}

class A {
    private int x;

    class InnerA {
        public InnerA() {
            x = 40;
        }

        public void doSomething() {
            System.out.println("Outer -->" + x);
            x = 43;
            System.out.println("Outer -->" + x);
        }
    }
}