package com.linwei.amazon.oa;

import com.linwei.amazon.util.TreeNode;

public class MaxPathSumBST {
	public static int maxSum = Integer.MIN_VALUE;
	/*Method 1*/
	public static int getMax(TreeNode root){
		if(root == null) return 0;
		//traverse the tree in in-order way 
		inorderTraverse(root);
		return maxSum;
	}
	/**
	 * For each node we traversed, we calculate the maximum sum of path with this node as root.
	 * We first calculate the max path on the left down to the leaf, then calculate the right one.
	 * Add the root value with left max sum(if it is larger than 0) and right max path(if it is larger than 0)
	 * If the current sum is largest among all the sum that we traversed, then update maxSum.
	 * @param root
	 */
	private static void inorderTraverse(TreeNode root){
		if(root.left == null && root.right == null){
			//gets to the leaf node
			maxSum = Math.max(root.val, maxSum);
			return;
		}
		int leftSum = 0;
		int rightSum = 0;
		int sum = root.val;
		if(root.left!= null){
			inorderTraverse(root.left);
			leftSum = maxDown(root.left);
		}
		if(root.right != null){
			inorderTraverse(root.right);
			rightSum = maxDown(root.right);
		}
		if(leftSum>0) sum+=leftSum;
		if(rightSum>0) sum+=rightSum;
		maxSum = Math.max(sum, maxSum);
		return;
	}
	private static int maxDown(TreeNode root){
		if(root == null) return 0;
		int sub = 0;
		if(root.left == null && root.right == null) return root.val;
		if(root.left != null && root.right != null){
			sub = Math.max(maxDown(root.left), maxDown(root.right));
		}
		else if(root.left == null) sub = maxDown(root.right);
		else if(root.right == null) sub = maxDown(root.left);
		return (sub<0) ? root.val : sub + root.val;
	}
	/*Method 2*/
	private static int getMax1(TreeNode root){
		if(root == null) return 0;
		maxDown1(root);
		return maxSum;
	}
	
	private static int maxDown1(TreeNode root){
		if(root == null) return 0;
		int sub = 0;
		int leftSum = 0;//Max path sum on the left all the way down to leaf.
		int rightSum = 0;//Max path sum on the right all the way down to leaf.
		int curSum = root.val; //The sum of path if no ancestors of current root is being considered.
		if(root.left == null && root.right == null){
			maxSum = Math.max(root.val, maxSum);
			return root.val;
		}
		leftSum = maxDown1(root.left);
		rightSum = maxDown1(root.right);
		if(leftSum >0) curSum += leftSum;
		if(rightSum >0) curSum += rightSum;
		sub = Math.max(maxDown(root.left), maxDown(root.right));
		maxSum = Math.max(curSum, maxSum);
		return root.val+sub;
	}
	public static void main(String args[]){
		TreeNode root2 = new TreeNode(10);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(10);
        root2.left.left = new TreeNode(20);
        root2.left.right = new TreeNode(1);
        root2.right.right = new TreeNode(-25);
        root2.right.right.left = new TreeNode(35);
        root2.right.right.right = new TreeNode(42);
        root2.left.left.left = new TreeNode(2);
        root2.left.left.right = new TreeNode(10);
        root2.left.left.left.left = new TreeNode(20);
        root2.left.left.left.right = new TreeNode(1);
        root2.left.left.right.right = new TreeNode(-25);
        root2.left.left.right.right.left = new TreeNode(35);
        root2.left.left.right.right.right = new TreeNode(42);
        
        long start = System.currentTimeMillis();
        System.out.print(MaxPathSumBST.getMax(root2));
        long end = System.currentTimeMillis();
        long elapsed = end - start;
        System.out.println(" "+ elapsed+" milliseconds");
        
        start = System.currentTimeMillis();
        System.out.print(MaxPathSumBST.getMax1(root2));
        end = System.currentTimeMillis();
        System.out.println(" "+ elapsed+" milliseconds");
	}
}
