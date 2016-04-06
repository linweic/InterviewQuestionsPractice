public class Solution{
    /**
     * Find out the smallest i such that nums[i] to nums[n-1] is in reverse order, where n is the length of nums.
     * Therefore nums[i...n-1] is lexicographically largest. This segment cannot be increased any more.
     * The next permutation that is larger than current one should be retained by swapping nums[i-1] with one element within
     * nums[i...n-1] that has the smallest value that larger than nums[i-1].
     * Then make the higher positions a small as possible. In other word, sort them.
     * If i-1 < 0, then the entire permutation is largest. Therefore the lowest possible sort is the reverse of current permutation.
     * */
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int len = nums.length;
        //find out the longest reverse segment
        int reversePoint = getReversePoint(nums);
        if(reversePoint == 0){
            //the permutation is already biggest, return the lowest order
            reverse(nums);
            return;
        }
        //find out the position in the segment to swap with nums[reversePoint-1]
        int dest = find(nums, reversePoint);
        swap(nums, reversePoint-1, dest);
        //IMPORTANT to sort after reversePoint!!
        Arrays.sort(nums, reversePoint, len);
    }
    private int getReversePoint(int[] nums){
        int len = nums.length;
        for(int i = len-1; i>0; i--){
            if(nums[i-1]<nums[i]) return i;
        }
        return 0;
    }
    private void reverse(int[] nums){
        int i = 0;
        int len = nums.length;
        while(i<len/2){
            swap(nums, i, len-1-i);
            i++;
        }
    }
    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    private int find(int[] nums, int reversePoint){
        for(int i = nums.length - 1; i>=reversePoint; i--){
            if(nums[i]>nums[reversePoint-1]) return i;
        }
        return reversePoint;
    }
}