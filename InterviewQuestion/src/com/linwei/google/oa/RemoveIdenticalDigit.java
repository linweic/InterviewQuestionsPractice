package com.linwei.google.oa;

import java.util.ArrayList;
import java.util.List;

public class RemoveIdenticalDigit {
	public static int solution(int x){
		String string = String.valueOf(x);
		String max = new String();
		//store the first position of the identical group
		List<Integer> repeatPosition = new ArrayList<Integer>();
		int i = 0;
		int j = i+1;
		while(j<string.length()){
			if(string.charAt(j) == string.charAt(i)){
				j++;
			}
			else{
				if((j-i)>1){
					//string[i] is the start of an identical group of digits
					repeatPosition.add(i);
				}
				i = j;
				j++;
			}
		}
		for(int position : repeatPosition){
			//NOTE: use stringbuiler to delete character! String is immutable!
			StringBuilder sb = new StringBuilder(string);
			sb.deleteCharAt(position);
			if(sb.toString().compareTo(max) > 0){
				max = sb.toString();
			}
		}
		return Integer.valueOf(max);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(223336226));
	}

}
