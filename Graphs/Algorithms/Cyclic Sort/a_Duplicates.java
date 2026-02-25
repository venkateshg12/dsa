package dsa.Kunal_Kushwaha_DSA;

import java.util.Arrays;
// program to find the duplicates using cyclic sort.

public class a_24_Duplicates {
    public static void main(String[] args) {
        int[] arr = { 4, 5, 3, 3, 2, 6, 2 };
        System.out.println(cyclic(arr));
    }

    static int cyclic(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            if (arr[i] != i + 1) {
                int correct = arr[i] - 1;
                if (arr[i] != arr[correct]) {
                    swap(arr, i, correct);
                } else {
                    return arr[i];
                }
            } else {
                i++;
            }
        }
        return -1;
    }

    static void swap(int[] arr, int i, int correct) {
        int temp = arr[i];
        arr[i] = arr[correct];
        arr[correct] = temp;
    }
}
