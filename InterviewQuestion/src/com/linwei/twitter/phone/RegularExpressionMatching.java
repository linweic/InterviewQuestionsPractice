package com.linwei.twitter.phone;

public class RegularExpressionMatching {
	public static boolean isMatch(String s, String p) {
        //validate inputs
        if(s == null) return false;
        if(s.isEmpty() && p.isEmpty()) return true;
        if(s.isEmpty() || p.isEmpty()) return false;
        int pLength = p.length();
        int sLength = s.length();
        int[] dp = new int[pLength]; //d[i] denotes the farthest position in s that p[i] covers
        boolean wildcard = false;
        for(int i = 0; i<pLength; i++){
            char pChar = p.charAt(i);
            if(pChar != '.' && pChar != '*'){
                if(i == 0){
                    if(pChar == s.charAt(i)) dp[i] = 0;
                    else if(i < pLength - 1 && p.charAt(i+1) == '*') dp[i] = -1;
                    else return false;
                }
                else{
                    if(p.charAt(i-1) == '*' && p.charAt(i-2) == '.'){
                        int lastMatch = dp[i-2]-1;
                        if(lastMatch == sLength-1) return false;
                        int match = lastMatch;
                        for(int j = lastMatch+1; j<sLength; j++){
                            if(s.charAt(j) == pChar){
                                match = j;
                                break;
                            }
                        }
                        if(match == lastMatch) return false;
                        else dp[i] = match;
                    }
                    else if(p.charAt(i-1) == '*' && p.charAt(i-2) == pChar){
                        dp[i] = dp[i-1];
                    }
                    else if(pChar == s.charAt(dp[i-1]+1)) {
                        dp[i] = dp[i-1]+1;
                    }
                    else if(i<pLength - 1 && p.charAt(i+1) == '*') dp[i] = dp[i-1];
                    else return false;
                }
            }
            else if(pChar == '.'){
                if(i == 0) dp[i] = 0;
                else dp[i] = dp[i-1]+1;
            }
            else if(pChar == '*'){
                if(i == 0) return false;
                if(i == 1 && dp[i-1] == -1) dp[i] = dp[i-1];
                else if(i == 1 && dp[i-1] != -1 && dp[i-1] != '.') dp[i] = matchDuplications(s, dp[i-1]);
                else if(i == 1 && dp[i-1] != -1 && dp[i-1] == '.') dp[i] = sLength-1;
                else{
                    //i starts from 2
                    if(dp[i-1] == dp[i-2]) dp[i] = dp[i-1];
                    else dp[i] = matchDuplications(s, dp[i-1]);
                }
                wildcard = true;
            }
            if(dp[i]>=sLength && p.charAt(i+1) != '*') return false;
            if(dp[i] == sLength-1 && i<pLength - 1 && p.charAt(i+1) != '*' && p.charAt(i) != '*') return false;
            System.out.print(i+": ");
            for(int n: dp) System.out.print(n + " ");
            System.out.println();
        }
        if(dp[pLength-1] < sLength-1) return false;
        return true;
    }
    private static int matchDuplications(String string , int from){
        int len = string.length();
        int to = from;
        if(from == len - 1) return from;
        else{
            for(int i = from+1; i<len; i++){
                if(string.charAt(i) == string.charAt(from)) to++;
                else break;
            }
            return to;
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		isMatch("aaa", "ab*a*c*a");
	}

}
