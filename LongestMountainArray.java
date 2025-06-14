public class LongestMountainArray {
    public static void main(String[] args) {
        int[] a = { 1, 3, 1, 4, 5, 6, 7,
                8, 9, 8, 7, 6, 5 };

        System.out.println(findLongestMountain(a));
    }

    public static int findLongestMountain(int[] arr) {
        int res = 0;

        for (int i = 1; i <= arr.length - 2;) {
            if (arr[i - 1] < arr[i] && arr[i + 1] < arr[i]) {
                int count = 0;
                int l = i;

                while (l > 0 && arr[l] > arr[l - 1]) {
                    count++;
                    l--;
                }
                while (i <= arr.length - 2 && arr[i] > arr[i + 1]) {
                    count++;
                    i++;
                }

                res = Math.max(res, count);
            } else {
                i++;
            }
        }
        return res > 0 ? (res + 1) : res;
    }
}
