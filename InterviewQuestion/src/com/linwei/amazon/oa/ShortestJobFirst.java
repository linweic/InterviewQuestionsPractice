package com.linwei.amazon.oa;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class ShortestJobFirst {
	/**
	 * Use a priority queue to store process object, pop out the shortest one.
	 * If the queue is empty: 
	 * 		Forward current time to nearest arrival time in the future. Execute the process immediately.
	 * 		After execution, if there are any process arriving before this time, put them in the queue.
	 * If the queue is not empty:
	 * 		Pop up a process from the queue, update wait time. 
	 * 		Then update current time. If any process arrives before current time, put them in the queue.
	 * Repeat above two steps until all the jobs are done. Return average waiting time.
	 * @param request
	 * @param duration
	 * @return
	 */
	public static float SJFaverage(int[] request, int[] duration){
		if(request == null || duration == null){
			return 0;
		}
		if(request.length == 0) return 0;
		
		Queue<Process> queue = new PriorityQueue<Process>(request.length, new Comparator<Process>(){
			public int compare(Process p1, Process p2){
				//note: compare duration time, not arrival time!!
				return (p1.duration - p2.duration);
			}
		});//TODO: Interface, PriorityQueue, Queue API, anonymous class, comparator and comparable
		int cur_time = 0;
		int wait_time = 0;
		int next_index = 0;
		int count = 0;
		while(count<request.length){
			if(queue.isEmpty()){
				cur_time = request[next_index];
				queue.add(new Process(request[next_index], duration[next_index]));
				next_index++;
			}
			else{
				Process cur = queue.poll();
				printProcess(cur);
				wait_time += cur_time - cur.arrival; // update wait time
				cur_time += cur.duration; //update current time
				while(next_index < request.length && request[next_index]<= cur_time){
					queue.add(new Process(request[next_index], duration[next_index]));
					next_index++;
				}
				count++;
			}
		}
		return (float)wait_time/count; //TODO: primitive data type, cast
		
	}
	private static class Process{
		int arrival;
		int duration;
		public Process(int a, int d){
			arrival = a;
			duration = d;
		}
	}
	private static void printProcess(Process p){
		System.out.println("Process: "+ p.arrival + " "+ p.duration);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arrival[] = {0,2,4,15};
		int run[] = {7,4,1,1};
		//int q = 2;
		float avg_wait = ShortestJobFirst.SJFaverage(arrival, run);
		System.out.println(avg_wait);
		
		int arrival2[] = {0,1,3,9};
		int run2[] = {2,1,7,5};
		//int q = 2;
		float avg_wait2 = ShortestJobFirst.SJFaverage(arrival2, run2);
		System.out.println(avg_wait2);
		
		//System.out.println(calculateAverageTime(arrival, run));
		//System.out.println(calculateAverageTime(arrival2, run2));
	}

}
