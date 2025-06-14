package threading;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {

    private static final Queue<Integer> buffer = new LinkedList<>();
    private static final int MAX_SIZE = 5;

    static Runnable consumer = () -> {
        for (int i = 1; i <= 10; i++) {
            synchronized (buffer) {
                if (buffer.isEmpty()) {
                    try {
                        System.out.println("consumer is waiting, buffer is empty");
                        buffer.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                int remove = buffer.remove();
                System.out.println("consumed:- " + remove);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    System.out.println(e.getLocalizedMessage());
                }
                buffer.notifyAll();
            }
        }
    };

    static Runnable producer = () -> {
        for (int i = 1; i <= 10; i++) {
            synchronized (buffer) {
                if (buffer.size() == MAX_SIZE) {
                    try {
                        System.out.println("Producer is waiting, buffer size is full");
                        buffer.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                System.out.println("produced:- " + i);
                buffer.add(i);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    System.out.println(e.getLocalizedMessage());
                }
                buffer.notifyAll();
            }
        }
    };

    public static void main(String[] args) {
        Thread producerThread = new Thread(producer, "producer");
        Thread consumerThread = new Thread(consumer, "consumer");

        producerThread.start();
        consumerThread.start();
    }
}
