public class Solution {
    /**
     * Check every cell in the matrix, if matrix[i][j] is zero, then set matrix[i][0] and matrix[0][j] as 0.
     * Then re-check first row and first column, 
     *      if a cell in first row is 0, set the corresponding column as 0;
     *      if a cell in first column is 0, set the corresponding row as 0;
     * If matrix[i][0] or matrix[0][j] is zero, don't set matrix[0][0] as 0, because otherwise we don't know what direction to reset.
     * So we use two additional variable to indicate if first row or first column need to be reset.
     * */
    public void setZeroes(int[][] matrix) {
        //corner case
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        boolean first_row = false, first_col = false; //denote whether first row and first column need to be reset
        //check through each cell, store states in first row/colum or boolean variables
        for(int i = 0; i< row; i++){
            for(int j = 0; j<col; j++){
                if(matrix[i][j] == 0){
                    if(i == 0){
                        //first row needs to be reset
                        first_row = true;
                    }
                    if(j == 0){
                        //first column needs to be reset
                        first_col = true;
                    }
                    if((i!=0) && (j!=0)){
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }
                }
            }
        }
        //reset matrix
        for(int i = 1; i<col; i++){
            if(matrix[0][i] == 0){
                for(int j = 1; j<row; j++){
                    matrix[j][i] = 0;
                }
            }
        }
        for(int i = 1; i<row; i++){
            if(matrix[i][0] == 0){
                for(int j = 1; j<col; j++){
                    matrix[i][j] = 0;
                }
            }
        }
        if(first_row == true){
            for(int i = 0; i<col; i++){
                matrix[0][i] = 0;
            }
        }
        if(first_col == true){
            for(int i = 0; i<row; i++){
                matrix[i][0] = 0;
            }
        }
    }
}