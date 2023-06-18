package threads;

public class Deadlock {

    static class A {
        synchronized void aaa(B b) {
            for (int i = 0; i < 10000; i++)
                b.last();
        }

        synchronized void last() {
            System.out.println("A.last");
        }
    }

    static class B {
        synchronized void bbb(A a) {
            for (int i = 0; i < 10000; i++)
                a.last();
        }

        synchronized void last() {
            System.out.println("B.last");
        }

    }

    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        Thread t1 = new Thread(() -> a.aaa(b));
        Thread t2 = new Thread(() -> b.bbb(a));
        t1.start();
        t2.start();
    }

}
