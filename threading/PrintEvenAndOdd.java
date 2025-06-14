package threading;

public class PrintEvenAndOdd {
    private int n = 1;
    private final int ctr = 10;

    public void isEven() {

        synchronized (this) {
            while (ctr >= n) {
                if (n % 2 == 0) {
                    System.out.println(n + " : EVEN");
                    n++;
                }
                try {
                    notify();
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void isOdd() {
        synchronized (this) {
            while (ctr >= n) {
                if (n % 2 == 1) {
                    System.out.println(n + " : ODD");
                    n++;
                }
                try {
                    notify();
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            notify();
        }
    }

    public static void main(String[] args) {
        PrintEvenAndOdd obj = new PrintEvenAndOdd();

        Runnable even = obj::isEven;
        Runnable odd = obj::isOdd;

        Thread t1 = new Thread(even);
        Thread t2 = new Thread(odd);

        t1.start();
        t2.start();
    }
}
