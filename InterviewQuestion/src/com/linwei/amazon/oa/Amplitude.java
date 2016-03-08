package com.linwei.amazon.oa;

import com.linwei.amazon.util.TreeNode;

public class Amplitude {
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;
	int delta = 0;
	public static int getAmplitude(TreeNode root){
		if(root == null) return 0;
		helper(root);
		return max-min;
	}
	private static void helper(TreeNode root){
		min = Math.min(min, root.val);
		max = Math.max(max, root.val);
		if(root.left == null && root.right == null) return;
		if(root.left != null) helper(root.left);
		if(root.right != null) helper(root.right);
		return;
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
		System.out.println(getAmplitude(n1));
	}

}
