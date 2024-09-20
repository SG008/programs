import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(11, 28, 36, 39, 57, 65, 71, 85, 98, 150);//37
        int length = arr.size() - 1;
        Scanner s = new Scanner(System.in);
        int k = s.nextInt();
        binary(arr, length, k);
    }


    private static void binary(List<Integer> arr, int length, int element) {
        int mid = length / 2;
        int end = length;
        int start = 0;

        while (start <= end) {
            mid = (start + end) / 2;
            if (arr.get(mid) == element) {
                System.out.println("Ceil of Element --> " + element + " is " + arr.get(mid) + ", Position --> " + (mid));
                return;
            } else if (element < arr.get(mid)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println("Ceil of Element --> " + element + " is " + arr.get(mid) + ", Position --> " + (mid));
    }
}
