
import java.util.Arrays;

public class a_03_MergeSort {
    public static void main(String[] args) {
        int[] arr = { 3, 2, 56, 12, 4 };
        mergeSort(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int s, int e) {
        if (e - s == 1) {
            return;
        }
        int mid = (s + e) / 2;
        mergeSort(arr, s, mid);
        mergeSort(arr, mid, e);
        merge(arr, s, mid, e);
    }

    public static void merge(int[] arr, int s, int mid, int e) {
        int[] mix = new int[e - s];
        int i = s;
        int j = mid;
        int k = 0;
        while (i < mid && j < e) {
            if (arr[i] < arr[j]) {
                mix[k] = arr[i];
                i++;
            } else {
                mix[k] = arr[j];
                j++;
            }
            k++;
        }

        while (i < mid) {
            mix[k] = arr[i];
            i++;
            k++;
        }
        while (j < e) {
            mix[k] = arr[j];
            j++;
            k++;
        }

        for (int l = 0;l < mix.length;l++) {
            arr[s + l] = mix[l];
        }
    }
}
