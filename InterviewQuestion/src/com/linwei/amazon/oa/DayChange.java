package com.linwei.amazon.oa;

import java.util.Collections;

public class DayChange {
	//left to cell[0] is 0, right to cell[length-1] is 0;
	//same on two sides: 0; otherwise: 1
	//Dynamic Programming
	public static int[] dayChange(int[] cell, int days){
		if(cell == null) return null;
		int len = cell.length;
		if(len == 0) return new int[0];
		if(len == 1) return new int[]{0};
		int[] dp = new int[len];
		for(int i = 1; i<=days; i++){
			dp[0] = 0^cell[1];
			dp[len-1] = cell[len-2] ^ 0;
			for(int j = 1; j<len-1; j++){
				dp[j] = cell[j-1] ^ cell[j+1];
			}
			int[] tmp = cell;
			cell = dp;
			dp = tmp;
		}
		return cell;
	}
	/*solution from cheat sheet, for comparison*/
	public static int[] change5(int[] arr, int days) {
		if (arr == null || arr.length <= 1 || days <= 0) {
		return arr;
	}
		int len = arr.length;
		// preNum represents previous day's list
		int[] preNum = new int[len];
		preNum = arr;
		for (int cnt = 0; cnt < days; cnt++) {
			int[] curNum = new int[len];
			curNum[0] = preNum[1];
			curNum[len - 1] = preNum[len - 2];
			for (int i = 1; i < len - 1; i++) {
				curNum[i] = preNum[i - 1] ^ preNum[i + 1];
			}
			preNum = curNum;
		}
		return preNum;
	}

	private static void printarray(int[] arr){
		for(int i : arr){
			System.out.print(i+"\t");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] cell = new int[]{1,0,0,0,0,1,0,0};
		int[] cell1 = cell.clone();
		int days = 1;
		DayChange.printarray(cell);
		int[] res_my1 = DayChange.dayChange(cell, days);
		DayChange.printarray(res_my1);
		System.out.println();
		DayChange.printarray(cell1);
		int[] res1 = DayChange.change5(cell1, days);
		DayChange.printarray(res1);
	}

}
