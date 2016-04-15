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
    /**
     * Solution 2
     * */
    /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
 * queue:
 * cur:
 * sublist: 
 * result:[ [3][9,20] [15,7] ]
 * */
    /**
     * Use bfs to put node in queue, put a dummy node when each level is finished
     * */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> sublist = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root == null) return result;
        queue.offer(root);
        queue.offer(new TreeNode(Integer.MAX_VALUE));
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if(cur.val == Integer.MAX_VALUE){
                result.add(sublist);
                sublist = new ArrayList<Integer>();
                if(!queue.isEmpty()) queue.offer(new TreeNode(Integer.MAX_VALUE));
            }
            else{
                sublist.add(cur.val);
                if(cur.left != null) queue.offer(cur.left);
                if(cur.right != null) queue.offer(cur.right);
            }
        }
        return result;
    }

}