public class Solution {
    /**
     * the key information is sorted!!
     * The code is self-explanatory.
     * credit to: https://leetcode.com/discuss/37323/3-line-java-recursive-solution
    **/
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        head.next = deleteDuplicates(head.next);
        if(head.val == head.next.val) return head.next;
        else return head;
    }
}