package com.linwei.google.phone;

public class Sqrt {
    public static int mySqrt(int x) {
        int lo = 1, hi = x;
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            System.out.println("lo:" + lo + " mid:"+ mid + " hi:" + hi);
            if(mid == x/mid) return mid;
            else if(mid < x/mid) lo = mid+1;
            else hi = mid-1;
        }
        return hi;
    }
    public static double mySqrt(double x, double precision){
    	double lo, hi;
    	if(x < 1) {
    		lo = x;
    		hi = 1;
    	}
    	else{
    		lo = 1; 
    		hi = x;
    	}
    	while(lo<=hi-precision){
            double mid = lo + (hi - lo)/2;
            System.out.println("lo:" + lo + " mid:"+ mid + " hi:" + hi);
            if(mid == x/mid) return mid;
            else if(mid < x/mid) lo = mid+precision;
            else hi = mid-precision;
        }
        return hi;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 15;
		double y = 6.25;
		System.out.println(mySqrt(y, 0.001));
	}

}
