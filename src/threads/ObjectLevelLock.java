package threads;

public class ObjectLevelLock {

    static class Display {

        int i = 0;

        /*synchronized*/ void display(String thread) {
            for (int j = 0; j < 10; j++)
                System.out.println(thread + " - " + i++);
        }
    }

    static class MyThread extends Thread {
        String name;
        Display display;

        MyThread(String name, Display display) {
            this.name = name;
            this.display = display;
        }

        public void run() {
            int a = 4;
            synchronized (display) {
                display.display(name);
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main thread starts");
        Display display = new Display();
        MyThread t1 = new MyThread("t1", display);
        MyThread t2 = new MyThread("t2", display);
        t1.start();
        t2.start();
        t1.join();
//        t2.join();
        System.out.println("Main thread finishes");
    }

}
