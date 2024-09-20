public class Pattern {
    public static void main(String[] args) {
//        printPattern1(5);
//        printPattern1Recursion(5, 0);
//        printPattern2(5);
//        printPattern2Recursion(5, 0);

    }

//    * * * * *
//    * * * *
//    * * *
//    * *
//    *
    private static void printPattern1(int lines) {

        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < lines - i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    private static void printPattern1Recursion(int row, int col) {

        if (row == 0) {
            return;
        }

        if (col < row) {
            System.out.print("* ");
            printPattern1Recursion(row, col + 1);
        } else {
            System.out.println();
            printPattern1Recursion(row - 1, 0);
        }
    }

    //    *
//        * *
//        * * *
//        * * * *
//        * * * * *
    private static void printPattern2(int lines) {
        for (int i = 1; i <= lines; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    private static void printPattern2Recursion(int row, int col) {

        if (row == 0) {
            return;
        }

        if (col < row) {
            printPattern2Recursion(row, col + 1);
            System.out.print("* ");
        } else {
            printPattern2Recursion(row - 1, 0);
            System.out.println();
        }
    }
}
