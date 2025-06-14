package threading;

class MyThread1 implements Runnable {
    @Override
    public void run() {

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
            System.out.println("status of calling thread when called join on MyThread1"
                                                                    + ThreadLifecycle.t2.getState());


    }
}

public class ThreadLifecycle implements Runnable {
    public static ThreadLifecycle t1;
    public static Thread t2;

    @Override
    public void run() {
        MyThread1 t3 = new MyThread1();
        Thread t = new Thread(t3);

        System.out.println("status of thread after its creation : " + t.getState());

        t.start();
        System.out.println("status of thread after its calling start function : " + t.getState());

        try {
            t.sleep(100);
            System.out.println("status of thread after its calling sleep function : " + t.getState());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            t.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("status of thread after completion : " + t.getState());

    }
    public static void main(String[] args) {
        t1 = new ThreadLifecycle();
        t2 = new Thread(t1);

        t2.start();
    }
}
