public class Solution {
    /**
     * dfs
     * */
    int max = 0;
    public int longestConsecutive(TreeNode root) {
        if(root == null) return 0;
        dfs(root, 0);
        return max;
    }
    private void dfs(TreeNode root, int path){
        path++;
        if(root.left != null){
            if(root.left.val == root.val + 1){
                dfs(root.left, path);
            }
            else{
                max = Math.max(max, path);
                dfs(root.left, 0);
            }
        }
        if(root.right != null){
            if(root.right.val == root.val +1){
                dfs(root.right, path);
            }
            else{
                max = Math.max(max, path);
                dfs(root.right, 0);
            }
        }
        if(root.left == null && root.right == null){
            max = Math.max(max, path);
        }
        path--;
        return;
    }
}