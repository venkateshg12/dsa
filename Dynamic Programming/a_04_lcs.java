public class a_04_lcs {
    public static void main(String[] args) {
        String s = "abcde";
        String t = "ace";
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j <= t.length(); j++) {
                dp[i][j] = -1;
            }
        }
        for (int i = 0; i <= s.length(); i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= t.length(); j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        int i = s.length();
        int j = t.length();
        int ind = dp[i][j] - 1;
        // StringBuilder st = new StringBuilder();
        char [] st = new char[t.length()];
         while(i>0 && j > 0) {
            if(s.charAt(i - 1) == t.charAt(j - 1)){
                // st.append(s.charAt(i - 1));
                st[ind--] = s.charAt(i - 1);
                i--;
                j--;
            }else if (dp[i - 1][j]  > dp[i][j - 1]) {
                i--;
            }else {
                j--;
            }
        }
        // System.out.println(st.reverse().toString());
        for(char c : st) {
            System.out.print(c);
        }
        System.out.println();
    }
}
