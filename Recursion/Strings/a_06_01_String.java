
// Program to find all the permutations in particular string.
public class a_06_01_String {
    public static void main(String[] args) {
        String s = "abc";
        String p = "";
        permutations(s, p);
    }
    public static void permutations(String str, String up) {
        if (str.isEmpty()) {
            System.out.println(up);
            return;
        }
        char ch = str.charAt(0);
        for(int i = 0;i <= up.length();i++){
            String f = up.substring(0,i);
            String s = up.substring( i, up.length());
            permutations(str.substring(1), f+ch+s);
        }
    }
} 