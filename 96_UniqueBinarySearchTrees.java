public class Solution {
    /**
     * for every i in n being the root,
     *      i-1 nodes should be on node i's left, n-i nodes should be on i's right
     *      thus total number with root i is dp[i-1]*dp[n-i]
     * add up all the combinations with root i
     * */
    public int numTrees(int n) {
        if (n == 0) return 0;
        int[] trees = new int[n+1];
        trees[0] = 1;
        for(int i = 1;i<=n;i++){
            //calculate the number of trees with i nodes
            //for the i nodes, iterate through 1 to i to calculate num of trees at root j, and sum all the combinations up
            int sum = 0;
            for(int j = 1; j<=i;j++){
                sum += trees[j-1]*trees[i-j];
            }
            trees[i] = sum;
        }
        return trees[n];
    }
}