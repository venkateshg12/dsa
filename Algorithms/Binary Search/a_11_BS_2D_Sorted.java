// package dsa.Kunal_Kushwaha_DSA;

// Binary Search in Sorted 2D Array
import java.util.*;

public class a_11_BS_2D_Sorted {
    public static void main(String[] args) {
        int[][] arr = {
                {1,1},{2,2},
        };
        System.out.println(Arrays.toString(search(arr, 3)));
    }

    static int[] binarySearch(int[][] arr, int row, int cStart, int cEnd, int target) {
        while (cStart <= cEnd) {
            int mid = cStart + (cEnd - cStart) / 2;
            if (arr[row][mid] == target) {
                return new int[] { row, mid };
            } else if (arr[row][mid] < target) {
                cStart = mid + 1;
            } else {
                cEnd = mid - 1;
            }
        }
        return new int[] { -1, -1 };
    }

    static int[] search(int[][] arr, int target) {
        int rows = arr.length;
        int cols = arr[0].length;
        if (rows == 1) {
            return binarySearch(arr, 0, 0, cols - 1, target);
        }

        if (cols == 0) {
            return new int[] { -1, -1 };
        }

        int rStart = 0;
        int rEnd = rows - 1;
        int cMid = cols / 2;

        while (rStart < (rEnd - 1)) {
            int mid = rStart + (rEnd - rStart) / 2;
            if (arr[mid][cMid] == target) {
                return new int[] { mid, cMid };
            }
            if (arr[mid][cMid] < target) {
                rStart = mid;
            } else {
                rEnd = mid;
            }
        }

        if (arr[rStart][cMid] == target) {
            return new int[] { rStart, cMid };
        }

        if (arr[rStart + 1][cMid] == target) {
            return new int[] { rStart + 1, cMid };
        }

        // first Half
        if (target <= arr[rStart][cMid - 1]) {
            return binarySearch(arr, rStart, 0, cMid - 1, target);
        }

        if (target >= arr[rStart][cMid] && target <= arr[rStart][cols - 1]) {
            return binarySearch(arr, rStart, cMid + 1, cols - 1, target);
        }

        if (target <= arr[rStart + 1][cMid - 1]) {
            return binarySearch(arr, rStart + 1, 0, cMid - 1, target);
        } else {
            return binarySearch(arr, rStart + 1, cMid + 1, cols - 1, target);
        }
    }
}