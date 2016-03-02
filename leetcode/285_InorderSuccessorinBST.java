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
     * The idea is to compare root's value with p's value if root is not null, and consider the following two cases:
     * root.val > p.val. In this case, root can be a possible answer, so we store the root node first and call it res. However, we don't know if there is anymore node on root's left that is larger than p.val. So we move root to its left and check again.
     * root.val <= p.val. In this case, root cannot be p's inorder successor, neither can root's left child. So we only need to consider root's right child, thus we move root to its right and check again.
     * We continuously move root until exhausted. To this point, we only need to return the res in case 1.
         credit to: https://leetcode.com/discuss/77805/java-5ms-short-code-with-explanations
     * */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode res = null;
        while(root != null){
            if(p.val < root.val){ 
                //root could be its successor, store it first
                //but some nodes on root's left could also be the res, so we need to loop this process
                res = root;
                root = root.left;
            }
            else{
                //else, root cannot be the result, nor do root's left subtree
                //so we check on root's right subtree
                root = root.right;
            }
        }
        return res;
    }
}