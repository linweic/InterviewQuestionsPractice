package com.linwei.twitter.oa;

import java.util.HashSet;
import java.util.Set;

public class CountDuplicates {
	public static int count(int[] array){
		Set<Integer> checked = new HashSet<Integer>(); //store the numbers that are checked 
		Set<Integer> result = new HashSet<Integer>(); //store the numbers that is duplicated
		for(int i : array){
			if(checked.contains(i)) result.add(i);
			else checked.add(i);
		}
		//System.out.println(checked);
		return result.size();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(count(new int[]{1,0,0,1,0,2}));
	}

}
