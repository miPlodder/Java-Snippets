package threads;

/**
 * We have a consumer, a producer and a queue.
 * <p>
 * To make sure that the producer won’t try to add data into the buffer if it’s full,
 * and that the consumer won’t try to remove data from an empty buffer.
 */
public class ProducerConsumerProblem {

    static class Queue {
        int n = 0;
        boolean valueSet = false;

        synchronized int get() {
            while (!valueSet) {
                try {
                    wait();
                } catch (InterruptedException ex) {
                    System.out.println(ex);
                }
            }

            System.out.println("Got: " + n);
            valueSet = false;
            notify();
            return n;
        }

        synchronized void put(int n) {
            while (valueSet) {
                try {
                    wait();
                } catch (InterruptedException ex) {
                    System.out.println(ex);
                }
            }
            this.n = n;
            valueSet = true;
            System.out.println("Put: " + n);
            notify();
        }
    }

    static class Producer implements Runnable {

        Queue q;

        Producer(Queue q) {
            this.q = q;
            new Thread(this, "Producer").start();
        }

        @Override
        public void run() {
            int i = 0;
            // we have an infinite while loop here as thread should be still running to produce the next event
            while (true) {
                q.put(i++);
            }
        }
    }

    static class Consumer implements Runnable {

        Queue q;

        Consumer(Queue q) {
            this.q = q;
            new Thread(this, "Consumer").start();
        }

        @Override
        public void run() {
            // we have an infinite while loop here as thread should be still running to consume the next event
            while (true) {
                q.get();
            }
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        new Producer(q);
        new Consumer(q);


        System.out.println("Press Control-C to stop");
    }

}
