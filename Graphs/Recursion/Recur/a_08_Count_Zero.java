// package dsa.Recursion;

public class a_08_Count_Zero {
    public static void main(String[] args) {
        int n = 302040000;
        int count = 0;
        System.out.println(recursiveCount(n, count));
    }

    public static int recursiveCount(int n, int count) {
        if (n == 0) {
            return count;
        }
        return n % 10 == 0 ? recursiveCount(n / 10, count + 1) : recursiveCount(n / 10, count);
    }
}
