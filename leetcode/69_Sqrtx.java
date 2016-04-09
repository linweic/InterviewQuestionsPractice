public class Solution {
    /**
     * Binary Search Algorithm
     * */
    public int mySqrt(int x) {
        int lo = 1, hi = x;
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            if(mid == x/mid) return mid;
            else if(mid < x/mid) lo = mid+1;
            else hi = mid-1;
        }
        return hi;
    }
}