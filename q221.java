public class Solution {
    /**dp[i][j] to denote maximal side of square with (i,j) on lower right corner
         * if martix[i][j] is 0, dp[i][j] is 0
         * else
         *      dp[i][j] = min(dp[i-1][j], dp[i-1][j-1], dp[i][j-1])+1
         * corner case: dp[0][j] = matrix[0][j], dp[i][0] = matrix[i][0]
    * */
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        if(col == 0) return 0;
        int[][] dp = new int[row][col];
        int maxSide = 0;
        for(int i = 0;i<row;i++) {
            dp[i][0] = (matrix[i][0]=='0')?0:1; //initialize first col
            maxSide = (dp[i][0]>maxSide)?dp[i][0]:maxSide;
        }
        for(int j = 0;j<col;j++) {
            dp[0][j] = (matrix[0][j]=='0')?0:1; //initialize first row
            maxSide = (dp[0][j]>maxSide)?dp[0][j]:maxSide;
        }
        for(int i = 1;i<row;i++){
            for(int j = 1; j<col;j++){
                if(matrix[i][j] == '0') dp[i][j] = 0;
                else{
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1],dp[i-1][j]),dp[i][j-1]) +1;
                }
                maxSide = (dp[i][j]>maxSide)?dp[i][j]:maxSide;
            }
        }
        return maxSide*maxSide;
    }
}