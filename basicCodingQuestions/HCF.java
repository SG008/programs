package basicCodingQuestions;

public class HCF {
    public static void main(String[] args) {
        findHcf(24, 36);
    }

    public static void findHcf(int a, int b) {
        while (b != 0) {
            int n = a % b;
            a = b;
            b = n;
        }
        System.out.println("HCF is: " + a);
    }
}
