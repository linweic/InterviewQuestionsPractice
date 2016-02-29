public class Solution {
    //reverse half of the number
    //if x has even digits, then reversed number should be equal to divided x
    //if x has odd digits, then reversed number/10 should be equal to divided x
    //note corner cases such as negative numbers or numbers ends with 0
    //O(n) time
    public boolean isPalindrome(int x) {
        if(x<0 || (x>0 && x%10 == 0)) return false;
        int rev = 0;
        while(x > rev){
            rev = rev*10 + x%10;
            x = x/10;
        }
        return (x == rev || x == rev/10);
    }
}