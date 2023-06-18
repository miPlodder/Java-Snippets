package threads;

/**
 * This class depicts class level locks aka locks on static
 */
public class ClassLevelLock {

    static class A {

        static int a = 0;

        public synchronized static void method(String msg) {
//            synchronized (A.class) {
            for (int i = 0; i < 10; i++)
                System.out.println(msg + a++);
//            }
        }
    }

    static class ThreadWrapper extends Thread {

        String threadName;

        public ThreadWrapper(String threadName) {
            this.threadName = threadName;
        }

        @Override
        public void run() {
            A.method(threadName);
            System.out.println(threadName + "finished");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadWrapper t1 = new ThreadWrapper("T1 ");
        ThreadWrapper t2 = new ThreadWrapper("T2 ");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("main method finished");
    }
}
