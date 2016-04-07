public class Solution {
    /**
     * Similar to permutationI with recursive method. When swap each element in the lists with the "begin" element,
     * swap once for the same value.
     * */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0) return result;
        Arrays.sort(nums);
        recursivePermute(nums, 0, result);
        return result;
    }
    private void recursivePermute(int[] nums, int begin, List<List<Integer>> result){
        int len = nums.length;
        if(begin == len - 1){
            List<Integer> list = new ArrayList<Integer>();
            for(int n : nums){
                list.add(n);
            }
            result.add(list);
            return;
        }
        Arrays.sort(nums, begin, len);
        int swapped = nums[begin]-1;
        for(int i = begin; i<len; i++){
            if(nums[i] == swapped) continue;
            else{
                swap(nums, begin, i);
                //swapped = nums[begin];
                recursivePermute(nums, begin+1, result);
                swap(nums, begin, i);
            }
        }
    }
    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}