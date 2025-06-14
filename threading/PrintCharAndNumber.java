package threading;

// output --> A1 B2 C3 D4 E5 F6 G7 H8 I9 J10 K11 L12 M13 N14 O15 P16 Q17 R18 S19 T20 U21 V22 W23 X24 Y25 Z26
public class PrintCharAndNumber {

    private static final Object lock = new Object();
    private static boolean isLetterTurn = true;

    public static void main(String[] args) throws InterruptedException {
        Runnable printCharacter = () -> {
            synchronized (lock) {
                for (int i = 'A'; i <= 'Z'; i++) {
                    if (isLetterTurn) {
                        System.out.print((char) i);
                        isLetterTurn = false;
                        lock.notify();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
                lock.notify();
            }
        };

        Runnable printNumber = () -> {
            synchronized (lock) {
                for (int i = 1; i <= 26; i++) {
                    if (!isLetterTurn) {
                        System.out.print(i + " ");
                        isLetterTurn = true;
                        lock.notify();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        };

        Thread thread1 = new Thread(printCharacter, "Character");
        Thread thread2 = new Thread(printNumber, "Number");

        thread1.join();
        thread2.join();

        thread1.start();
        thread2.start();
    }
}
