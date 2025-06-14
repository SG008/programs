package basicCodingQuestions;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.print(" " + printFib(i) + " ");
        }
    }

    public static int printFib(int n) {
        if (n <= 1) {
            return 1;
        }

        return printFib(n - 1) + printFib(n - 2);
    }
}
