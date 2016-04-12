package com.linwei.geeksforgeeks;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Comparator;

public class ActivitySelection {
	   /**
	     * use job object to represent each activity
	     * push all jobs into a priority queue which sorts based on each jobs finishing time
	     * initial start time as 0
	     * pull out a job from qp, which is the one finishes most early
	     * check if the start time of the job is after global start time
	     *      if yes, update global start time, increment count
	     *      if no, continue
	     * repeat pulling out jobs from pq until it is empty
	     * output count
	     * */
	    private static class Job{
	        int start;
	        int finish;
	        public Job(int start, int finish){
	            this.start = start;
	            this.finish = finish;
	        }
	    }
	    public static int solution(int[] start, int[] finish){
	        int global_start = 0;
	        int count = 0;
	        Queue<Job> queue = new PriorityQueue<Job>(new Comparator<Job>(){
	            public int compare(Job job1, Job job2){
	                return job1.finish - job2.finish;
	            }
	        });
	        for(int i = 0; i< start.length; i++){
	            queue.offer(new Job(start[i], finish[i]));
	        }
	        while(!queue.isEmpty()){
	            Job cur = queue.poll();
	            if(cur.start < global_start) continue;
	            else{
	                global_start = cur.finish;
	                count++;
	                System.out.println(cur.start+" "+cur.finish);
	            }
	        }
	        return count;
	    }
		public static void main (String[] args) {
			//code
			Scanner scanner = new Scanner(System.in);
			int test_num = scanner.nextInt();
			//System.out.println("test_num:" + test_num);
			int job_num = scanner.nextInt();
			//System.out.println("job_num:"+job_num);
			scanner.nextLine();
			String start_str = scanner.nextLine();
			System.out.println("start string: " + start_str);
			String finish_str = scanner.nextLine();
			System.out.println("finish string: "+finish_str);
			int[] start = new int[job_num];
			int[] finish = new int[job_num];
			String[] starts = start_str.trim().split("(\\s)");
			String[] finishes = finish_str.trim().split("(\\s)");
			for(int i = 0; i<job_num; i++){
			    start[i] = Integer.valueOf(starts[i]);
			    finish[i] = Integer.valueOf(finishes[i]);
			}
			for(int i: start) System.out.print(i+" ");
			System.out.println();
			for(int i: finish) System.out.print(i + " ");
			System.out.println();
			System.out.println(solution(start, finish));
			scanner.close();
		}
	
}
