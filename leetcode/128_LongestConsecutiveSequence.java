public class Solution {
    /**
     * No duplicates
     * 1,sort
     * 2, use two pointers to find start/end point of each consecutive sequence
     * 3, maintain a longest length variable
     * */
    
    public int longestConsecutive(int[] nums) {
        //corner case
        if(nums == null || nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);
        int start = 0, end = 1;
        int longest = 0;
        while(end<nums.length){
            if(nums[end]- nums[end-1] == 1) end++;
            else{
                longest = Math.max(longest, end-start);
                start = end;
                end++;
            }
        }
        longest = Math.max(longest, end-start);
        return longest;
    }
    
    /**
     * Duplicates
     * DP: 
     * 1, sort
     * 2, dp[i] denotes the longest consecutive seq ending at nums[i]
     * 3, make dp[0] as 1
     * 4, if nums[i+1] = nums[i]+1, then dp[i+1] = dp[i]
     * 5, find out the max number in dp
     * */
     public int longestConsecutive(int[] nums){
         //corner case
         if(nums == null || nums.length == 0) return 0;
         Arrays.sort(nums);
         int len = nums.length;
         int dp[] = new int[len];
         dp[0] = 1;
         for(int i = 1; i<len; i++){
             if(nums[i] == nums[i-1]){
                 dp[i] = dp[i-1];
             }
             else if(nums[i] == nums[i-1]+1){
                 dp[i] = dp[i-1]+1;
             }
             else dp[i] = 1;
         }
         //find out the max number in dp
         int max = 0;
         for(int n : dp){
             if(n > max) max = n;
         }
         return max;
     }
}