// Ceiling : smallest element in the array greater or = given target

// package dsa.Algorithms;
import java.util.Scanner;

public class a_04_Ceiling {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] arr = { 2, 5, 9, 12, 16, 34, 56, 89 };
        int target = 50;
        System.out.println(ceiling(arr, target));
    }
    static int ceiling(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target > arr[mid])
                start = mid + 1;
            else if (target < arr[mid])
                end = mid - 1;
            else
                return mid;
        }
        return end + 1;
        // or return start;
    }
}