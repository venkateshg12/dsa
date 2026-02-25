package dsa.Kunal_Kushwaha_DSA.Patterns;
/*
   0 0 0 0 0 0 0 0 0
   0 1 1 1 1 1 1 1 0
   0 1 2 2 2 2 2 1 0
   0 1 2 3 3 3 2 1 0
   0 1 2 3 4 3 2 1 0
   0 1 2 3 3 3 2 1 0
   0 1 2 2 2 2 2 1 0
   0 1 1 1 1 1 1 1 0
   0 0 0 0 0 0 0 0 0

 */
import java.util.*;

public class a_08 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int n = scan.nextInt();
        n  = 2 * n;
        for(int rows = 0; rows <= n;rows++){
            for(int cols = 0;cols <= n;cols++) {
                int atEveryIndex = Math.min(Math.min(rows,cols), Math.min(n-rows, n-cols));
                System.out.print(atEveryIndex+" ");
            }
            System.out.println();
        }
    }
    
}
