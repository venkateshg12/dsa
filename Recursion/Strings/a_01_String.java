// package Strings;

// Remove the 'a' character in the respective string
public class a_01_String {
    public static void main(String[] args) {
        String str = "baccadhaaetreyjghsaagsrtjdaa";
        System.out.println(stringRemoval(str, ""));
    }

    public static String stringRemoval(String up, String p) {
        if(up.isEmpty()){
            return p;
        }
        return up.charAt(0) == 'a' ? stringRemoval(up.substring(1), p) : stringRemoval(up.substring(1), p + up.charAt(0));
    }
}
