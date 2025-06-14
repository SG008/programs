package threading;

public class Deadlock {
    private volatile int i = 0;
    public static void main(String[] args) throws InterruptedException {
        System.out.println("This statement will be executed");

        Thread.currentThread().join();

        System.out.println("This statement will not be executed");
    }
}
