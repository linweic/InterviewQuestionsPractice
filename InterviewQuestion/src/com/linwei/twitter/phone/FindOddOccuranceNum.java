package com.linwei.twitter.phone;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class FindOddOccuranceNum {
	//Find odd number
	public static int findOddNumber(int[] input){
		Set<Integer> set = new HashSet<Integer>();
		//corner test
		if(input == null || input.length == 0) return 0;
		for(int n : input){
			if(set.contains(n)) set.remove(n);
			else set.add(n);
		}
	
		Iterator<Integer> iter = set.iterator();
		return iter.next();
	}
	//Best solution : exclusive or
	public static int findOddNumberExOr(int[] input){
		int result = 0;
		for(int n: input){
			result ^= n;
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = new int[]{1,1,2,3,3,3,4,4,3};
		System.out.println(findOddNumberExOr(input));
	}

}
