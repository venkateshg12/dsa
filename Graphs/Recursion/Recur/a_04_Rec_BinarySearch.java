// package dsa.Recursion;

public class a_04_Rec_BinarySearch {
    public static void main(String[] args) {
        int[] arr = { 0, 2, 3, 7, 9, 12, 16, 17, 20, 21, 22, 23, 30, 34, 37, 40, 43, 45, 50, 52 };
        int key = 21;
        int s = 0;
        int e = arr.length - 1;
        int ans = recursiveBinarySearch(arr, key, s, e);
        System.out.println(ans == -1 ? "Key not found" : ans);
    }

    public static int recursiveBinarySearch(int[] arr, int key, int s, int e) {
        if (s > e) {
            return -1;
        }

        int m = s + (e - s) / 2;
        if (arr[m] == key) {
            return m;
        }

        if (arr[m] < key) {
            return recursiveBinarySearch(arr, key, s, m - 1);
        } else {
            return recursiveBinarySearch(arr, key, m + 1, e);
        }
    }
}
