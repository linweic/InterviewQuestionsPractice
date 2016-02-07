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
     * use dfs to traverse every path down to the leaf,
     * at the begining of each dfs, update path sum
     * when the program reaches the leaf, add the pathSum to total sum
     * note that before every return in dfs, revert pathsum to its previous value
     * 
     * in the main thread, add up all the path numbers
     * */
    private class NodeSum{
        int pathSum;
        int sum;
        public NodeSum(int num1, int num2){
            pathSum = num1;
            sum = num2;
        }
    }
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        NodeSum ns = new NodeSum(0,0);
        dfs(root, ns);
        return ns.sum;
    }
    private NodeSum dfs(TreeNode root, NodeSum ns){
        ns.pathSum = 10*ns.pathSum + root.val;
        if(root.left == null && root.right == null){
            //reaches the leaf
            ns.sum += ns.pathSum;
        }
        if(root.left!=null) ns = dfs(root.left, ns);
        if(root.right!=null) ns = dfs(root.right,ns);
        ns.pathSum = (ns.pathSum - root.val)/10;
        return ns;
    }
}