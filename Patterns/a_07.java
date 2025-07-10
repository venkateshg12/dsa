package dsa.Kunal_Kushwaha_DSA.Patterns;
import java.util.Scanner;
/*   
  4 4 4 4 4 4 4
  4 3 3 3 3 3 4
  4 3 2 2 2 3 4
  4 3 2 1 2 3 4 
  4 3 2 2 2 3 4 
  4 3 3 3 3 3 4
  4 4 4 4 4 4 4

 */

public class a_07 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int n = scan.nextInt();
        int originalN = n+1;
        n  = 2 * n;
        for(int rows = 0; rows <= n;rows++){
            for(int cols = 0;cols <= n;cols++) {
                int atEveryIndex = originalN - Math.min(Math.min(rows,cols), Math.min(n-rows, n-cols));
                System.out.print(atEveryIndex+" ");
            }
            System.out.println();
        }
    }
    
}
