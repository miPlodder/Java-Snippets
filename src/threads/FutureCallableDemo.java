package threads;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Callable is similar to Runnable, in that it encapsulates a task that is meant to run on another thread,
 * whereas a Future is used to store a result obtained from a different thread.
 */
public class FutureCallableDemo {

    /**
     * Callable is similar to Runnable, in that it encapsulates a task that is meant to run on another thread
     */
    static class CallableWrapper implements Callable<Object> {
        @Override
        public Object call() throws Exception {
            Random generator = new Random();
            Integer randomNumber = generator.nextInt(5);
            Thread.sleep(randomNumber * 1000);
            return randomNumber;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("main() starts");
        /**
         *  Future is used to store a result obtained from a different thread.
         * */
        FutureTask[] randomNumberTasks = new FutureTask[5];
        for (int i = 0; i < 5; i++) {
            CallableWrapper callable = new CallableWrapper();
            randomNumberTasks[i] = new FutureTask(callable);
            Thread th = new Thread(randomNumberTasks[i]);
            th.start();
            System.out.println("Running thread " + i);
        }
        System.out.println("All FutureTask started");
        for (int i = 0; i < 5; i++) {
            System.out.println(randomNumberTasks[i].get());
        }
        System.out.println("main() finishes");
    }
}
