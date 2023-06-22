package threads;

public class ThreadGroupDemo {

    static class ThreadDemo extends Thread {

        public ThreadDemo(ThreadGroup tg, String name) {
            super(tg, name);
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(super.getName());
        }
    }

    public static void main(String[] args) {
        ThreadGroup tg = new ThreadGroup("tg");
        ThreadDemo t1 = new ThreadDemo(tg, "t1");
        ThreadDemo t2 = new ThreadDemo(tg, "t2");
        t1.start();
        t2.start();
        System.out.println(tg.activeCount());
    }
}
