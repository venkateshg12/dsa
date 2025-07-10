import java.io.*;

public class a {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine().trim());
        while (t-- > 0) {
            String s = read.readLine().trim();
            int n = s.length();
            StringBuilder a = new StringBuilder();
            StringBuilder b = new StringBuilder();
            a.append('(');
            while (a.length() < 2 * n) {
                if (a.charAt(a.length() - 1) == '(') {
                    a.append(')');
                } else {
                    a.append('(');
                }
            }
            // out.println(a.toString());
            while (b.length() < n) {
                b.append('(');
            }
            while (b.length() < 2 * n) {
                b.append(')');
            }
            // out.println(b.toString());
            if (!a.toString().contains(s)) {
                out.println("YES");
                out.println(a);
            } else if (!b.toString().contains(s)) {
                out.println("YES");
                out.println(b);
            } else {
                out.println("NO");
            }
        }
        out.flush();
        out.close();
        read.close();
    }
}