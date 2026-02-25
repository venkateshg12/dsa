public class a_05_Sum_Digits {
    public static void main(String[] args) {
        int n = 1234;
        System.out.println(recursiveSumOfDigits(n));
    }
    public static int recursiveSumOfDigits(int n) {
        return n == 0 ? 0 : (n % 10) +  recursiveSumOfDigits(n/10);
    }
}