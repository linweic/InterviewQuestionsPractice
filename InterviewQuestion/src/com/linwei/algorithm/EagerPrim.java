package com.linwei.algorithm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import com.linwei.util.WeightedEdge;
import com.linwei.util.WeightedGraph;

public class EagerPrim {
	WeightedEdge[] edgeTo;//edgeTo[v]: shortest edge from v to already known MST
	double[] distTo;//distTo[v]: shortest distance from v to already known MST
	List<WeightedEdge> mst;
	boolean[] inTree;
	Queue<Integer> queue;
	//List<WeightedEdge>[] adj;
	
	public void findMST(WeightedGraph g){
		edgeTo = new WeightedEdge[g.V()];
		distTo = new double[g.V()];
		mst = new ArrayList<WeightedEdge>();
		inTree = new boolean[g.V()];
		for(int i = 0; i<g.V(); i++){
			distTo[i] = Integer.MAX_VALUE;
		}
		queue = new PriorityQueue<Integer>(new Comparator<Integer>(){
			public int compare(Integer n1, Integer n2){
				if(distTo[n1]-distTo[n2] < 0) return -1;
				else if(distTo[n1] - distTo[n2] == 0) return 0;
				else return 1;
			}
		});
		distTo[0] = 0.0;//set vertex 0 in the MST automatically as a starting point
		queue.offer(0);
		visit(0, g);
		while(!queue.isEmpty()){
			visit(queue.poll(), g);
		}
	}
	private void visit(int v, WeightedGraph g){
		inTree[v] = true;
		for(WeightedEdge edge: g.adj(v)){
			int w = edge.other(v);
			if(inTree[w]) continue;
			if(edge.weight()<distTo[w]){
				distTo[w] = edge.weight();
				edgeTo[w] =edge;
				if(!queue.contains(w)) {
					queue.offer(w);
				}
				else{
					queue.remove(w);
					queue.offer(w);
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int size = 5;
		int distTo[] = new int[]{1,3,5,6,0};
		String str1 = new String("h");
		String str2 = new String("b");
		String str3 = new String("c");
		String str4 = new String("d");
		String str5 = new String("e");
		Queue<String> queue = new PriorityQueue<String>(new Comparator<String>(){
			public int compare(String s1, String s2){
				return s1.compareTo(s2);
			}
		});
		queue.offer(str1);
		queue.offer(str2);
		queue.offer(str3);
		queue.offer(str4);
		queue.offer(str5);
		System.out.println(queue);
		//distTo[0] = 10;
		//distTo[4] = 0;
		queue.remove(str4);
		System.out.println(queue);
		str4 = new String("a");
		queue.offer(str4);
		System.out.println(queue);
		Queue<Integer> queue1 = new PriorityQueue<Integer>(new Comparator<Integer>(){
			public int compare(Integer n1, Integer n2){
				if(distTo[n1]-distTo[n2] < 0) return -1;
				else if(distTo[n1] - distTo[n2] == 0) return 0;
				else return 1;
			}
		});
		for(int i = 0; i<size; i++){
			queue1.offer(i);
		}
		System.out.println(queue1.peek());
		distTo[4] = 2;
		queue1.remove(4);
		queue1.offer(4);
		System.out.println(queue1.peek());
	}

}
