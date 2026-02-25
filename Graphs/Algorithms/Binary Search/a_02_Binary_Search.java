package dsa.Kunal_Kushwaha_DSA;

// Binary Search.

public class a_02_Binary_Search {
    public static void main(String[] args) {
        int[] arr = { -12, -9, -5, -2, 0, 4, 7, 9, 12, 34, 56, 85, 90, 99 };
        int target = 12;
        System.out.println("Element found in " +binarySearch(arr, target) +" index");
    }

    static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + ((end - start) / 2);
            if (target > arr[mid])
                start = mid + 1;
            else if (target < arr[mid])
                end = mid - 1;
            else
                return mid;
        }
        return -1;
    }
}
