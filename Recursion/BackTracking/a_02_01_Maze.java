// package Recursion.BackTracking; 

// all the ways from (0,0) -----> respective path. only left and right.

import java.util.ArrayList;

public class a_02_01_Maze {
    public static void main(String[] args) {
        System.out.println(mazePath("", 3, 3));
    }

    public static ArrayList<String> mazePath(String p, int r, int c) {

        if (r == 1 && c == 1) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> total = new ArrayList<>();
        if (r > 1) {
            total.addAll(mazePath(p + "D", r - 1, c));
        }
        if (c > 1) {
            total.addAll(mazePath(p + "R", r, c - 1));
        }
        return total;
    }
}