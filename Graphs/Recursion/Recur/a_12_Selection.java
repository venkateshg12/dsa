import java.util.Arrays;

public class a_12_Selection {
    public static void main(String[] args) {
        int[] arr = { 3, 1, 2, 5, 4 };
        selection(arr, arr.length, 0, 0);
        System.out.println(Arrays.toString(arr));
    }

    public static void selection(int[] arr, int n, int c, int max) {
        if (n == 0) {
            return;
        }
        if (c < n) {
            if (arr[c] > arr[max]) {
                selection(arr, n, c + 1, c);
            } else {
                selection(arr, n, c + 1, max);
            }
        } else {
            int temp = arr[max];
            arr[max] = arr[n - 1];
            arr[n - 1] = temp;
            selection(arr, n - 1, 0, 0);
        }
    }
}