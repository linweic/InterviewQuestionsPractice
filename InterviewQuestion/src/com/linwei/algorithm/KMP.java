package com.linwei.algorithm;

public class KMP {
	int[][] dfa;
	int stateLen;
	public KMP(String pat){
		stateLen = pat.length();
		dfa = new int[24][stateLen];
		dfa[pat.charAt(0) - 'a'][0] = 1;
		for(int j = 1, X = 0; j <stateLen; j++ ){//X is the state when the suffix [1...j-1] matches
			for(int i = 0; i<24; i++){
				dfa[i][j] = dfa[i][X];//copy the states from match suffix states to current state
			}
			dfa[pat.charAt(j) - 'a'][j] = j+1; //if there is a match move the state forward
			X = dfa[pat.charAt(j) - 'a'][X];
			System.out.println(X);
			for(int m = 0; m<3; m++){
				for(int n = 0; n < stateLen; n++){
					System.out.print(dfa[m][n]+" ");
				}
				System.out.println();
			}
			System.out.println("-----------------------");
		}
	}
	public int matchSubString(String string){
		int i = 0;//the position of the string that has been checked
		int j = 0;//the state in the state machine
		for(i = 0, j = 0; i<string.length(); i++){
			j = dfa[string.charAt(i) - 'a'][j];
			if(j == stateLen) return i - stateLen +1;//j reaches the final state
		}
		return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KMP kmp = new KMP(new String("ababac"));
		System.out.println(kmp.matchSubString("aabacaababacaa"));
	}

}
