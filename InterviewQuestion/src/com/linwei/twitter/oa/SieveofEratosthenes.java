package com.linwei.twitter.oa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * An algorithm to find all the primes less than a given number.
 * Variant: Wilson's Theorem
 * @author linweic
 *
 */
public class SieveofEratosthenes {
	public static List<Integer> getPrimes(int n){
        boolean isPrime[] = new boolean[n+1];
        Arrays.fill(isPrime, true);
        List<Integer> list = new ArrayList<Integer>();
        isPrime[0] = false;
        isPrime[1] = false;
        int divisor = 2;
        while(divisor <= Math.sqrt(n)){
            for(int i = divisor+1; i<n+1; i++){
                if(isPrime[i] == false){
                    //if i is not prime already, pass it
                    continue;
                }
                else{
                    //check if i can be divided by divisor, if yes, cross it off
                    if((i % divisor) == 0) isPrime[i] = false;
                }
            }
            //update divisor as the next number which is not prime
            for(int i = divisor+1; i<n+1; i++){
                if(isPrime[i] == true) {
                    divisor = i;
                    break;
                }
            }
        }
        for(int i = 2; i<n+1; i++){
            if(isPrime[i] == true) list.add(i);
        }
        /*
        String strings[] = new String[]{"abc", "def", "ghi", "jkl", "ghj", "abc"};
        Arrays.sort(strings);
        for(String string: strings) System.out.println(string);
        */
        return list;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		for(int i = 0; i< num; i++){
		    System.out.println(getPrimes(scanner.nextInt()));
		}
		scanner.close();
	}

}
