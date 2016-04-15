package com.linwei.google.phone;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Arrays;
import java.util.Comparator;

public class MeeingTimeInterval {
	/**
	 * scheduleA: [0,10],[10,15],[13,20]
	 * scheduleB: [0,5], [27,33]
	 * last = 20
	 * [0,5],[0,10],[10,15],[13,20],[27,33]
	 * @param schedule1
	 * @param schedule2
	 * @return
	 */
	public static int getStartTime(int[][] schedule1, int[][] schedule2, int meeting_time){
		Queue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>(){
			public int compare(int[] meeting1, int[] meeting2){
				if(meeting1[0] == meeting2[0]){
					return meeting1[1] - meeting2[1];
				}
				else return meeting1[0] - meeting2[0];
			}
		});
		queue.addAll(Arrays.asList(schedule1));
		queue.addAll(Arrays.asList(schedule2));
		int last = 0;
		while(!queue.isEmpty()){
			int[] cur = queue.poll();
			if(cur[0] - last >= meeting_time){
				return last;
			}
			else last = cur[1];
		}
		return last;
	}
	/*
	public static int getStartTimeInPlace(int[][] schedule1, int[][] schedule2, int meeting_time){
		int last = 0;
		int i = 0, j = 0;
		int len1 = schedule1.length;
		int len2 = schedule2.length;
		while(i != len1 || j != len2){
			int cmp = compare(schedule1[i], schedule2[j]);
			if(cmp < 0){
				if(schedule1[i][0] - last >= meeting_time) return last;
				else{
					last = schedule1[i][1];
					i++;
				}
			}
			else if(cmp > 0){
				if(schedule2[j][0] - last >= meeting_time) return last;
				else{
					last = schedule2[j][1];
					j++;
				}
			}
			else{
				if(schedule1[i][0] - last >= meeting_time) return last;
				else{
					last = schedule1[i][1];
				}
			}
		}
	}
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] schedule1 = new int[][]{
			{0,10},{10,15},{13,20}
		};
		int[][] schedule2 = new int[][]{
			{0,5},{27,33}
		};
		int meeting_time = 5;
		System.out.println(getStartTime(schedule1, schedule2, meeting_time));
	}

}
