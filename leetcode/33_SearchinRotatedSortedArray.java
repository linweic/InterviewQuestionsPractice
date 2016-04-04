public class Solution {
    /**
     * First use binary search to find the smallest element.
     * If mid < hi, then the smallest element must be mid or before mid;
     * If mid > hi, then the smallest element must after mid.
     * If mid = hi, then it is the smallest element.
     * After finding out the index of smallest element, determine whether target is in [0, smallest] or [smallest, len].
     * Do binary search to find corresponding index.
     * */
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return 0;
        int len = nums.length;
        if(target == nums[0]) return 0;
        if(target == nums[len-1]) return len-1;
        //find the smallest element using binary search
        int lo = 0;
        int high = len - 1;
        int small = -1;//the index of smallest element
        while(lo <= high){
            int mid = lo+(high - lo)/2;
            if(nums[mid] == nums[high]){
                small = mid;
                break;
            };
            if(nums[mid] > nums[high]) lo = mid+1;
            if(nums[mid] < nums[high]) high = mid;
        }
        if(target < nums[len-1]) return ascendBS(nums, small, len-1, target);
        else return ascendBS(nums, 0, small-1, target);
    }
    private int ascendBS(int[] nums, int start, int end, int target){
        int lo = start;
        int hi = end;
        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            int cmp = target - nums[mid];
            if(cmp == 0) return mid;
            if(cmp > 0) lo = mid+1;
            if(cmp < 0) hi = mid-1;
        }
        return -1;
    }
    /**
    *   second solution
    */
    public int searchII(int[] nums, int target){
        if(nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int lo = 0;
        int hi = len-1;
        while(lo<=hi){
            int mid = lo + (hi - lo)/2;
            if(target == nums[mid]) return mid;
            if(nums[mid] > nums[hi]){
                //first half is sorted
                if(nums[lo]<=target && target<nums[mid]) hi = mid - 1;
                else lo = mid+1;
            }
            else if(nums[mid]<nums[hi]){
                //second half is sorted
                if(nums[mid]<target && target<=nums[hi]) lo = mid+1;
                else hi = mid-1;
            }
            else{
                return -1;
            }
        }
        return -1;
    }
}