package leetcode.demo.threads;

//Example for working with threads
public class ThreadSipmleTask_Counter {


    public static class Counter {
        private int value;

        public void count() {
            ++value;
        }

        public int getValue() {
            return value;
        }

    }

    public static void main(String[] args) {

        final Counter counter = new Counter();

        Runnable task = () -> {
            for (int i = 0; i < 100; i++) {
                counter.count();


                System.out.println("Nn " + i + " and the thread " + Thread.currentThread().getName() + " value: " + counter.getValue());
            }


        };
        for (int i = 0; i < 100; i++) {
            new Thread(task).start();

        }

        System.out.println("Counter result:" + counter.getValue());

    }

}
