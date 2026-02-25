package dsa.Kunal_Kushwaha_DSA.Patterns;
/*    

* * * * *
* * * *
* * *
* *
*

 */
import java.util.Scanner;

public class a_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int n = scan.nextInt();
        for(int row = n; row > 0;row--) {
            for(int col = 0;col < row;col++){
                System.out.printf("* ");
            }
            System.out.println();
        }
    }
}