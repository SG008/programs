package threading;

import java.beans.IntrospectionException;

public class DeadLockExample {

    static class worker implements Runnable {

        private final Object obj1;
        private final Object obj2;

        worker (Object obj1, Object obj2) {
            this.obj1 = obj1;
            this.obj2 = obj2;
        }

        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            System.out.println(name + " acquiring lock on " + obj1);
            synchronized (obj1) {
                System.out.println(name + " acquired lock on " + obj1);
                work();
                System.out.println(name + " acquiring lock on " + obj2);
                synchronized (obj2) {
                    System.out.println(name + " acquired lock on " + obj2);
                    work();
                }
                System.out.println(name + " released lock on " + obj2);
            }
            System.out.println(name + " released lock on " + obj1);
            System.out.println(name + " finished execution");
        }

        private void work() {
            try {
                Thread.sleep(30000);
            } catch (InterruptedException ie) {
                ie.getLocalizedMessage();
            }
        }
    }

    public static void main(String[] args) {
        Object obj1 = new Object();
        Object obj2 = new Object();
        Object obj3 = new Object();

        Thread worker1 = new Thread(new worker(obj1, obj2), "Worker1");
        Thread worker2 = new Thread(new worker(obj2, obj3), "Worker2");
        Thread worker3 = new Thread(new worker(obj3, obj1), "Worker3");

        try {
            worker1.start();
            Thread.sleep(5000);
            worker2.start();
            Thread.sleep(5000);
            worker3.start();
        } catch (InterruptedException ie) {
            System.out.println(ie.getLocalizedMessage());
        }
    }
}
