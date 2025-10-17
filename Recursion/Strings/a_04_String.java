    // package Strings;

import java.util.*;

// program to find all the subsets of the all numbers in the array.
public class a_04_String {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        List<List<Integer>> list = subset(arr);
        System.out.println(list);
    }

    public static List<List<Integer>> subset(int[] arr) {
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        for(int num : arr) {
            int n = outer.size();
            // System.out.println(n);
            for(int i  = 0;i < n;i++) {
                List<Integer> internal = new ArrayList<>(outer.get(i)); 
                // System.out.println(Arrays.toString(internal.toArray()));
                internal.add(num);
                outer.add(internal);
            }
        }
        System.out.println(outer.size());
        return outer;
    }
}