// package Strings;

// Program to find all the subsets in the duplicates of numbers in the array.

import java.util.*;

public class a_05_String {
    public static void main(String[] args) {
        int[] arr = { 1, 1, 3 };
        List<List<Integer>> list = subset(arr);
        System.out.println(list);
    }

    public static List<List<Integer>> subset(int[] arr) {
        Arrays.sort(arr);
        int start = 0;
        int end = 0;
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());

        for (int i = 0; i < arr.length; i++) {
            start = 0;
            if (i > 0 && arr[i] == arr[i - 1]) {
                start = end + 1;
            }
            int n = outer.size();
            end = outer.size() - 1;
            for (int j = start; j < n; j++) {
                List<Integer> list = new ArrayList<>(outer.get(j));
                list.add(arr[i]);
                outer.add(list);
            }
        }
        return outer;
    }
}