package com.linwei.twitter.oa;

public class Complement {
	public static int get1sComplement(int n){
		int m = 1;
		//int bits = 0;
		if(n >= 0){
			while(m <= n){
				m <<= 1;
			}
			m -= 1;
			return n^m;
		}
		else{
			m = (-1) * (int) Math.pow(2, 31);
			return m ^ n;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(get1sComplement(-1));
	}

}
