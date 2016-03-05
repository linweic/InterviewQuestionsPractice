package com.linwei.amazon.oa;

import com.linwei.amazon.util.ListNode;

public class ReverseSecHalfLinkedList {
	public static ListNode reverSecHalf(ListNode head){
		if(head == null) return null;
		ListNode fast = head;
		ListNode slow = head;
		while(fast.next != null && fast.next.next != null){
			fast = fast.next.next;
			slow = slow.next;
		}
		ListNode secondHalf = slow.next;
		slow.next = reverse(secondHalf);
		return head;
	}
	private static ListNode reverse(ListNode head){
		if(head == null) return null;
		if(head.next == null) return head;
		ListNode rest = head.next;
		head.next = null;
		ListNode newHead = reverse(rest);
		rest.next = head;
		return newHead;
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
		for(int i = 1; i<21;i+=2){
			cur1.next = new ListNode(i+2);
			cur1 = cur1.next;
		}
		ReverseSecHalfLinkedList.printList(l1);
		ReverseSecHalfLinkedList.reverSecHalf(l1);
		ReverseSecHalfLinkedList.printList(l1);
	}

}
