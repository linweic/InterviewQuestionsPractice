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
     * iterate through 1 to n, find all the trees with root i
     *      recursively call the method to return trees
     *      each tree returned as left can combine with a tree returned as right and link to root i
     * return all the trees
     * 
     * */
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return new ArrayList<TreeNode>();
        return generateTreesHelper(1,n);
    }
    private List<TreeNode> generateTreesHelper(int start, int end){
        List<TreeNode> result = new ArrayList<TreeNode>();
        if(start>end){
            //note: a list with null element is different from an empty list!
            result.add(null);
            return result;
        }
        //iterate through start to end with i as root
        for(int i = start;i<=end; i++){
            List<TreeNode> leftTrees = generateTreesHelper(start, i-1);
            List<TreeNode> rightTrees = generateTreesHelper(i+1, end);
            for(TreeNode l : leftTrees){
                for(TreeNode r : rightTrees){
                    //create root treenode i
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    result.add(root);
                }
            }
        }
        return result;
    }
}