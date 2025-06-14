import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CeilAndFloorOfElement {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(11, 28, 36, 39, 57, 65, 71, 85, 98, 150);//37
        int length = arr.size() - 1;
        Scanner s = new Scanner(System.in);
        int k = s.nextInt();
        findCiel(arr, length, k);
        findFloor(arr, length, k);
    }

    private static void findFloor(List<Integer> arr, int length, int k) {
        int start = 0;
        int end = arr.size() - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr.get(mid) == k) {
                System.out.println("Floor of Element --> " + k + " is " + arr.get(mid) + ", Position --> " + (mid));
                return;
            }
            else if (arr.get(mid) < k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println("Floor of Element --> " + k + " is " + arr.get(end) + ", Position --> " + (end));
    }


    private static void findCiel(List<Integer> arr, int length, int element) {
        int end = length;
        int start = 0;
        int mid;

        while (start <= end) {
            mid = start + (end - start) / 2;
            if (arr.get(mid) == element) {
                System.out.println("Ceil of Element --> " + element + " is " + arr.get(mid) + ", Position --> " + (mid));
                return;
            } else if (element < arr.get(mid)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println("Ceil of Element --> " + element + " is " + arr.get(start) + ", Position --> " + (start));
    }
}
