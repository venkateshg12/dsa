import java.util.*;

public class a_08_String {
    public static void main(String[] args) {
        List<String> list = dice("", 3);
        System.out.println(list);
    }

    public static List<String> dice(String p, int target) {
        if (target == 0) {
            List<String> list = new ArrayList<>();
            // System.out.println(p);
            list.add(p);
            return list;
        }
        List<String> list  = new ArrayList<>();
        for (int i = 1; i <= target; i++) {
            // if(i == 1 || i == 2 || i == 3)
                list.addAll(dice(p + i, target - i));
        }
        return list;
    }
}