// package Strings;
// remove the app from the string which is not the part of the apple.
public class a_02_String {
    public static void main(String[] args) {
        String str = "bccapplegskdappeiwappapple";
        String p = "";
        System.out.println(skipAppNotApple(str, p));
    }
    public static String skipAppNotApple(String str, String p) {
        if(str.isEmpty()){
            return p;
        }
        return str.startsWith("app") && !str.startsWith("apple") ? skipAppNotApple(str.substring(3), p) : skipAppNotApple(str.substring(1), p + str.charAt(0));
    }
}