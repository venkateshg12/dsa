package dsa.Kunal_Kushwaha_DSA;
import java.util.*;

public class a_23_Cyclic_Sort {
    public static void main(String[] args) {
        int[] arr = {3, 5, 2, 1, 4};
        Cyclic(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void Cyclic(int[] arr) {
        int i = 0;
        while(i < arr.length) {
            int correct = arr[i] - 1;
            if(arr[i] != arr[correct]){
                swap(arr, i, correct);
            } else {
                i++;
            }
        }
    }

    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}