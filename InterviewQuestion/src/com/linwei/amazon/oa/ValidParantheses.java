package com.linwei.amazon.oa;

import java.util.Stack;

public class ValidParantheses {
	public static int countValid(String str){
		if(str == null || str.length() == 0){
			return -1;
		}
		char charArr[] = str.toCharArray();
		Stack<Character> stack = new Stack<Character>();
		int count = 0;
		for(int i = 0; i<str.length(); i++){
			if(charArr[i] == '(' || charArr[i] == '[' || charArr[i] == '{'){
				stack.push(charArr[i]);
			}
			else if(charArr[i] == ')'){
				if(stack.isEmpty() == true) return -1;
				char left = stack.pop();
				if(left == '(') count++;
				else return -1;
			}
			else if(charArr[i] == ']'){
				if(stack.isEmpty() == true) return -1;
				char left = stack.pop();
				if(left == '[') count++;
				else return -1;
			}
			else if(charArr[i] == '}'){
				if(stack.isEmpty() == true) return -1;
				char left = stack.pop();
				if(left == '{') count++;
				else return -1;
			}
		}
		if(!stack.isEmpty()) return -1;
		else return count;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(ValidParantheses.countValid("{([()])}"));
	}

}
