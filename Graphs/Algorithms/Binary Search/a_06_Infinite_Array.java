package dsa.Algorithms;
// Find the position of the element in a sorted infinite array.
public class a_06_Infinite_Array {
    public static void main(String[] args) {
        int[] arr = {1,5,7,9,10,12,14,17,19,20,23,25,29,30,34,37,39,45,49,52,61,70,75,78,81,83,87,89,90,91,92,95,96,98,100};
        int target = 10;
        System.out.println(findRange(arr,target));
    }
    static int findRange(int[] nums,int target){
        int start = 0;
        int end = 1;
        while(target > nums[end]){
            int newStart = end + 1;
            end = end + (end - start + 1) * 2;
            start = newStart;
        }
        return binarySearch(nums,start,end,target);
    }
    static int binarySearch(int[] nums, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start)/2;
            if(target > nums[mid]){
                start = mid + 1;
            } else if (target < nums[mid]){
                end = mid - 1;
            }else {
                return mid;
            }
        }
        return -1;
    }
}
