package dsa.Kunal_Kushwaha_DSA.Patterns;

import java.util.Scanner;

/* 

          *
         *  *
        *  *  *
      *  *  *  *
       *  *  *
         *  *
          *

*/
public class a_04 {
    public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      System.out.print("Enter the number: ");
      int n = scan.nextInt();
      for(int i=1;i<=2*n-1;i++) {
        int noOfColsInRow = i > n?2*n-i:i;
        int spaces = n - noOfColsInRow;
        for(int s= 1;s <= spaces;s++){
          System.out.print(" ");
        }
        for(int j = 0;j<noOfColsInRow;j++){
          System.out.print("* ");
        }
        System.out.println();
      }
    }
}
