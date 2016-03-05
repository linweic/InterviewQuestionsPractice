package com.linwei.amazon.oa;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPoints {
	class CPoint{
		int x;
		int y;
		public CPoint(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	public static CPoint[] findClose1(CPoint[] arr, int k){
		CPoint result[] = new CPoint[k];
		if(arr == null) return null;
		else if(k == 0) return result;
		else if(arr.length <= k) return arr;
		PriorityQueue<CPoint> minHeap = new PriorityQueue<CPoint>(arr.length,
				new Comparator<CPoint>(){
			public int compare(CPoint p1, CPoint p2){
				double dist1 = p1.x * p1.x + p1.y * p1.y;
				double dist2 = p2.x * p2.x + p2.y * p2.y;
				double delta = dist1 - dist2;
				if(delta > 0) return 1;
				else if(delta == 0) return 0;
				else return -1;
			}
		});
		for(int i = 0; i<arr.length; i++){
			minHeap.offer(arr[i]);
		}
		for(int i = 0; i< k; i++){
			result[i] = minHeap.poll();
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
