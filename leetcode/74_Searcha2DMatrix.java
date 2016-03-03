public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null) return false;
        int row = matrix.length;
        if(row == 0) return false;
        int col = matrix[0].length;
        if(col == 0) return false;
        int r = 0;
        if(matrix[row-1][col-1]<target) return false;
        for(int i = 0; i<row; i++){
            if(matrix[i][col-1] == target){
                return true;
            }
            else if (matrix[i][col-1] > target){
                r = i;
                break;
            }
        }
        int low = 0; int high = col-1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(matrix[r][mid] == target) return true;
            else if(matrix[r][mid] > target) high = mid -1;
            else if(matrix[r][mid] < target) low = mid + 1;
        }
        return false;
    }
}