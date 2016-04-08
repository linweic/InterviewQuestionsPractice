public class Solution {
    /**
     * Backtracking solution, expensive
     * */
    
    public boolean wordBreak(String s, Set<String> wordDict) {
        if(wordDict == null || wordDict.isEmpty()) return false;
        for(String word : wordDict){
            if(breakable(s, wordDict) == true) return true;
        }
        return false;
    }
    private boolean breakable(String s, Set<String> wordDict){
        if(s.isEmpty() == true) return true;
        for(String string : wordDict){
            if(s.contains(string)){
                String tmp = s.replaceAll(string, "");
                if(breakable(tmp, wordDict)) return true;
            }
        }
        return false;
    }
    
    /**
     * DP: 
     *      construct a array dp[], where dp[i] denotes where s.substring(0, i) is breakable
     *      For any position i, if there is a j smaller that i such that dp[j] is true and s.subtring(i,j) is in doctionary,
     *      then dp[i] is breakable
     * */
    public boolean wordBreak(String s, Set<String> wordDict){
        if(wordDict == null || wordDict.isEmpty()) return false;
        if(s == null || s.isEmpty()) return false;
        int len = s.length();
        boolean dp[] = new boolean[len+1];
        dp[0] = true;
        for(int i = 1; i<=len; i++){
            for(int j = 0; j <i; j++){
                if(dp[j] == true && wordDict.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }
}