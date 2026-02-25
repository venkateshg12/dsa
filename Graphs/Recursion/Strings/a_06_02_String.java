// package Strings;

import java.util.ArrayList;

public class a_06_02_String {
    public static void main(String[] args) {
        String str = "abc";
        String p = "";
        ArrayList<String> list = permutations(str, p);
        System.out.println(list);
    }

    public static ArrayList<String> permutations(String str, String p) {
        if (str.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        
        char ch = str.charAt(0);
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            ans.addAll(permutations(str.substring(1), f + ch + s));
        }
        return ans;
    }
}