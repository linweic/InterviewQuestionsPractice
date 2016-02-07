public class Solution {
    /**
     * [RECURSIVE SOLUTION]:
     * first check root
     * starting from root.left(node1) and  root.right(node2),
     * check null, val to make sure currnet level is symmetric
     * then recursively call compare on (node1.left, node2.right), (node1.right, node2.left)
     * to make sure their children are symmetric.
     * */
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return cmp(root.left, root.right);
    }
    private boolean cmp(TreeNode node1, TreeNode node2){
        if(node1 == null && node2 == null) return true;
        if(node1 == null || node2 == null) return false;
        if(node1.val != node2.val) return false;
        return cmp(node1.left, node2.right) && cmp(node1.right, node2.left);
    }
}