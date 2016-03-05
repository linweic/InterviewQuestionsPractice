package com.linwei.amazon.oa;

import com.linwei.amazon.util.ListNode;

public class MergeTwoLinkedLists {
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2){
		ListNode head = new ListNode(0);
		ListNode cur = head;
		while(l1 != null && l2 != null){
			int cmp = l1.val - l2.val;
			if(cmp <= 0){
				cur.next = l1;
				l1 = l1.next;
				cur = cur.next;
			}
			else {
				cur.next = l2;
				l2 = l2.next;
				cur = cur.next;
			}
		}
		if(l1 == null) cur.next = l2;
		else cur.next = l1;
		return head.next;
	}
	private static void printList(ListNode l){
		while(l != null){
			System.out.print(l.val + " ");
			l = l.next;
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(1);
		ListNode cur1 = l1;
		for(int i = 1; i<5;i++){
			cur1.next = new ListNode(i+2);
			cur1 = cur1.next;
		}
		ListNode l2 = new ListNode(2);
		ListNode cur2 = l2;
		for(int i = 2; i<5;i++){
			cur2.next = new ListNode(i+2);
			cur2 = cur2.next;
		}
		MergeTwoLinkedLists.printList(l1);
		MergeTwoLinkedLists.printList(l2);
		ListNode l3 = MergeTwoLinkedLists.mergeTwoLists(l1, l2);
		MergeTwoLinkedLists.printList(l3);
	}

}
