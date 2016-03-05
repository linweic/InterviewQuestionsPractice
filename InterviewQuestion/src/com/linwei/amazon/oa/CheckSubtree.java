package com.linwei.amazon.oa;

import com.linwei.amazon.util.TreeNode;

public class CheckSubtree {
	public static boolean check(TreeNode t1, TreeNode t2){
		if(t2 == null) return true;
		if(t1 == null && t2 != null) return false;
		if(equal(t1, t2) == true) return true;
		else return check(t1.left, t2) || check(t1.right, t2);
	}
	private static boolean equal(TreeNode t1, TreeNode t2){
		if(t1 == null && t2 == null) return true;
		if(t1 == null || t2 == null) return false;
		if(t1.val == t2.val){
			return equal(t1.left, t2.left)&&equal(t1.right, t2.right);
		}
		else return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //BinaryTree tree = new BinaryTree();
        
        // TREE 1
        /* Construct the following tree
              26
             /   \
            10     3
           /    \     \
          4      6      3
           \
            30  */
          
        TreeNode tree = new TreeNode(26);
        tree.right = new TreeNode(3);
        tree.right.right = new TreeNode(3);
        tree.left = new TreeNode(10);
        tree.left.left = new TreeNode(4);
        tree.left.left.right = new TreeNode(30);
        tree.left.right = new TreeNode(6);
 
        // TREE 2
        /* Construct the following tree
           10
         /    \
         4      6
          \
          30  */
          
        TreeNode tree2 = new TreeNode(10);
        tree2.right = new TreeNode(6);
        tree2.left = new TreeNode(4);
        tree2.left.right = new TreeNode(31);
 
        if (CheckSubtree.check(tree, tree2)) {
            System.out.println("Tree 2 is subtree of Tree 1 ");
        } else {
            System.out.println("Tree 2 is not a subtree of Tree 1");
        }
	}

}
