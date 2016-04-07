public class Solution {
    /**
     * Choose two elements as candidates, read through the nums.
     * If current element is equal to either of the candidates, corresponding count plus 1;
     * If current element is equal to neither of the candidates, decrement both counts;
     * If ever a count is 0, puts replace the candidate with current one.
     * */
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        if(nums == null || nums.length == 0) return result;
        int len = nums.length;
        //First choose 2 different nums as tentative candidates
        int candidate1 = 0, count1 = 0;
        int candidate2 = 0, count2 = 0;
        for(int i = 0; i<len; i++){
            if(nums[i] == candidate1) count1++;
            else if(nums[i] == candidate2) count2++;
            else if(count1 == 0){
                candidate1 = nums[i];
                count1++;
            }
            else if(count2 == 0){
                candidate2 = nums[i];
                count2++;
            }
            else{
                count1--;
                count2--;
            }
        }
        count1 = 0; 
        count2 = 0;
        for(int n : nums){
            if(n == candidate1) count1++;
        }
        if(candidate1!=candidate2){
            for(int n : nums){
                if(n == candidate2) count2++;
            }
        }
        if(count1>len/3) result.add(candidate1);
        if(count2>len/3) result.add(candidate2);
        return result;
    }
}