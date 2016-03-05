package com.linwei.amazon.oa;

public class LongestPalindrome {
	//Dynamic Programming
	public static String getLongest(String str){
		if(str == null) return null;
        int len = str.length();
        if(len == 0) return new String();
        boolean dp[][] = new boolean[len][len];
        int left = 0;
        int right = 0;
        int max = 0;
        for(int i = 0; i<len; i++){ //right end
            for(int j = i; j>=0;j--){ //left end
                if(str.charAt(i) == str.charAt(j) && ((i-j<2) || (dp[j+1][i-1]==true))){
                    dp[j][i] = true;
                    if(i-j>max){
                        max = i-j;
                        left = j;
                        right = i;
                    }
                }
            }
        }
        return str.substring(left,right+1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String line1 = "1";
		String line2 = "aaaabbaa";
		//int testNum = Integer.valueOf(line1).intValue();
		String sub = LongestPalindrome.getLongest(line2);
		System.out.println(sub);
	}

}
