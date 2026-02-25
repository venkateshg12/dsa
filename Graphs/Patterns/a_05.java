package dsa.Kunal_Kushwaha_DSA.Patterns;
/* 

            1
          2 1 2
        3 2 1 2 3 
      4 3 2 1 2 3 4
    5 4 3 2 1 2 3 4 5

 */
import java.util.Scanner;

public class a_05 {
    public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      System.out.print("Enter the number: ");
      int n = scan.nextInt();
      for(int i = 1;i<=n;i++){
        int noOfColsInRow = 2*i-1;
        int noOfSpaces = n - i;

        for(int s = 1;s <=noOfSpaces;s++) {
            System.out.print("  ");
        }

        for(int col=i;col>=1;col--){
            System.out.print(col+" ");
        }
        for(int col=2;col<=i;col++){
            System.out.print(col+" ");
        }
        System.out.println();
      }
    }
    
}
