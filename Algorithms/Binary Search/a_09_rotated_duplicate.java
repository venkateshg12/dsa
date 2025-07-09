package dsa.Algorithms;
public class a_09_rotated_duplicate {
    public static void main(String[] args) {
        int []arr = {34,33,46,93,34,34,104};
        System.out.println(pivotSearch(arr));
    }
        
    static int pivotSearch(int []arr) {
        int start = 0;
        int end = arr.length - 1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            // 4 cases over there
            if(mid < end &&  arr[mid] > arr[mid + 1]){
                return mid;
            }
            if(mid > start && arr[mid] < arr[mid - 1]){
                return mid - 1;
            }
            // If element at middle, end, start are equal just ignore the duplicates.
            if(arr[mid]==arr[start] && arr[mid] == arr[end]){
                // Skip the duplicatesl
                //NOTE: What if these elements at start and end were the pivot ?
                // Check if start is pivot.
                if(arr[start] > arr[start + 1]){
                    return start;
                }
                start++;
                // Checker whether end is pivot
                if(arr[end] < arr[end - 1]) {
                    return end - 1;
                }
                end--;
            }
            // Left side is sorted so pivot should be in right.
            else if (arr[start] < arr[mid] || (arr[start]== arr[mid]) && arr[mid] > arr[end]){
                start = mid + 1;
            }else {
                end = mid = 1;
            }
        }
        return -1;
    }
}
