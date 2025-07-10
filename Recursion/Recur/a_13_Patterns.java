// package dsa.Recursion;

public class a_13_Patterns {
    public static void main(String[] args) {
        int n = 5;
        reversePattern(n, 0);
        pattern(n, 0);
    }

    public static void reversePattern(int n, int c) {
        if (n == 0) {
            return;
        }

        if (c < n) {
            System.out.print("* ");
            reversePattern(n, c + 1);
        } else {
            System.out.println();
            reversePattern(n - 1, 0);
        }
    }

    public static void pattern(int n, int c) {
        if (n == 0) {
            return;
        }
        if (c < n) {
            pattern(n, c + 1);
            System.out.print("* ");
        } else {
            pattern(n - 1, 0);
            System.out.println();
        }
    }
}