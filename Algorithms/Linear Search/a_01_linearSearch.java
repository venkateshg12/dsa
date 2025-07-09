package dsa.Algorithms;

import java.util.Scanner;

// Linear Search

public class a_01_linearSearch {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int [] arr = {3,44,22,66,88,4,33,2};
        System.out.println("Enter the number you want to search ?");
        int target = scan.nextInt();
        boolean ans = linearSearch(arr, target);
        if(ans) System.out.println("Element is found");
        else  System.out.println("Element is not found");
    }
    static boolean linearSearch(int []arr,int target) {
        if(arr.length == 0) return false;
        for(int e : arr) {
            if(e == target) return true;
        }
        return false;
    }
}
