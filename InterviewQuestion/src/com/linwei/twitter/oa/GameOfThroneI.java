package com.linwei.twitter.oa;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/game-of-thrones
 * @author linweic
 *
 */
public class GameOfThroneI {
    public static boolean isKey(String input){
        int alphabet[] = new int[26];
        int len = input.length();
        for(int i = 0; i<len; i++){
            alphabet[input.charAt(i) - 'a']++;
        }
        if(len %2 == 0){
            //the number of all the characters should be even
            for(int i = 0; i< 26; i++){
                if(alphabet[i]%2 != 0) return false;
            }
            return true;
        }
        else{
            //only one character needs to be odd, others are even
            int oddcount = 0;
            for(int i = 0; i< 26; i++){
                if(alphabet[i]%2 != 0){
                    oddcount++;
                    if(oddcount > 1) return false;
                }
            }
            return true;
        }
    }
    public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in);
        String inputString = myScan.nextLine();
        
        String ans = (isKey(inputString) == true)? "YES" : "NO";
        // Assign ans a value of YES or NO, depending on whether or not inputString satisfies the required condition
        System.out.println(ans);
        myScan.close();
    }
}
