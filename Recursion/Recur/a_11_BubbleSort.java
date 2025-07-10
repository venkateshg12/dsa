// package dsa.Recursion;

import java.util.Arrays;

public class a_11_BubbleSort {
    public static void main(String[] args) {
        int[] arr = { 3, 1, 2, 5, 4 };
        bubble(arr, arr.length - 1, 0);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubble(int[] arr, int n, int c) {
        if (n == 0) {
            return;
        }

        if (c < n) {
            if (arr[c] > arr[c + 1]) {
                int temp = arr[c];
                arr[c] = arr[c + 1];
                arr[c + 1] = temp;
            }
            bubble(arr, n, c + 1);
        } else {
            bubble(arr, n - 1, 0);
        }
    }
}