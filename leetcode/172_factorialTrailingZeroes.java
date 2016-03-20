public class Solution {
    public int trailingZeroes(int n) {
        if(n == 0) return 0;
        //Calculate the number of factors of 5 in the factorial of N
        //If a factor is power of 5, then the result has x more trailing 0's, where x is the exponent of 5 minus-1
        
        long divisor = 5;
        int count = 0;
        while(n/divisor > 0){
            count += (n/divisor);
            divisor*= 5;
        }
        return count;
    }
}