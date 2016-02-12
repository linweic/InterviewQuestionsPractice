public class Solution {
    /**
     * starting from the first node,
     * if first node hits, delete directly
     * else 
     *      keep a pointer cur pointing to the next node 
     *      keep anothre pointer prev pointing to the node just checked
     *      if the cur hits, remove cur
     *      if cur points to null, terminate the loop, return the head
     * 
     * Time complx: O(n)
     * Space complx: O(1)
     * */
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return null;
        ListNode cur = head;
        ListNode prev = null;
        while(cur!=null){
            if(cur.val == val){
                if(prev == null){// the node is the first node
                    head = cur.next;
                    cur.next = null;
                    cur = head;
                }
                else{
                    ListNode next = cur.next;
                    cur.next = null;
                    prev.next = next;
                    cur = next;
                }
            }
            else{
                prev = cur;
                cur = cur.next;
            }
        }
        return head;
    }
}