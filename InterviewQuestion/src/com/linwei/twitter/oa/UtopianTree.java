package com.linwei.twitter.oa;

public class UtopianTree {
	public static int getHeight(int n){
        //if(n == 0) return 1;
        int[] dp = new int[n+1];
        //dp[i] denotes the height of tree after i cycles
        dp[0] = 1;
        for(int i = 1; i<n+1; i++){
            if(i % 2 == 1){
                //spring
                dp[i] = 2 * dp[i-1];
            }
            else{
                //summer
                dp[i] = dp[i-1] + 1;
            }
        }
        return dp[n];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getHeight(0));
		System.out.println(getHeight(1));
		System.out.println(getHeight(4));
	}

}
