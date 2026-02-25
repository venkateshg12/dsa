package dsa.Kunal_Kushwaha_DSA.Patterns;
/* 
 
            1     
          2 1 2
        3 2 1 2 3 
      4 3 2 1 2 3 4
    5 4 3 2 1 2 3 4 5
      4 3 2 1 2 3 4
        3 2 1 2 3
          2 1 2
            1

 */

import java.util.Scanner;

public class a_06 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int n = scan.nextInt();
        for(int i = 1;i<=2*n-1;i++) {
            int noOfColsInRow = i > n ? 2*n-i:i;
            int noOfSpaces = n - noOfColsInRow;
            for(int s = 0;s < noOfSpaces;s++) {
                System.out.print("  ");
            }
            for(int col = noOfColsInRow;col>=1;col--){
                System.out.print(col+" ");
            }
            for(int col = 2;col <=noOfColsInRow;col++){
                System.out.print(col+" ");
            }
            System.out.println();
        }
    }
    
}
