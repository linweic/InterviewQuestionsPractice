package com.linwei.amazon.oa;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RemoveVowel {
	private static String remove(String str){
		Set<Character> set = new HashSet<Character>(Arrays.asList(new Character[]{'a','e','i','o','u',
			'A','E','I','O','U'}));
		int size = str.length();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<size; i++){
			char c = str.charAt(i);
			if(set.contains(c)) continue;
			sb.append(c);
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(RemoveVowel.remove("aheruihfn knmcai"));
	}

}
