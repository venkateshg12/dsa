// package dsa.Algorithms.QuickSort;

import java.util.Arrays;
public class a_01_QuickSort {
    public static void main(String[] args) {
        int[] arr = { 3, -4, 13, -34, 12, 7, 2, 1 };
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int low, int high) {
        if(low >= high) {
            return;
        }
        
        int s  = low;
        int e = high;
        int m = s + (e - s) / 2;
        int pivot = arr[m];
        while(s <= e) {
            while(arr[s] < pivot) {
                s++;
            }
            while (arr[e] > pivot) {
                e--; 
                
            }
            if(s <= e) {
                int temp = arr[s];
                arr[s] = arr[e];
                arr[e] = temp;
                s++;
                e--;
            }
        }
        // now my pivot at current index, sort the two halves
        quickSort(arr, low, e);
        quickSort(arr, s, high);
    }
}