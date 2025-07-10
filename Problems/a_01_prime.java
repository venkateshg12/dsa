package dsa.Kunal_Kushwaha_DSA;

import java.util.*;

// Program to find Prime number
public class a_01_prime {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number to check whether it is Prime or Not ?");
        int t = scan.nextInt();
        boolean ans = isPrime(t);
        if (ans)
            System.out.println(t + " is a Prime number");
        else
            System.out.println(t + " is not a prime number");
    }

    static boolean isPrime(int t) {
        int c = 2;
        while (c * c <= t) {
            if (t % c == 0)
                return false;
            c++;
        }
        return c * c > t;
    }
}
