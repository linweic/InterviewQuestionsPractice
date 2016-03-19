package com.linwei.twitter.oa;

import java.util.Arrays;

public class ClosestNumber {
	public static String getClosestPair(int num, String s){
		String strings[] = s.split("\\s+");
		int nums[] = new int[num];
		for(int i = 0; i< num; i++){
			nums[i] = Integer.valueOf(strings[i]).intValue();
		}
		StringBuilder sb = null;
		int maxdelta = Integer.MAX_VALUE;
		Arrays.sort(nums);
		//Because the nums array is sorted, the result pair consists numbers adjacent to each other
		for(int i = 0; i< num-1; i++){
			int delta = Math.abs(nums[i]- nums[i+1]);
			if(delta<maxdelta){
				maxdelta = delta;
				sb = new StringBuilder(nums[i]+" "+ nums[i+1]+", ");
			}
			else if(delta == maxdelta){
				sb.append(nums[i]+" "+ nums[i+1]+", ");
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getClosestPair(6,"12 5 3 6 7 13"));
	}

}
