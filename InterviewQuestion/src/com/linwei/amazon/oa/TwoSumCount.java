package com.linwei.amazon.oa;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TwoSumCount {
	public static int count1(int[] nums, int target){
		int len = nums.length;
		if(nums == null || len == 0 || target<0) return 0;
		int count = 0;
		Set<Integer> set = new HashSet<Integer>();
		Arrays.sort(nums);
		for(int i: nums) set.add(i);
		for(int i = 0; i<len && nums[i]<=target; i++){
			if(set.contains(target-nums[i]) && target-nums[i]>=nums[i]) count++;
		}
		return count;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {3,2,4};
		int target = 6;
		System.out.println(TwoSumCount.count1(nums, target));
	}

}
