public class Solution {
    /**
     * maintain an index to keep track of which char in the word to check
     * at each spot recursively check whether each direction works or not, if not, return and move to next direction
     * return true whenever find a match; if no direction finds a match, return false
     * */
    public boolean exist(char[][] board, String word) {
        //if(precheck(board, word) == false) return false;
        if(board == null|| word == null) return false;
        if(board.length == 0 || board[0].length == 0) return false;
        int row = board.length;
        int col = board[0].length;
        boolean visited[][] = new boolean[row][col];
        //It is IMPORTANT to start a loop to find the first spot to start with
        for(int i = 0; i<row; i++){
            for(int j = 0; j<col; j++){
                if(board[i][j] == word.charAt(0)){
                    boolean b = exist(board, word, 0, i, j, visited, row, col);
                    if(b == true) return b;
                }
            }
        }
        return false;
    }
    private boolean exist(char[][] board, String word, int i, int r, int c, boolean[][] visited, int row, int col){
        if(isValid(r, c, row, col, visited) == false) return false;
        if(board[r][c] == word.charAt(i)){
            visited[r][c] = true;
            //IMPORTANT: terminates the recursion when all characters match
            if(i == word.length() - 1) return true;
            i++;
            //check for directions one by one in fast-return fashion
            if(exist(board, word, i, r-1, c, visited, row, col) == true) return true;
            if(exist(board, word, i, r+1, c, visited, row, col) == true) return true;
            if(exist(board, word, i, r, c-1, visited, row, col) == true) return true;
            if(exist(board, word, i, r, c+1, visited, row, col) == true) return true;
            //none of the direction gets a match
            visited[r][c] = false;
            return false;
        }
        return false;
    }
    private boolean isValid(int r, int c, int row, int col, boolean[][] visited){
        if(r < 0 || r >= row || c < 0 || c >= col || visited[r][c] == true) return false;
        return true;
    }
    /*redundant*/
    private boolean precheck(char[][] board, String word){
        if(board == null|| word == null) return false;
        if(board.length == 0 || board[0].length == 0) return false;
        int row = board.length;
        int col = board[0].length;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        char[] carray = word.toCharArray();
        for(int i = 0; i< row; i++){
            for(int j = 0; j < col; j++){
                Character c = Character.valueOf(board[i][j]);
                if(map.containsKey(c)) {
                    int count = map.get(c);
                    map.put(c, count++);
                }
                else map.put(c, 1);
            }
        }
        for(char c : carray){
            if(map.containsKey(Character.valueOf(c))) {
            	int count = map.get(Character.valueOf(c));
            	if(count > 0){
            	    map.put(c, count--);
            	}
            }
            else return false;
        }
        Set<Character> set = map.keySet();
        for(char c : set){
            if(map.get(c) < 0) return false;
        }
        return true;
    }
}