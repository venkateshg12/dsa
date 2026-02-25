// package dsa.Recursion;

import java.util.ArrayList;

public class a_10_Linear_Sorted {

    public static void main(String[] args) {
        int[] arr = { 23, 4, 5, 1, 4, 55,4 };
        // Arrays.sort(arr);
        int target = 4;
        if (Find(arr, target, 0)) {
            System.out.println("target is found");
        } else {
            System.out.println("target is not found");
        }
        ArrayList<Integer> list = new ArrayList<>();

        ArrayList<Integer> ans = findAllIndex(arr, target, 0, new ArrayList<>());
        System.out.println(ans);
    }

    static boolean Find(int[] arr, int target, int i) {
        if (i == arr.length - 1) {
            return false; // When Array is not sorted.
        }
        if (target == arr[i]) {
            return true;
        }
        // if(target>arr[i]){
        // return Find(arr,target,i+1);
        // }
        return false;
    }

    static int findIndex(int[] arr, int target, int i) {
        if (i == arr.length) {
            return -1;
        }
        if (arr[i] == target) {
            return i;
        }
        return findIndex(arr, target, i + 1);
    }

    static ArrayList<Integer> findAllIndex(int[] arr, int target, int i, ArrayList<Integer> list) {
        if (i == arr.length) {
            return list;
        }
        if (arr[i] == target) {
            list.add(i);
        }
        return findAllIndex(arr, target, i + 1, list);
    }
}