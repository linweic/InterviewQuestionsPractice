package com.linwei.twitter.oa;

public class Fibonacci {
	/**
	 * Given a number, return an array containing the first n items of the fibonacci number
	 * @param n
	 * @return
	 */
	public static int[] getFiboList(int n){
		int fibo[] = new int[n];
		if(n == 0) return fibo;
		fibo[0] = 0;
		if(n == 1) return fibo;
		fibo[1] = 1;
		if(n == 2) return fibo;
		for(int i = 2; i< n; i++){
			fibo[i] = fibo[i-2] + fibo[i-1];
		}
		return fibo;
	}
	private static void printArray(int[] array){
		for(int i : array){
			System.out.print(i + " ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printArray(getFiboList(0));
		printArray(getFiboList(1));
		printArray(getFiboList(2));
		printArray(getFiboList(3));
		printArray(getFiboList(4));
		printArray(getFiboList(10));
	}

}
