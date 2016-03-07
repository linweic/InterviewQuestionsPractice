public class LRUCache {
    /**
     * implemented a bi-directied linkedlist by myself,
     * also used extra head and rear nodes as sentinels to remove nodes in the end and insert node in the front
     * */
    private class ListNode{
        int key;
        int val;
        ListNode next;
        ListNode prev;
        public ListNode(int key, int val){
            this.key = key;
            this.val = val;
            prev = null;
            next = null;
        }
    }
    int capacity;
    int count;
    ListNode head;
    ListNode rear;
    Map<Integer, ListNode> map;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        count = 0;//queue is empty
        head = new ListNode(-1, -1);
        rear = new ListNode(-1, -1);
        head.next = rear;
        rear.prev = head;
        map = new HashMap<Integer, ListNode>();
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            ListNode node = map.get(key);
            //move the node to the front
            if(node.prev!=head){
                detach(node);
                enqueue(node);
            }
            //return the value
            return node.val;
        }
        else{
            return -1;
        }
    }
    
    public void set(int key, int value) {
        if(map.containsKey(key)){
            ListNode node = map.get(key);
            node.val = value;
            map.put(key,node);
            if(node.prev!=head){
                detach(node);
                enqueue(node);
            }
            return;
        }
        ListNode node = new ListNode(key, value);
        //first check if queue is full
        if(count == capacity){
            //If the queue is full, dequeue the rear node
            map.remove(rear.prev.key);
            detach(rear.prev);
            //insert new node in the front
            enqueue(node);
            map.put(key, node);
        }
        else{
        //If the queue is not full
        //insert new node in the front, update count
            enqueue(node);
            map.put(key, node);
        }
    }
    private void enqueue(ListNode node){
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
        count++;
    }
    private void detach(ListNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        count--;
    }
}