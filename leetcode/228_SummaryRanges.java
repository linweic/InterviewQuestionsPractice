public class Solution {
    public List<String> summaryRanges(int[] nums) {
        //two pointers
        if(nums == null || nums.length == 0) return new ArrayList<String>();
        List<String> range = new ArrayList<String>();
        int len = nums.length;
        if(len == 1){
            range.add(String.valueOf(nums[0]));
            return range;
        }
        int start = 0;
        int end = 1;
        for(;end < len; end++){
            //IMPORTANT: cast to long to avoid integer overflow
            if(((long)nums[end] - (long)nums[start]) > (end - start) ){
                if(start == end - 1){
                    range.add(String.valueOf(nums[start]));
                }
                else{
                    StringBuilder sb = new StringBuilder(String.valueOf(nums[start]));
                    sb.append("->").append(nums[end-1]);
                    range.add(sb.toString());
                }
                start = end;
                //end++;
            }
        }
        if(start == len - 1){
            range.add(String.valueOf(nums[start]));
        }
        else{
            StringBuilder sb = new StringBuilder(String.valueOf(nums[start]));
            sb.append("->").append(nums[end-1]);
            range.add(sb.toString());
        }
        return range;
    }
}