public class Solution {
/**
 * Either first or last could be robbed. Thus do 2 passes of DP
 * First pass from house0 to house n-2; second pass from house1 to house n-1
 * O(n) time, O(1) space
 * */
public int rob(int[] nums) {
    if(nums == null || nums.length == 0) return 0;
    int size = nums.length;
    if(size == 1) return nums[0];
    if(size == 2) return Math.max(nums[0], nums[1]);
    return Math.max(robHelper(nums, 0, size-2), robHelper(nums, 1, size-1));
}
private int robHelper(int[] nums, int start, int end){
    int minusTwo = nums[start]; 
    int minusOne = Math.max(nums[start],nums[start+1]);
    for(int i = start+2;i<=end;i++){
        int current;
        if(minusTwo+nums[i]>minusOne){
            current = minusTwo+nums[i];
        }
        else current = minusOne;
        minusTwo = minusOne;
        minusOne = current;
    }
    return minusOne;
}
}