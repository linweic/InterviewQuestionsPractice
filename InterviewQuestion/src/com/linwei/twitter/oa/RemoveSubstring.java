package com.linwei.twitter.oa;

public class RemoveSubstring {
	public static int countSubstring(String s, String t){
		int len = s.length();
		int count = 0;
		while(!s.isEmpty()){
			s = s.replaceFirst(t, "");
			//System.out.println(s);
			if(s.length() < len){
				//There is a substring being deleted.
				count++;
				len = s.length();
			}
			else{
				//no substring t entails in the s anymore
				break;
			}
		}
		return count;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countSubstring("aababb","ab"));
	}

}
