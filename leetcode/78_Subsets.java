public class Solution {
    /**
     * If we already know the subsets of first i numbers in nums,
     * then the subsets of first i+1 numbers are the copy of existing subsets appended by nums[i+1] and the existing subsets
     * */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        lists.add(new ArrayList<Integer>());//add empty set
        Arrays.sort(nums);
        for(int i = 0; i< nums.length; i++){
            int num = nums[i];
            List<List<Integer>> newLists = new ArrayList<List<Integer>>();
            for(List<Integer> list : lists){
                List<Integer> newList = new ArrayList<Integer>(list);
                newList.add(num);
                newLists.add(newList);
            }
            lists.addAll(newLists);
        }
        return lists;
    }
}