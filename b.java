import java.io.*;
import java.util.*;

public class b {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new  InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine().trim());
        while(t --> 0) {
            String[] val = read.readLine().split(" ");
            int n = Integer.parseInt(val[0]);
            int k = Integer.parseInt(val[1]);
            String s = read.readLine().trim();
            Map<Character, Integer> list = new HashMap<>();
            for(int i = 0;i < n;i++) {
                list.put(s.charAt(i), list.getOrDefault(s.charAt(i), 0) + 1);
            }

        }

    }
}
