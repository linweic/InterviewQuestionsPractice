package com.linwei.amazon.oa;

public class DayChange {
	//left to cell[0] is 0, right to cell[length-1] is 0;
	//same on two sides: 0; otherwise: 1
	//Dynamic Programming
	//In-place update: first bit stores current state, second bit stores next state,
	//At the end of each day, shift second bit to first bit
	public static int[] dayChange(int[] cell, int days){
		if(cell == null) return null;
		int len = cell.length;
		if(len == 0) return new int[0];
		if(len == 1) return new int[]{0};
		//int[] dp = new int[len];
		for(int i = 1; i<=days; i++){
			cell[0] = cell[0]|((0^(cell[1]&1))<<1);
			cell[len-1] = cell[len-1]|(((cell[len-2]&1) ^ 0)<<1);
			for(int j = 1; j<len-1; j++){
				cell[j] = cell[j]|(((cell[j-1]&1) ^ (cell[j+1]&1))<<1);
			}
			for(int j = 0; j<len; j++){
				cell[j] = cell[j]>>1;
			}
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
		int days = 3;
		DayChange.printarray(cell);
		int[] res_my1 = DayChange.dayChange(cell, days);
		DayChange.printarray(res_my1);
		System.out.println();
		DayChange.printarray(cell1);
		int[] res1 = DayChange.change5(cell1, days);
		DayChange.printarray(res1);
	}

}
