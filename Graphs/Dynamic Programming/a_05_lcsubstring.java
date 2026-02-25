import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class a_05_lcsubstring {
    public static void main(String[] args) {
        int[] arr = {10, 22, 9, 33, 21, 50, 41, 60, 80};
         int n = arr.length;
        int maxi = 1;
        int[] dp = new int[n];
        int[] hash = new int[n];
        Arrays.fill(dp, 1);
        int lastIndex = 0;
        for(int i = 0;i < n;i++) {
            hash[i] = i;
            for(int prev = 0;prev < i;prev++) {
                if(arr[prev] < arr[i] && 1 + dp[prev] > dp[i]) {
                    dp[i] = 1 + dp[prev];
                    hash[i] = prev;
                }
            }
            if(dp[i] > maxi) {
                maxi = dp[i];
                lastIndex = i;
            }
        }

        List <Integer> list= new ArrayList<>();
        list.add(arr[lastIndex]);
        while(hash[lastIndex] != lastIndex) {
            lastIndex = hash[lastIndex];
            list.add(arr[lastIndex]);
        }
        // Collections.sort(list, Collections.reverseOrder());
        Collections.sort(list);
        for(int i= 0;i< list.size();i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();


        
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
         List<Integer> temp  = new ArrayList<>();
        temp.add(nums[0]);
        for(int i = 1;i < nums.length;i++) {
            if(nums[i] > temp.get(temp.size() - 1)) {
                temp.add(nums[i]);
            }else {
                int ind = Collections.binarySearch(temp, nums[i]);
                if(ind < 0) {
                    ind = -(ind + 1);
                }
                temp.set(ind, nums[i]);
            }
        }
        System.out.println(temp.size());
    }
}