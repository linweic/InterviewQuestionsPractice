package com.linwei.amazon.oa;

import com.linwei.amazon.util.TreeNode;

public class MaximumPathSum {
	public static int getMaxSum(TreeNode root){
		if(root == null) return 0;
		if(root.left == null && root.right == null) return root.val;
		return Math.max(getMaxSum(root.left), getMaxSum(root.right))+root.val;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode n1 = new TreeNode(10);
		TreeNode n2 = new TreeNode(-2);
		TreeNode n3 = new TreeNode(7);
		TreeNode n4 = new TreeNode(8);
		TreeNode n5 = new TreeNode(-4);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		System.out.println(getMaxSum(n1));
	}

}
