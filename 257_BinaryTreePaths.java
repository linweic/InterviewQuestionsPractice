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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<String>();
        if(root == null) return list;
        StringBuilder sb = new StringBuilder();
        dfs(list, sb, root);
        return list;
    }
    private void dfs(List<String> list, StringBuilder sb, TreeNode node){
        if(sb.length() == 0) sb.append(node.val);
        else sb.append("->").append(node.val);
        StringBuilder copy = new StringBuilder(sb.toString()); //maintain a copy of the string so that each copy could go for each subtree
        if(node.left == null && node.right == null) list.add(copy.toString());
        if(node.left != null) dfs(list, copy, node.left);
        if(node.right != null) dfs(list, sb, node.right);
        return;
    }
}