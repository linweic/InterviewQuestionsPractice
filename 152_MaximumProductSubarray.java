public class Solution {
    public int maxProduct(int[] nums) {
        /**
         * use maxPos to store max product that is positive so far, initial val = 1
         * use maxNeg to store max product that is negitive so far, initial val = 1
         * iterate through all inputs.
         * if current number is positive, 
         *      then update maxPos.
         *      if maxNeg is not 1, then update maxNeg,
         *      otherwise stays. Because negtive numbers are balanced out in this case.
         *      update total max
         * if current number is negative,
         *      if maxNeg is smaller than 0, then update maxPos as maxNeg*current, maxNeg gets back to 1
         *      else meaning this is the first time neg num appears since last balance out
         *          then maxNeg = maxPos*current, maxPos gets back to 1
         *      update total max
         * if current number is 0,
         *      maxNeg and maxPos get back to 1
         * */
        if(nums==null || nums.length == 0) return 0;
        int max = nums[0];
        int maxPos=1, maxNeg=1;
        for(int i = 0;i<nums.length;i++){
            if(nums[i]>0){
                maxPos*=nums[i];
                maxNeg = (maxNeg != 1)? maxNeg*nums[i] : 1;
                max = (maxPos>max)? maxPos:max;
            }
            else if(nums[i]<0){
                int temp = maxNeg;
                maxNeg = maxPos * nums[i];//note to myself: always update!
                maxPos = (temp < 0) ? temp * nums[i] : 1; //negative number is balanced out
                max = (temp<0) ? (maxPos > max ? maxPos : max) : max;
            }
            else{
                maxPos = 1;
                maxNeg = 1;
                max = (max<0)?0:max;
            }
        }
        return max;
    }
}