package com.linwei.amazon.oa;

import java.util.LinkedList;
import java.util.Queue;

public class RoundRobin_prac {
	/**
	 * Use a queue to store each incoming job in the order of arrival time.
	 * If a job has used up its quantum and has not finished, move it back to the end of queue with its new arrival time and execution time.
	 * In each loop, get a job from the head of queue to execute.
	 * Update current time whenever CPU finishes executing a job (this could be either the end of quantum or the end of execution time).
	 * The wait time in total would be the current time minus the arrival time of the job in queue.
	 * @param arrival
	 * @param run
	 * @param q
	 * @return
	 */
	public static float waitingTimeRobin(int[] arrival, int[] run, int q){
		if(arrival == null || run == null || arrival.length == 0 || run.length == 0) return 0;
		if(q<=0) return Integer.MAX_VALUE;
		int num = arrival.length;
		int cur_time = 0;
		int wait_time = 0;
		int next_index = 0;
		int count = 0; //count the number of jobs that are finished
		Queue<Process> queue = new LinkedList<Process>();
		while(count < num){
			if(queue.isEmpty()){
				cur_time = arrival[next_index];
				queue.add(new Process(arrival[next_index], run[next_index])); //add next job in the queue
				next_index++;
			}
			else{
				Process curJob = queue.poll();
				wait_time += cur_time - curJob.arrival_time; // add the amount of time that cur job takes to wait to wait_time
				cur_time += Math.min(q, curJob.run_time); //update cur time when finished the job
				//If there are any jobs arrive before this current time, add them to the queue.
				while(next_index < num){
					if(arrival[next_index]<=cur_time){
						queue.add(new Process(arrival[next_index], run[next_index]));
						next_index++;
					}
					else break;
				}
				//now if the cur job has not completely finished yet, update its variables and put it back to the end of the queue
				if(q<curJob.run_time){
					curJob.setArrivalTime(cur_time);
					curJob.setRunTime(curJob.run_time - q);
					queue.add(curJob);
				}
				else count++;
			}
		}
		//After all the jobs have been finished, return average waiting time
		return (float) wait_time/num;
	}
	private static class Process{
		int arrival_time;
		int run_time;
		public Process(int arrival, int run){
			arrival_time = arrival;
			run_time = run;
		}
		public void setArrivalTime(int arrival){
			arrival_time = arrival;
		}
		public void setRunTime(int run){
			run_time = run;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arrival[] = {0,1,3,9};
		int run[] = {2,1,7, 5};
		int q = 2;
		float avg_wait = RoundRobin_prac.waitingTimeRobin(arrival, run, q);
		System.out.println(avg_wait);
	}

}
