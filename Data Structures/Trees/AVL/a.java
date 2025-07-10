
import java.io.*;

public class a {
    public static void main(String[] args) throws  IOException {
        
        BufferedReader read=  new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine().trim());
        while(t -- > 0) {
            int n = Integer.parseInt(read.readLine().trim());
            String[] val = read.readLine().split(" ");
            int[] arr = new int[n];
            for(int i = 0;i < n;i++){
                arr[i] = Integer.parseInt(val[i]);
            }
            out.println(arr[0] + Math.min(arr[0], arr[1]));
        }
        out.flush();
        out.close();
        read.close();
    }
}
