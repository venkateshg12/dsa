import java.io.*;

public class a {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine().trim());
            String[] val = read.readLine().split(" ");
            int[] arr = new int[n];
            boolean flag = true;
            int p = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(val[i]);
                if (arr[i] != 0 && flag) {
                    p = i;
                    flag = false;
                }
            }
            if (n == 2) {
                out.println(arr[0]);
            } else {
                int m = p;
                for (int i = p; i < n - 2; i++) {
                    if (i + 1 == 0) {
                        while(arr[m] == 0) {
                            m++;
                        }
                        if (arr[m] > 0) {
                            arr[i + 1]++;
                            arr[m]--;
                        }
                    }
                }
                int count = 0;
                for (int i = n - 2; i >= 0; i--) {
                    count += arr[i];
                }
                out.println(count);
            }
        }
        out.flush();
        out.close();
        read.close();
    }
}