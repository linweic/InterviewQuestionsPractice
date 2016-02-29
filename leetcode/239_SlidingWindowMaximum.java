public class Solution {
    /**store indices in dequeue, starting from 0 to n-1
    * before insert each index i at the end of the dequeue,
    * 1. remove all the indices smaller than the window left bound
    * 2. remove all the indices whose value it refers to is smaller than a[i]
    * so that in each step, the head of the dequeue always refer to the max value in current window,
    * add the value into result list, repeat the iteration
    * 
    * Time: O(n)
    * Space: O(k)
    * Credit to :https://leetcode.com/discuss/46578/java-o-n-solution-using-deque-with-explanation
    * */
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<Integer>();
        int len = nums.length;
        if(nums == null || len == 0 || k<0) return new int[0];
        int result[] = new int[len-k+1];
        int re_i = 0;
        for(int i = 0; i<len; i++){
            while(!deque.isEmpty() && deque.peekFirst()<i-k+1){
                deque.pollFirst();
            }
            while(!deque.isEmpty() && nums[deque.peekLast()]<nums[i]){
                deque.pollLast();
            }
            deque.offerLast(i);
            if(i>=k-1){
                result[re_i++] = nums[deque.peekFirst()];
            }
        }
        return result;
    }
}