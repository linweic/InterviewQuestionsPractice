package com.linwei.amazon.oa;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LRUCache {
	private static class ListNode{
		int val;
		ListNode pre;
		ListNode next;
		public ListNode(int v){
			val = v;
		}
	}
	static Map<Integer, ListNode> cache;
	static int mcount;
	static int count;
	static ListNode head;
	static ListNode tail;
	public static int missscount(int[] arr, int size){
		cache = new HashMap<Integer, ListNode>();
		mcount = 0;
		count = 0;
		head = new ListNode(-1); 
		tail = new ListNode(-1);
		head.next = tail;
		tail.pre = head;
		for(int i: arr){
			if(!cache.containsKey(i)){ //miss
				ListNode node = new ListNode(i);
				mcount++;
				if(cache.size() == size){
					cache.remove(tail.pre.val);
					remove(tail.pre);
				}
				addToFront(node);
				cache.put(i, node);
			}
			else{
				//hit
				ListNode node = cache.get(i);
				remove(node);
				addToFront(node);
			}
		}
		return mcount;
	}
	private static void remove(ListNode node){
		node.pre.next = node.next;
		node.next.pre = node.pre;
	}
	private static void addToFront(ListNode node){
		node.next = head.next;
		head.next.pre = node;
		head.next = node;
		node.pre = head;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(LRUCache.missscount(new int[]{1,2,3,4,5,4,1,3,4,5,6,7,7,5,4,3,9,10,4}, 10));
	}

}
