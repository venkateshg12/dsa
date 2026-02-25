// package dsa.Recursion;

public class a_06_Reverse {
    public static void main(String[] args) {
        int n = 123456;
        System.out.println(recursiveReverse(n));
    }

    public static int recursiveReverse(int n) {
        int digit = (int) Math.log10(n) + 1;
        return helper(n, digit);
    }

    public static int helper(int n, int digit) {
        if (n % 10 == n) {
            return n;
        }
        return (n % 10) * (int) (Math.pow(10, digit - 1)) + helper(n / 10, digit - 1);
    }
}
