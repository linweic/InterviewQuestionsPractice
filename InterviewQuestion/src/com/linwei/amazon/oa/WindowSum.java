package com.linwei.amazon.oa;

import java.util.ArrayList;
import java.util.List;

public class WindowSum {
	public static List<Integer> getSum1(List<Integer> arr, int k){
		List<Integer> result = new ArrayList<Integer>();
		if(arr == null || arr.isEmpty() || k <0){
			return result;
		}
		int left = 0;
		int right = k-1;
		while(right < arr.size()){
			result.add(getSum(arr, left, right));
			left++;
			right++;
		}
		return result;
	}
	private static int getSum(List<Integer> arr, int left, int right){
		int sum = 0;
		for(int i = left; i<=right; i++){
			sum += arr.get(i);
		}
		return sum;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> arr = new ArrayList<Integer>();
		for(int i = 1; i<= 10; i++){
			arr.add(i);
		}
		for(Integer i: arr) System.out.print(i+" ");
		System.out.println();
		for(Integer i: WindowSum.getSum1(arr, 3)) System.out.print(i + " ");
		
	}

}
