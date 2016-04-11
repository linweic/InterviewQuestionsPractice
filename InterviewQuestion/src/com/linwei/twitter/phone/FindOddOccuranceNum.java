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
	/**
	 * Divide the array into two parts, each part contains one number occurring odd number of times.
	 * Calculate the odd number in each sub-array separately. 
	 * @param arr
	 * @return
	 */
	public static int[] findTwoOddNumbers(int[] arr){
		int size = arr.length;
		int xor2 = arr[0]; /* Will hold XOR of two odd occurring elements */
		int set_bit_no;  /* Will have only single set bit of xor2 */
		int i;
		int n = size - 2;
		int x = 0, y = 0;
		 
		/* Get the xor of all elements in arr[]. The xor will basically
		   be xor of two odd occurring elements */
		for(i = 1; i < size; i++){
		  xor2 = xor2 ^ arr[i];
		}
		System.out.println(Integer.toBinaryString(xor2));
		/* Get one set bit in the xor2. We get rightmost set bit
		   in the following line as it is easy to get */
		set_bit_no = xor2 & ~(xor2-1);//IMPORTANT trick!!!!
		System.out.println(Integer.toBinaryString(set_bit_no));
		/* Now divide elements in two sets: 
		  1) The elements having the corresponding bit as 1. 
		  2) The elements having the corresponding bit as 0.  */
		for(i = 0; i < size; i++){
			/* XOR of first set is finally going to hold one odd 
		     occurring number x */
			if((arr[i] & set_bit_no) != 0){
				x = x ^ arr[i];
			}
			/* XOR of second set is finally going to hold the other 
		     odd occurring number y */
		    else{
		      y = y ^ arr[i]; 
		    }
		}
		return new int[]{x, y};
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = new int[]{1,1,2,3,3,3,4,4,3};
		int[] input2 = new int[]{4, 2, 4, 5, 2, 3, 3, 1};
		int[] result = findTwoOddNumbers(input2);
		for(int i: result){
			System.out.print(i+" ");
		}
		System.out.println();
	}

}
