package com.linwei.twitter.oa;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Correlation {
	public static double[] computeCorrelation(int students, int[][] input){
        int[] Mscores = new int[students];
        int[] Pscores = new int[students];
        int[] Cscores = new int[students];
        for(int i = 0; i< students; i++){
            Mscores[i] = input[i][0];
        }
        for(int i = 0; i< students; i++){
            Pscores[i] = input[i][1];
        }
        for(int i = 0; i< students; i++){
            Cscores[i] = input[i][2];
        }
        double coMP = computeCorrelation(students, Mscores, Pscores);
        double coPC = computeCorrelation(students, Pscores, Cscores);
        double coCM = computeCorrelation(students, Cscores, Mscores);
        double result[] = new double[]{coMP, coPC, coCM};
        return result;
    }
    private static double computeCorrelation(int students, int[] score1, int[] score2){
        int[] product = new int[students];
        for(int i = 0; i<students; i++){
            product[i] = score1[i]*score2[i];
        }
        int numerator = students * getSum(product) - getSum(score1) * getSum(score2);
        double denominator = Math.sqrt(students * getSquareSum(score1) - Math.pow(getSum(score1), 2)) * Math.sqrt(students * getSquareSum(score2) - Math.pow(getSum(score2), 2));
        return (double) numerator / denominator;
    }
    private static int getSum(int[] input){
        int sum = 0;
        for(int i: input) sum+=i;
        return sum;
    }
    private static int getSquareSum(int[] input){
        int sum = 0;
        for(int i: input) sum+= i * i;
        return sum;
    }
    private static double round(double d){
        DecimalFormat df = new DecimalFormat("#.##");
        //df.setRoundingMode(RoundingMode.CEILING);
        return Double.valueOf(df.format(d).toString()).doubleValue();
    }
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        @SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int students = Integer.valueOf(br.readLine()).intValue();
        //System.out.println(students);
        int[][] inputs = new int[students][3];
        for(int i = 0 ; i<students/10000; i++){
            String next = br.readLine();
            //System.out.println(next);
            String strings[] = next.split("\\t");
            for(int j = 0; j<3; j++){
                inputs[i][j] = Integer.valueOf(strings[j]).intValue();
            }
        }
        double[] results = computeCorrelation(students, inputs);
        for(double r: results) System.out.println(r);
        br.close();
	}

}
