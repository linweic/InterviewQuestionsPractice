public class Solution {
    /**
     * Use binary search to find the position.
     * */
    public int searchInsert(int[] nums, int target) {
        
        if(nums == null || nums.length == 0) return 0;
        int low = 0, high = nums.length-1;
        while(low <= high){
            int mid = low + (high-low)/2;
            int cmp = target - nums[mid];
            if(cmp == 0) return mid;
            if(cmp < 0) high = mid - 1;
            if(cmp > 0) low = mid + 1;
        }
        return low;
        
        /*
        int pos = Arrays.binarySearch(nums, target);
        if(pos >= 0) return pos;
        else return (-1)*pos - 1;
        */
    }
}