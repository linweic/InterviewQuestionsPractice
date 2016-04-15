package com.linwei.google.phone;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Comparator;

public class LRUCache {
	LinkedList<Integer> list;//a list of keys in the cache where the least recent used key is in the tail
	Map<Integer, Integer> cache;//<key, value> pairs in the cache
	Queue<Integer> minHeap;//maintain the minimum value
	Queue<Integer> maxHeap;//maintain the maximum value
	int size;
	
	public LRUCache(int cacheSize){
		list = new LinkedList<Integer>();
		cache = new HashMap<Integer, Integer>(cacheSize);
		minHeap = new PriorityQueue<Integer>(new Comparator<Integer>(){
			public int compare(Integer key1, Integer key2){
				int value1 = cache.get(key1);
				int value2 = cache.get(key2);
				return value1-value2;
			}
		});
		maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>(){
			public int compare(Integer key1, Integer key2){
				int value1 = cache.get(key1);
				int value2 = cache.get(key2);
				return value2-value1;
			}
		});
		size = cacheSize;
	}
	/**
	 * If the cache is not full, 
	 * 		put (k,v) pair in the map;
	 * 		put key in the head of the list
	 * 		put key in minheap and maxheap
	 * If the cache is full,
	 * 		remove the least recent key in the tail
	 * 		remove the least recent pair from map
	 * 		remove the least recent key from minheap and maxheap 
	 * 		put (k,v) pair in the map
	 * 		put key in the head of the list
	 * 		put key in the minheap and maxheap
	 * @param key
	 * @param value
	 */
	public void set(int key, int value){
		if(list.size() == size){
			//remove the least recent key from the list
			int leastRecentKey = list.remove(size-1);
			cache.remove(leastRecentKey);
			minHeap.remove(leastRecentKey);
			maxHeap.remove(leastRecentKey);
		}
		cache.put(key, value);
		list.addFirst(key);
		minHeap.offer(key);
		maxHeap.offer(key);
	}
	/**
	 * if the key is in the cache, move it to the head of the list and return value
	 * else return -1
	 * @param key
	 * @return
	 */
	public int get(int key){
		if(list.contains(key)){
			int value = cache.get(key);
			if(list.indexOf(key)!=0){
				list.remove(key);
				list.addFirst(key);
			}
			return value;
		}
		else return -1;
	}
	/**
	 * return the head of the maxHeap, also re-position the key in the list
	 * @return
	 */
	public int getMax(){
		int maxKey = maxHeap.peek();
		int maxValue = cache.get(maxKey);
		if(list.indexOf(maxKey)!=0){
			list.remove(maxKey);
			list.addFirst(maxKey);
		}
		return maxValue;
	}
	public int getMin(){
		int minKey = minHeap.peek();
		int minValue = cache.get(minKey);
		if(list.indexOf(minKey)!=0){
			list.remove(minKey);
			list.addFirst(minKey);
		}
		return minValue;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
