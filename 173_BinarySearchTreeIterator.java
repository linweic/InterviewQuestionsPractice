/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    
    TreeNode cur;
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        cur = root;
        stack = new Stack<TreeNode>();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty() || cur != null; 
        // the reason that we have cur!=null is that when the root is returned, the stack is empty, but the right subtree is not traversed. so we need to make sure only when stack is empty AND cur is null, the iteration is done.
    }

    /** @return the next smallest number */
    public int next() {
        //find the leftmost node and return it
        while(cur != null){
            stack.push(cur);
            cur = cur.left;
        }
        TreeNode smallest = stack.pop();
        //after getting the smallest node, we know the next smallest node is the leftmost node in the current smallest node's right subtree
        cur = smallest.right;
        return smallest.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */