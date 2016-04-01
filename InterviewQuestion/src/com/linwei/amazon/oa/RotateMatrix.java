package com.linwei.amazon.oa;

public class RotateMatrix {
	/**
	 * rotate the matrix in place,
	 * 从外层到内层遍历，每一个loop里shift那一层的四条边。
	 * 因为一共row/2次循环，每次循环访问(row-i+1)*(col-i+1)个cell, 其中i表示第几层。
	 * 时间复杂度为O(n*m), n,m为矩阵的长和宽。space complexity: O(1)
	 * @param matrix
	 * @param flag
	 * @return
	 */
	public static int[][] rotateByCell(int[][] matrix, int flag){
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return null;
		int row = matrix.length;
		int col = matrix[0].length;
		int leftbound = 0;
		int rightbound = col-1;
		int upperbound = 0;
		int lowerbound = row-1;
		for(upperbound = 0;upperbound<row/2;upperbound++){
			if(flag == 1){ //rotate to the right
				int up_row_overflow = matrix[upperbound][rightbound];
				//shift the top row
				for(int j = rightbound; j>leftbound; j--){
					matrix[upperbound][j] = matrix[upperbound][j-1];
				}
				
				int right_col_overflow = matrix[lowerbound][rightbound];
				//shift the the rightmost column
				for(int r = lowerbound; r>upperbound+1; r--){
					matrix[r][rightbound] = matrix[r-1][rightbound];
				}
				matrix[upperbound+1][rightbound] = up_row_overflow;
				
				int bottom_row_overflow = matrix[lowerbound][leftbound];
				//shift the bottom row
				for(int j = leftbound; j< rightbound-1; j++){
					matrix[lowerbound][j] = matrix[lowerbound][j+1];
				}
				matrix[lowerbound][rightbound - 1] = right_col_overflow;
				
				//shift the left column
				for(int r = upperbound; r<lowerbound-1; r++){
					matrix[r][leftbound] = matrix[r+1][leftbound];
				}
				matrix[lowerbound-1][leftbound] = bottom_row_overflow;
			}
			rightbound--;
			leftbound++;
			lowerbound--;
		}
		return matrix;
	}
	public static void printMatrix(int[][] matrix){
		for(int i = 0; i<matrix.length; i++){
			for(int j = 0; j<matrix[0].length; j++){
				System.out.print(matrix[i][j]+"\t");
			}
			System.out.println();
		}
	}
	/**
	 * Time: O(n*m), Space:O(n*m); not efficient to use in place method
	 * @param matrix
	 * @param flag
	 * @return
	 */
	public static int[][] rotateBySide(int[][] matrix, int flag) {
		if (matrix == null || matrix.length == 0 ||matrix[0].length == 0) {
			return null;
		}
		int row = matrix.length;
		int col = matrix[0].length;
		if(flag == 1){
			//rotate to the right
			int[][] right = new int[row][col];
			for(int i = 0; i<row; i++){
				for(int j = 0; j<col;j++){
					right[j][col-1-i] = matrix[i][j];
				}
			}
			return right;
		}
		else if(flag == 0){
			//rotate to the left
			int[][] left = new int[row][col];
			for(int i = 0; i<row;i++){
				for(int j = 0; j<col; j++){
					left[row-1-j][i] = matrix[i][j];
				}
			}
			return left;
		}
		else return null;
	}
	/**
	 * In place method
	 * @param matrix
	 */
	public static int[][] rotateBySideInplace(int[][] matrix, int flag){
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
			return null;
		}
		int n = matrix.length;
		if(flag == 1){
			//rotate to right
			for(int i = 0; i<n/2; i++){
				for(int j = 0; j<(n+1)/2; j++){
					int tmp = matrix[i][j];
					matrix[i][j] = matrix[n-1-j][i];
					matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
					matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
					matrix[j][n-1-i] = tmp;
				}
			}
		}
		else{
			for(int i = 0; i<n/2; i++){
				for(int j = 0; j<(n+1)/2; j++){
					int tmp = matrix[i][j];
					matrix[i][j] = matrix[j][n-1-i];
					matrix[j][n-1-i] = matrix[n-1-i][n-1-j];
					matrix[n-1-i][n-1-j] = matrix[n-1-j][i];
					matrix[n-1-j][i] = tmp;
				}
			}
		}
		return matrix;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Test Case 1
	    int a[][] = new int[][]{ {1,  2,  3,  4},
	        {5,  6,  7,  8},
	        {9,  10, 11, 12},
	        {13, 14, 15, 16}  };
	 
	    // Test Case 2
	    int b[][] = new int[][]{{1, 2, 3},
	                      {4, 5, 6},
	                      {7, 8, 9}
	                     };
	    //int[][] matrix = RotateMatrix.rotateBySide(a, 0);
	    //int[][] matrix2 = RotateMatrix.rotateBySide(b, 0);
	    int[][] matrix = RotateMatrix.rotateBySideInplace(a, 1);
	    int[][] matrix2 = RotateMatrix.rotateBySideInplace(b, 1);
	    RotateMatrix.printMatrix(matrix);
	    System.out.println();
	    RotateMatrix.printMatrix(matrix2);
	}

}
