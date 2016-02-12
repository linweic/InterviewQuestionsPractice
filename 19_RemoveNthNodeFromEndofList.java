public class Solution {
    //reverse the list first
    //point to the node to be deleted, the node previous to it, the node next to it
    //delete
    //reverse back
    //pay attention to handle some corner cases!
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;
        if(n == 0) return head;
        ListNode newhead = reverse(head);
        if(n == 1){
            ListNode next = newhead.next;
            newhead.next = null;
            return reverse(next);
        }
        ListNode prev = newhead;
        for(int i = 1;i<n-1;i++){
            prev = prev.next;
            if(prev == null) return head; //no node to be deleted
        }
        ListNode target = prev.next;
        if(target == null) return head;// no node to be deleted
        ListNode next = target.next;
        target.next = null;
        prev.next = next;
        return reverse(newhead);
    }
    private ListNode reverse(ListNode head){
        if(head == null) return null;
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = null;
        while(cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}