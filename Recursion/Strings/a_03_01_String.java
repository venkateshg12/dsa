// package Strings;

// program to write all the subsets of a particular string.


public class a_03_01_String {
    public static void main(String[] args) {
        String str = "abc";
        String p = "";
        subset(str,p);
    }
    public static void subset(String str, String p ) {
        if(str.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = str.charAt(0);
        subset(str.substring(1), p + ch);
        subset(str.substring(1), p);
    }
}