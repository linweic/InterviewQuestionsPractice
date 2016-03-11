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
    /*iterative method*/
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(root == null) return list;
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            while(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }
        return list;
    }
}