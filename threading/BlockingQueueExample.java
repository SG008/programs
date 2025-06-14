package threading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import static java.lang.Thread.sleep;

public class BlockingQueueExample {

    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);

        ProducerService producerService = new ProducerService(queue);
        ConsumerService consumerService = new ConsumerService(queue);

        Thread consumer = new Thread(consumerService);
        Thread producer = new Thread(producerService);

        producer.start();
        consumer.start();
    }

    static public class ConsumerService implements Runnable {
        BlockingQueue<Integer> queue = null;

        public ConsumerService(BlockingQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Consuming " + queue.take());
                }
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    static public class ProducerService implements Runnable {
        BlockingQueue<Integer> queue = null;

        public ProducerService(BlockingQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    System.out.println("producing " + (i+1));
                    queue.put(i+1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
