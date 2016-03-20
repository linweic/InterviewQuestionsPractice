package com.linwei.twitter.oa;

import java.util.Arrays;

public class FirstNonRepeatChar {
	/**
	 * First sort the char array, then use two pointers to compare each adjacent pair of chars
	 * @param s
	 * @return
	 */
	public static char firstNonRepeat(String s){
		char[] chars = s.toCharArray();
		Arrays.sort(chars);
		int i = 0;// the first occurrence of non-repeated char up to j(not included)
		int j = i+1;
		while(j<chars.length){
			if(chars[i] != chars[j]) break;
			else{
				while(++j<chars.length){
					if(chars[i] != chars[j]){
						i = j;
						j = i+1;
						break;
					}
				}
				if((j - i) > 1) return ' ';
			}
		}
		return chars[i];
	}
	public static void main(String[] args){
		System.out.println(firstNonRepeat("abcdeedbacffacgg"));
	}
}
