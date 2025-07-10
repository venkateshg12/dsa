// package dsa.Recursion;

public class a_09_SortedArray {
    public static void main(String[] args) {
        int[] arr = { 0, 1, 3, 4, 7, 9, 12, 16, 20 };
        System.out.println(isArraySorted(arr, 0) ? "Array is sorted" : "Array is not sorted");
    }

    public static boolean isArraySorted(int[] arr, int i) {
        if(i  == arr.length - 1){
            return true;
        }
        return  (arr[i] < arr[i + 1]) && isArraySorted(arr, i + 1);

    }
}
