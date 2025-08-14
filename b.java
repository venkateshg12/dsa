import java.io.*;
import java.util.*;

public class b {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine().trim());
        while (t-- > 0) {
            String s = read.readLine().trim();
            char[] arr = s.toCharArray();
            int count = 0;
            int n = 1;
            for (int i = 0; i < 4; i++) {
                if (i == 0) {
                    if (Integer.parseInt(String.valueOf(arr[i])) == 1) {
                        count++;
                    } else {
                        int num = (arr[i] == '0' ? 10 : Integer.parseInt(String.valueOf(arr[i])));
                        count += num;
                        n = (num == 10 ? 0 : num);
                    }
                } else {
                    if (Integer.parseInt(String.valueOf(arr[i])) == n) {
                        count++;
                    } else {
                        int num = (arr[i] == '0' ? 10 : Integer.parseInt(String.valueOf(arr[i])));
                        int p = (n == 0 ? 10 : n);
                        // out.println(Math.abs(num - p + 1) + " "+"i: " +i +"num: " +num+ "p: " +p);
                        int tot = Math.abs(num - p) + 1;
                        count += tot;
                        n = (num == 10 ? 0 : num);
                    }
                }

            }
            out.println(count);
        }
        out.close();
        out.flush();
        read.close();
    }
}
