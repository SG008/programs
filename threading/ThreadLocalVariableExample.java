package threading;


public class ThreadLocalVariableExample {

    static public class MyThread implements Runnable {

        private ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

        @Override
        public void run() {
            threadLocal.set( (int) (Math.random() * 50D) );
            System.out.println("Thread ID: " + Thread.currentThread().getId() + " Value: " + threadLocal.get());
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new MyThread());
        Thread t2 = new Thread(new MyThread());
        t1.start();
        t2.start();
    }

}
