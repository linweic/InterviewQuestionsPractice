public class Solution {
    /**
     * Binary search, same as non-duplication.
     * Except for that if nums[mid]==nums[hi] and mid != hi, decrement hi.
     * */
    public boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return false;
        int len = nums.length;
        int lo = 0;
        int hi = len - 1;
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            if(nums[mid] == target) return true;
            if(nums[mid] < nums[hi]){
                //second half is sorted
                if(nums[mid]< target && target <= nums[hi]) lo = mid +1;
                else hi = mid - 1;
            }
            else if(nums[mid] > nums[hi]){
                //fisrt half is sorted
                if(nums[lo] <= target && target < nums[mid]) hi = mid - 1;
                else lo = mid + 1;
            }
            else{
                if(mid != hi){
                    //duplicates
                    hi--;
                }
                else return false;
            }
        }
        return false;
    }

}