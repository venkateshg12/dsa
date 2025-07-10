package dsa.Kunal_Kushwaha_DSA.Patterns;

import java.util.Scanner;

/*  

*
* *
* * *
* * * *
* * * * *
* * * *
* * *
* * 
*

 */
public class a_03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int n = scan.nextInt();
        for(int i=1;i<=(2*n-1);i++){
            int TotalNoCols = i > n? (2*n - i):i;
            for(int j=0;j<TotalNoCols;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    
}
