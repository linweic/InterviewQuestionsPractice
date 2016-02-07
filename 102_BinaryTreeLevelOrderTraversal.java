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
     * Use BST to traverse the tree in level order
     * 
     * */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null) return res;
        List<TreeNode> levelNodes = new ArrayList<TreeNode>();
        levelNodes.add(root);
        List<Integer> levelVal = new ArrayList<Integer>();
        levelVal.add(root.val);
        res.add(levelVal);
        levelOrderHelper(res, levelNodes);
        return res;
    }
    private void levelOrderHelper(List<List<Integer>> res, List<TreeNode> lastLevelNodes){
        List<TreeNode> curLevelNodes = new ArrayList<TreeNode>();
        List<Integer> curLevelVal = new ArrayList<Integer>();
        for(TreeNode l : lastLevelNodes){
            if(l.left != null) curLevelNodes.add(l.left);
            if(l.right != null) curLevelNodes.add(l.right);
        }
        if(curLevelNodes.size() == 0) return;
        for(TreeNode n : curLevelNodes) curLevelVal.add(n.val);
        res.add(curLevelVal);
        levelOrderHelper(res, curLevelNodes);
    }
}