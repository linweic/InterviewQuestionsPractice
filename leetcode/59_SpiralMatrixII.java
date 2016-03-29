public class Solution {
    /**
    * similar to Spiral Matrix
    **/
    public int[][] generateMatrix(int n) {
        if(n == 0) return new int[0][0];
        int[][] matrix = new int[n][n];
        int left = 0;
        int right = n-1;
        int top = 0;
        int bottom = n-1;
        int num = 1;
        while(true){
            for(int i = left; i<=right; i++){
                matrix[top][i] = num++;
            }
            top++;
            if(top > bottom) break;
            for(int i = top; i<=bottom; i++){
                matrix[i][right] = num++;
            }
            right--;
            if(right < left) break;
            for(int i = right; i >= left; i--){
                matrix[bottom][i] = num++;
            }
            bottom--;
            if(bottom < top) break;
            for(int i = bottom; i>=top; i--){
                matrix[i][left] = num++;
            }
            left++;
            if(left > right) break;
        }
        return matrix;
    }
}