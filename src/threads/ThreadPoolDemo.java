package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {

    /**
     * In this case we thread is not returning anything
     * */
    static class WorkerThread implements Runnable {

        String name;

        public WorkerThread(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println("Starting Thread " + name);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Ending Thread " + name);
        }
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 6; i++) {
            Runnable worker = new WorkerThread("t" + i);
            executor.execute(worker);
        }

        // this will shutdown the executor
        executor.shutdown();
        // this is like join() method, main thread waits for the executor to finish
        while (!executor.isTerminated()) {
        }

        System.out.println("Finishing all threads");
    }
}
