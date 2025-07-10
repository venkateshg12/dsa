// package Recursion.BackTracking;
/*
    Number of ways from (0,0) --> respective path. only left and right.
 */
public class a_01_Maze {
    public static void main(String[] args) {
        maze(3, 3, " ");
    }

    public static void maze(int r, int c, String p) {

        if (r == 1 || c == 1) {
            return 1;
        }
        int left = maze(r - 1, c);
        int right = maze(r, c - 1);
        return left + right;
    }
}
