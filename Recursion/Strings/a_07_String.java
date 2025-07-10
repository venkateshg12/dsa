// Leetcode 17:
/*  
                  1        2      3
                 abc      def    ghi
                 012      345    678

                  4       5      6    
                 jkl     mno    pqr
                91011  121314 151617

                  7       8      9 
                 stu     vwx     yz
                181920 212223   2425

    give all the permutations in according to the digits.

 */

// import java.lang.reflect.Array;
import java.util.ArrayList;

public class a_07_String {
    public static void main(String[] args) {
        ArrayList<String> list = cellPhone("", "12");
        System.out.println(list);
    }

    public static ArrayList<String> cellPhone(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> news = new ArrayList<>();
        int digit = up.charAt(0) - '0';
        for (int i = (digit - 1) * 3; i < digit * 3; i++) {
            char ch = (char)('a' + i);
            news.addAll(cellPhone(p + ch, up.substring(1)));
        }
        return news;
    }
}