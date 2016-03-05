package com.linwei.amazon.oa;

import com.linwei.amazon.util.TreeNode;

public class MinimumPathSum {
	public static int getMiniSum(TreeNode root){
		if(root == null) return 0;
		int sub = 0;
		if(root.left == null && root.right == null) return root.val;
		if(root.left != null && root.right != null){
			sub = Math.min(getMiniSum(root.left), getMiniSum(root.right));
		}
		else if(root.left == null) sub = getMiniSum(root.right);
		else if(root.right == null) sub = getMiniSum(root.left);
		return sub+root.val;
	}
	public static int minPath2(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.left != null && root.right == null) {
			return minPath2(root.left) + root.val;
		}
		if (root.left == null && root.right != null) {
			return minPath2(root.right) + root.val;
		}
		return Math.min(minPath2(root.left), minPath2(root.right)) + root.val;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(7);
		root.left = new TreeNode(3);
		root.left.left = new TreeNode(10);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(8);
		root.right.right = new TreeNode(12);
		System.out.println(MinimumPathSum.getMiniSum(root));
		System.out.println(MinimumPathSum.minPath2(root));
		/*
		TreeNode root2 = new TreeNode(10);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(10);
        root2.left.left = new TreeNode(20);
        root2.left.right = new TreeNode(1);
        root2.right.right = new TreeNode(-25);
        root2.right.right.left = new TreeNode(3);
        root2.right.right.right = new TreeNode(4);
        System.out.println(MinimumPathSum.getMiniSum(root2));
        */
	}

}
