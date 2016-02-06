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
	*	credit to sruzic from Leetcode: 
	*	https://leetcode.com/discuss/21411/my-simple-java-solution-in-3-lines
	**/
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean isValidBST(TreeNode root, long min, long max){
        if(root == null) return true;
        if(root.val>=max || root.val<=min) return false;
        return(isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max));
    }
}