// package Strings;
// program to store all the subsets in the ArrayList.
import java.util.*;

public class a_03_02_String {
    public static void main(String[] args) {
        String str = "abc";
        String p = "";
        ArrayList<String> list = subset(str, p);
        System.out.println(list);
    }

    public static ArrayList<String> subset(String str, String p) {
        if(str.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            if(p.isEmpty()) {
                return list;
            }
            list.add(p);
            return list;
        }
        char ch = str.charAt(0);
        ArrayList<String> left = subset(str.substring(1), p + ch);
        ArrayList<String> right = subset(str.substring(1), p);
        left.addAll(right);
        return left;
    }
}
