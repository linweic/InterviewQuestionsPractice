public class Solution {
    //iterative method:
    //build 3 pointers pointing to prev, cur, next starting from the head
    //in every iteration change the cur.next to the previous node, 
    //then shift the three pointers to the right by one node until cur points to null
    //fix the head and return
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;
        while(cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        head = pre;
        return head;
    }

    //recursive method:
    //mark first node and second node, thus the second node represents the rest of the list 
    //recursively call reverse method on the rest of the list to reverse it,
    // mark the last node of the original list when reverse method reaches the end
    // after reverse method returns, point the second node to the first node, point the first node to null
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;
        ListNode rest = head.next;
        ListNode newhead = reverseList(rest);
        rest.next = head;
        head.next = null;
        return newhead;
    }
}