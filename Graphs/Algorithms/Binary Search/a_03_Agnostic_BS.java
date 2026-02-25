package dsa.Algorithms;

// Order Agnostic Binary Search

public class a_03_Agnostic_BS {
    public static void main(String[] args) {
        // int[] arr = { -12, -9, -5, -2, 0, 4, 7, 9, 12, 34, 56, 85, 90, 99 };
        int[] arr = { 88, 78, 67, 56, 45, 40, 23, 19, 16, 12, 8, 4 };
        int target = 12;
        System.out.println("Element found in " + orderAgnosticBS(arr, target) + " index");
    }

    static int orderAgnosticBS(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        boolean isAsc = arr[start] < arr[end];
        while (start <= end) {
            int mid = start + ((end - start) / 2);
            if (arr[mid] == target)
                return mid;

            else if (isAsc) {
                if (target > arr[mid])
                    start = mid + 1;
                else
                    end = mid - 1;
            } else {
                if (target > arr[mid])
                    end = mid - 1;
                else if (target < arr[mid])
                    start = mid + 1;
            }
        }
        return -1;
    }
}
