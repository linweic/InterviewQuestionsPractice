package com.linwei.amazon.oa;

import java.util.Arrays;

public class ArithmeticSeq {
	/**
	 * find out the longest length of the arithmetic sequence
	 * @param nums
	 * @return
	 */
	public static int LLAP(int[] nums){
		if(nums == null) return 0;
		if(nums.length <= 2) return nums.length;
		Arrays.sort(nums);
		printArray(nums);
		int len = nums.length;
		int longest = 2;
		//2D array to store dp values
		//dp[i][j] denotes the length of the arithmetic progression starting with nums[i] and nums[j]
		int dp[][] = new int[len][len];
		//The last column is 2 obvious.
		for(int i = 0; i<len; i++){
			dp[i][len-1] = 2;
		}
		for(int j = len-2; j>0; j--){
			//check if nums[i], nums[j], nums[k] is arithmetic sequence
			int i = j-1, k = j+1;
			while(0<=i && k<=len-1){
				if(nums[i] + nums[k]> 2*nums[j]) {
					dp[i][j] = 2; //NOTE:MUST update dp[i][j] before move on
					i--;
				}
				else if(nums[i] + nums[k] < 2*nums[j]) k++;
				else{
					dp[i][j] = dp[j][k]+1;
					longest = Math.max(longest, dp[i][j]);
					i--;
				}
			}
			for(int m = i; m>=0; m--){
				dp[m][j] = 2;
			}
		}
		return longest;
	}
	public static void printArray(int[] arr){
		for(int i: arr){
			System.out.print(i+" ");
		}
		System.out.println();
	}
	/**
	 * find out the number of arithmetic sequence
	 * @param nums
	 * @return
	 */
	/*solution from cheat sheet*/
	public static int find(int[] nums) {
		if (nums == null || nums.length < 3) {
			return 0;
		}
		int left = 0;
		int right = 1;
		int diff = nums[1] - nums[0];
		int cnt = 0;
		while (right < nums.length - 1) {
			if (diff != nums[right + 1] - nums[right]) {
				cnt += (right - left - 1) * (right - left) / 2;
				if (cnt > 1000000000) {
					return -1;
				}
				diff = nums[right + 1] - nums[right];
				left = right;
			}
			right++;
		}
		cnt += (right - left - 1) * (right - left) / 2;
		return cnt > 1000000000 ? -1 : cnt;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2,5,2,3,4,6,8,10,12,9,8,7,6,2,4,8};
		int[] arr1 = {1,7,10,13,14,19};
		int[] arr2 = {1, 7, 10, 15, 27, 29};
		int[] arr3 = {2, 4, 6, 8, 10};
		/*
		System.out.println(LLAP(arr));
		System.out.println(LLAP(arr1));
		System.out.println(LLAP(arr2));
		System.out.println(LLAP(arr3));
		*/
		System.out.println(find(arr));
		System.out.println(find(arr1));
		System.out.println(find(arr2));
		System.out.println(find(arr3));
		Arrays.sort(arr);
		printArray(arr);
	}

}
