import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class a {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine().trim());
            String[] val = read.readLine().split(" ");
            int[] arr = new int[n];
            Map<Integer, Integer> list = new HashMap<>();
            for(int i = 0;i < n;i++) {
                arr[i] = Integer.parseInt(val[i]);
                list.put(arr[i], list.getOrDefault(arr[i], 0) + 1);
            }
            boolean flag = true;
            for(int key : list.keySet()) {
                if(list.get(key) > n / 2){
                    flag = false;
                    break;
                }
            }
            out.println(flag ? "YES" : "NO");
        }
        out.flush();
        out.close();
        read.close();
    }}