public class Solution {
    //find the middle node of the list
    //reverse the first half
    //if the length of list is odd, compare two sublist (second node of reversed list and next node to the middle node in original list)
    //if the length of list is even, compare two sublist (reversed list and next node to the middle node in original list )
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        if(head.next == null) return true;
        boolean iseven;
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next !=null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        //determine odd or even
        if(fast.next == null) iseven = false;
        else iseven =true;
        ListNode second = slow.next;
        reverseList(head, slow);
        if(iseven == false) return compare(slow.next, second);
        else return compare(slow, second);
    }
    private void reverseList(ListNode head, ListNode end){
        if(head == end) {
            end.next = null;
            return;
        }
        ListNode rest = head.next;
        head.next = null;
        reverseList(rest, end);
        rest.next = head;
        return;
    }
    private boolean compare(ListNode node1, ListNode node2){
        while(node1 != null && node2 != null){
            if(node1.val == node2.val){
                node1 = node1.next;
                node2 = node2.next;
            }
            else return false;
        }
        return true;
    }
}