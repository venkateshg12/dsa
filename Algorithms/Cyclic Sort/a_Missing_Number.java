package dsa.Kunal_Kushwaha_DSA;

// Program to find the missing number using cyclic sort.

public class a_25_Missing_Number {
    public static void main(String[] args) {
        int[] arr = { 0, 2, 1 };
        System.out.println(missing(arr));
    }

    static int missing(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correct = arr[i];
            if (arr[i] < arr.length && arr[i] != arr[correct]) {
                swap(arr, i, correct);
            } else {
                i++;
            }
        }

        // Search for missing number
        for (i = 0; i < arr.length; i++) {
            if (arr[i] > 0 && arr[i] != i) {
                return i;
            }
        }
        return arr.length;
    }

    static void swap(int[] arr, int i, int correct) {
        int temp = arr[i];
        arr[i] = arr[correct];
        arr[correct] = temp;
    }
}