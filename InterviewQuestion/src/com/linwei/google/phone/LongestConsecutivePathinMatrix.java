package com.linwei.google.phone;

import java.util.Stack;

public class LongestConsecutivePathinMatrix {
	public static int LongestPath(char[][] matrix){
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
			throw new IllegalArgumentException("input matrix is invalid");
		}
		int row = matrix.length;
		int col = matrix[0].length;
		int maxLength = 0;
		int cache[][] = new int[row][col];//cache[i][j] denotes the longest path starting from (i, j)
		Stack<Character> path = new Stack<Character>();
		for(int i = 0; i<row; i++){
			for(int j = 0; j<col; j++){
				Stack<Character> stack = new Stack<Character>();//store the nodes on path
				if(cache[i][j] != 0) maxLength = Math.max(maxLength, cache[i][j]);
				else maxLength = Math.max(maxLength, dfs(matrix, 0, 0, stack, cache));
				/*
				if(pathLength>maxLength) {
					maxLength = pathLength;
					path = stack;
				}
				*/
			}
		}
		return maxLength;
	}
	private static int dfs(char[][] matrix, int i, int j, Stack<Character> stack, int[][] cache){
		int row = matrix.length;
		int col = matrix[0].length;
		if(i<0 || i>=row || j<0 || j>=col) return 0;
		int path = 0;
		if(i+1>=0 && i+1<row && (matrix[i+1][j] - matrix[i][j] == 1)){
			if(cache[i+1][j] !=0) path = Math.max(path, cache[i+1][j]+1);
			else path = Math.max(path, dfs(matrix, i+1, j, stack, cache)+1);
		}
		if(i-1>=0 && i-1<row && matrix[i-1][j] - matrix[i][j] == 1){
			if(cache[i-1][j] != 0) path = Math.max(path, cache[i-1][j]+1);
			else path = Math.max(path, dfs(matrix,i-1, j, stack, cache)+1);
		}
		if(j-1 >=0 && j-1 < col && matrix[i][j-1] - matrix[i][j] == 1){
			if(cache[i][j-1] != 0) path = Math.max(path, cache[i][j-1]+1);
			else path = Math.max(path, dfs(matrix, i, j-1, stack, cache)+1);
		}
		if(j+1 >=0 && j+1 < col && matrix[i][j+1] - matrix[i][j] == 1){
			if(cache[i][j+1] != 0) path = Math.max(path, cache[i][j+1]+1);
			path = Math.max(path, dfs(matrix, i, j+1, stack, cache)+1);
		}
		path = Math.max(path, 1);
		cache[i][j] = path;
		return path;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] matrix = new char[][]{
			{'A', 'B', 'C'},
			{'X', 'A', 'D'},
			{'X', 'X', 'E'}
		};
		System.out.println(LongestPath(matrix));
	}

}
