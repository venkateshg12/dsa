// package Recursion.BackTracking;
/*
    Number of ways from (0,0) --> respective path. only left and right.
 */
public class a_01_Maze {
    public static void main(String[] args) {
        int p = maze(3, 3);
        System.out.println(p);
    }

    public static int maze(int r, int c) {

        if (r == 1 || c == 1) {
            return 1;
        }
        int left = maze(r - 1, c);
        int right = maze(r, c - 1);
        return left + right;
    }
}
