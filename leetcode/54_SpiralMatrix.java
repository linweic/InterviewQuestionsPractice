public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return list;
        int row = matrix.length;
        int col = matrix[0].length;
        int left = 0, right = col-1;
        int top = 0, bottom = row-1;
        while(true){
            /*IMPORTANT: check the boundary whenever a row or a col is finished*/
            for(int i = left; i<=right; i++){
                list.add(matrix[top][i]);
            }
            top++;
            if(top > bottom) break;
            for(int i = top; i<=bottom; i++){
                list.add(matrix[i][right]);
            }
            right--;
            if(right < left) break;
            for(int i = right; i>=left; i--){
                list.add(matrix[bottom][i]);
            }
            bottom--;
            if(bottom < top) break;
            for(int i = bottom; i>=top; i--){
                list.add(matrix[i][left]);
            }
            left++;
            if(left > right) break;
        }
        return list;
    }
}