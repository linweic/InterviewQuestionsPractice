package com.linwei.amazon.oa;

public class InsertCycleLinkedList {
	public static class CNode {
		int val;
		CNode next;
		CNode(int x) {
		val = x;
		}
	}
	/**
	 * Couple of things to note:
	 * 		1, myList may not be the smallest list
	 * 		2, duplicates could exist
	 * Compare mylist.val and n:
	 * If n is larger, then we need to find a place after mylist to insert n,
	 * Use two pointers (cur, pre) to track the list, note that if cur.next.val < cur.val, then cur is the max node
	 * 		If the max node is smaller than n, then insert n after max node
	 * 		If the there is a node that cur pointing to is larger than n, then insert n between pre and cur
	 * If n is smaller than mylist.val, then n must be inserted before mylist
	 * 		First find the smallest node (next to max node), then use two pointers to find correct position to insert n.
	 * Corner Case:
	 * 		Empty List: If the list is empty, DO NOT return null, should return the new CNode(with next pointing to itself)!!!
	 * 		List with one node: treat independently
	 * @param myList
	 * @param n
	 * @return
	 */
	public static CNode insert(CNode myList, int n){
		CNode newNode = new CNode(n);
		if(myList == null){
			newNode.next = newNode;
			return newNode;
		}
		int cmp = myList.val - n;
		if(cmp == 0){//insert n after myList
			CNode next = myList.next;
			insertHelper(myList, next, newNode);
			return myList;
		}
		else if(cmp < 0){//n is larger than myList.val, insert n after myList
			CNode cur = myList.next;
			if(cur == myList){//only one node in the list
				myList.next = newNode;
				newNode.next = myList;
				return myList;
			}
			CNode pre = myList;
			while(pre.val <= cur.val){
				if(cur.val >= n){
					insertHelper(pre, cur, newNode);
					return myList;
				}
				else{
					cur = cur.next;
					pre = pre.next;
				}
			}
			insertHelper(pre, cur, newNode);
			return myList;
		}
		else{//n is smaller than myList.val, insert n before myList(after the smallest Node)
			CNode cur = myList.next;
			if(cur == myList){// only one node in the list
				newNode.next = cur;
				cur.next = newNode;
				return myList;
			}
			CNode pre = myList;
			while(pre.val <= cur.val){
				cur = cur.next;
				pre = pre.next;
			}
			CNode smallest = cur;
			if(n < smallest.val){
				insertHelper(pre,smallest, newNode);
				return myList;
			}
			else{
				cur = smallest.next;
				pre = smallest;
				while(cur.val < n){
					cur = cur.next;
					pre = pre.next;
				}
				insertHelper(pre, cur, newNode);
				return myList;
			}
			
		}
	}
	private static void insertHelper(CNode pre, CNode cur, CNode n_node){
		pre.next = n_node;
		n_node.next = cur;
	}
	private static void printLinkedList(CNode node){
		if(node == null) return;
		CNode cur = node.next;
		if(cur == node) {
			System.out.println(cur.val);
			return;
		}
		CNode pre = node;
		while(pre.val <= cur.val){
			pre = pre.next;
			cur = cur.next;
		}
		CNode smallest = cur;
		CNode largest = pre;
		while(cur.next != smallest){
			System.out.print(cur.val + "\t");
			cur = cur.next;
		}
		System.out.println(cur.val);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int[]{12, 56, 2, 11, 1, 90,1,56};
        int i;
        /* start with empty linked list */
        CNode temp = null;
 
        /* Create linked list from the array arr[].
         Created linked list will be 1->2->11->56->90 */
        for (i = 0; i < arr.length; i++) {
            //temp = new CNode(arr[i]);
            temp = InsertCycleLinkedList.insert(temp, arr[i]);
            //System.out.print("temp val is "+ temp.val + ":");
            InsertCycleLinkedList.printLinkedList(temp);
        }
	}

}
