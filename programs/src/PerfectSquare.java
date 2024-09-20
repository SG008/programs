public class PerfectSquare {
    public static void main(String[] args) {
        System.out.println(isPerfectSquare(16));
    }
    public static boolean isPerfectSquare(int num) {

        if (num == 1)
            return true;
        int left = 1;
        int right = num / 2;
        while (left <= right) {
            int mid = (left + right) / 2;
            if ((long) mid * mid == num)
                return true;
            else if ((long) mid * mid > num)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return false;
    }
}
