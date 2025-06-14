
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {
    public static void main(String[] args) {
//        System.out.println(permutations("", "abc"));
//        List<List<Integer>> ans = new ArrayList<>();
//        int[] arr = {1,2,3};
//        arrayPermutation(ans, 0, arr);
//        System.out.println(ans);

        int[] arr = {2, 4, 1, 7, 5, 0};
        nextPermutation(arr);
    }

    private static ArrayList<String> permutations(String p, String up) {

        if (up.isEmpty()) {
            ArrayList<String> ans = new ArrayList<>();
            ans.add(p);
            return ans;
        }

        ArrayList<String> ans = new ArrayList<>();

        char ch = up.charAt(0);

        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i);
            ans.addAll(permutations(f + ch + s, up.substring(1)));
        }

        return ans;
    }

    private static void arrayPermutation(List<List<Integer>> ans, int ind, int[] arr) {
        if (ind == arr.length) {
            ans.add(convertArrayToList(arr));
            return;
        }

        for (int i = ind; i < arr.length; i++) {
            swap(arr, ind, i);
            arrayPermutation(ans, (ind + 1), arr);
            swap(arr, ind, i);
        }
    }

    private static void swap(int[] arr, int fInd, int sInd) {
        int tmp = arr[fInd];
        arr[fInd] = arr[sInd];
        arr[sInd] = tmp;
    }

    private static List<Integer> convertArrayToList(int[] arr) {
        List<Integer> res = new ArrayList<>();
        for (int e : arr) {
            res.add(e);
        }
        return res;
    }


    /*
    Follow the steps below to implement the above observation:
    Iterate over the given array from end and find the first index (pivot) which doesn't follow property of non-increasing suffix, (i.e,  arr[i] < arr[i + 1]).
    If pivot index does not exist, then the given sequence in the array is the largest as possible. So, reverse the complete array. For example, for [3, 2, 1], the output would be [1, 2, 3]
    Otherwise, Iterate the array from the end and find for the successor (rightmost greater element) of pivot in suffix.
    Swap the pivot and successor
    Minimize the suffix part by reversing the array from pivot + 1 till n.
    */
    private static void nextPermutation(int[] arr) {
        int pivot = -1;
        int n = arr.length;
        for (int i = (n - 2); i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                pivot = i;
                break;
            }
        }

        if (pivot == -1) {
            reverseArray(arr, 0, (n - 1));
        } else {
            for (int i = (n - 1); i >= 0; i--) {
                if (arr[i] > arr[pivot]) {
                    swap(arr, pivot, i);
                    break;
                }
            }
            reverseArray(arr, (pivot + 1), (n - 1));
        }

        System.out.println(Arrays.toString(arr));
    }

    private static void reverseArray(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }
}
