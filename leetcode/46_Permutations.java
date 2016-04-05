public class Solution {
    /**
     * Solutoin 1, use dfs to iterate through all possible orders, starting from all the elements as input
     * Maintain a visted array to keep track of the elements that are visited in each dfs path
     * */
    List<List<Integer>> permutation;
    public List<List<Integer>> permute(int[] nums) {
        permutation = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0) return permutation;
        int len = nums.length;
        for(int i = 0; i<len; i++){
            boolean visited[] = new boolean[len];
            List<Integer> list = new ArrayList<Integer>(len);
            dfs(i, nums, visited, list);
        }
        return permutation;
    }
    private void dfs(int curposition, int[] nums, boolean[] visited, List<Integer> list){
        visited[curposition] = true;
        list.add(nums[curposition]);
        int len = nums.length;
        boolean allvisited = true;
        for(int i = 0; i<len; i++){
            if(visited[i] == true) continue;
            else{
                allvisited = false;
                List<Integer> clone = new ArrayList<Integer>(list);
                //Collections.copy(list, clone);
                dfs(i, nums, visited, clone);
            }
        }
        if(allvisited == true){
            permutation.add(list);
        }
        //IMPORTANT: reset visited[cur] as false before each dfs returns
        visited[curposition] = false;
    }
}