package com.linwei.amazon.oa;

public class GreatestCommonDivisor {
	public static int gcd(int x, int y){
		//Euclidean algorithm: gcd(x, y) = gcd(y, x mod y);
		// note that result should always be non-negative
		if(y == 0) return Math.abs(x);
		return gcd( y , x%y);
	}
	public static int gcdMult(int[] nums){
		int res = 0;
		for(int i : nums){
			res = gcd(res, i);
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(GreatestCommonDivisor.gcd(14, -7));
		System.out.println(GreatestCommonDivisor.gcd(10, 0));
		System.out.println(GreatestCommonDivisor.gcd(22, 33));
		System.out.println(GreatestCommonDivisor.gcdMult(new int[]{14,-7,35,42}));
		//System.out.println(GreatestCommonDivisor.getGCD3(new int[]{14,-7,35,42}));
	}

}
