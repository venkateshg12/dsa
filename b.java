import java.io.*;
import java.util.*;

public class b {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine().trim());
            String[] val1  = read.readLine().split(" ");
            String[] val2  = read.readLine().split(" ");
            int[] arra = new int[n];
            int[] arrb = new int[n];
            for(int i = 0;i < n;i++) {
                arra[i]  = Integer.parseInt(val1[i]);
                arrb[i]  = Integer.parseInt(val2[i]);
            }
            int s = 0;
            for(int i = 0;i < n;i++) {
                s += Math.max(0, arra[i] - arrb[i]);
            }
            out.println(s + 1);
        }
        out.close();
        out.flush();
        read.close();
    }
}
