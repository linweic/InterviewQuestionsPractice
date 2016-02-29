/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * first iterate through left subtree, then root, then right subtree
     * */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        inorderHelper(list, root);
        return list;
    }
    private void inorderHelper(List<Integer> list, TreeNode root){
        if(root == null) return;
        inorderHelper(list, root.left);
        list.add(root.val);
        inorderHelper(list, root.right);
        return;
    }
}