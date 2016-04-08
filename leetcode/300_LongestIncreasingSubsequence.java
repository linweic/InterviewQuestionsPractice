public class Solution {
    /**
     * Use an array to store the end number of all the increasing sequence
     * */
    public int lengthOfLIS(int[] nums) {
        //corner case
        if(nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int countSequence = 0;
        int end[] = new int[len];
        for(int i = 0; i<len; i++){
            if(countSequence == 0) {
                end[0] = nums[i];
                countSequence++;
            }
            else{
                if(nums[i] > end[countSequence-1]){
                    end[countSequence] = nums[i];
                    countSequence++;
                }
                else if(nums[i] < end[0]){
                    end[0] = nums[i];
                }
                else{
                    int position = Arrays.binarySearch(end, 0, countSequence, nums[i]);
                    if(position<0){
                        int realPosition = (-1)*position - 1;
                        end[realPosition] = nums[i];
                    }
                }
            }
        }
        return countSequence;
    }
}