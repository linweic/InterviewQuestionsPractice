public class Solution {
    /**
     * Solution 1: stack
     * Iterate through the s,
     *      if current character is '(', push it into stack
     *      if current character is ')',
     *          if stack is empty, the character is invalid, push it into stack
     *          if the stack pops out a ')', invalid either, push it into stack
     *          if the stack pops out a '(', valid, do nothing
     * So far, the stack only contains ill-formed characters.
     * The elements in the stack acts as delimeters of well-formed subsequence.
     * Go through the delimeters to get the longest subsequence.
     * */
    
    public int longestValidParentheses(String s) {
        if(s == null || s.isEmpty()) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i< s.length(); i++){
            if(s.charAt(i) == '(') stack.push(i);
            if(s.charAt(i) == ')'){
                if(stack.isEmpty() || s.charAt(stack.peek()) == ')') stack.push(i);
                else stack.pop();
            }
        }
        //only invalid characters are in the stack
        int max = 0;
        if(stack.isEmpty() == true) return s.length();
        int first = s.length();
        while(!stack.isEmpty()){
            int second = stack.pop();
            max = Math.max(max, first-second-1);
            first = second;
        }
        max = Math.max(max, first - 0);
        return max;
    }
    
    /**
     * Solution : DP
     * */
     public int longestValidParentheses(String s){
         if(s == null || s.isEmpty()) return 0;
         int len = s.length();
         int[] dp = new int[len];//denotes the longest valid sub ending at ith position
         for(int i = 0; i<len; i++){
             char c = s.charAt(i);
             if(c == '(') dp[i] = 0;
             else{
                 //) is not valid when appears at 0
                 if(i == 0) dp[i] = 0;
                 else{
                     char prev = s.charAt(i-1);
                     if(prev == '('){
                         if(i == 1) dp[i] = 2;
                         else{
                             dp[i] = dp[i-2]+2;
                         }
                     }
                     else{// ))
                         int substart = i - dp[i-1];//the starting point cooresponds to i-1
                         if(substart == 0 || s.charAt(substart-1) == ')' ) dp[i] = 0;
                         else if(s.charAt(substart-1) == '(' && substart == 1) dp[i] = dp[i-1] + 2;
                         else{
                             dp[i] = dp[i-1]+2+dp[substart-2];
                         }
                     }
                 }
             }
         }
         int longest = 0;
         for(int i = 0; i<len; i++){
             if(dp[i] > longest) longest = dp[i];
         }
         return longest;
     }
}