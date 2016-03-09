package com.linwei.amazon.oa;

import java.util.Stack;
import java.util.ArrayList;
import java.util.List;

public class MaximumAbsoluteDelta {
	public static boolean[] marked = new boolean[4];
	public static int[] arr;
	public static Graph g;
	public static int max = 0;
	public static Stack<Integer> path;
	public static Stack<Integer> tmpPath = new Stack<Integer>();
	public static Iterable<Integer> reorder(int A, int B, int C, int D){
		arr = new int[]{A,B,C,D};
		g = new Graph(4, arr);
		//List<Integer> res = new ArrayList<Integer>();
		//int max = 0;
		for(int i = 0; i<4;i++){
			dfs(i, 0);
		}
		return path;
	}
	@SuppressWarnings("unchecked")
	private static void dfs(int node, int localmax){
		tmpPath.push(arr[node]);
		marked[node] = true;
		for(Edge e : g.adj[node]){
			int v = e.other(node);
			if(marked[v] == true) continue;
			localmax += e.distance;
			dfs(v, localmax);
		}
		if(localmax > max) path = (Stack<Integer>) tmpPath.clone();
		max = Math.max(max, localmax);
		marked[node] = false;
		tmpPath.pop();
	}
	private static class Edge{
		int v;
		int w;
		int distance;
		public Edge(int v, int w, int distance){
			this.v = v;
			this.w = w;
			this.distance = distance;
		}
		private int other(int m){
			if(v == m) return w;
			if(w == m) return v;
			return -1;
		}
	}
	private static class Graph{
		int v;
		List<Edge>[] adj;
		List<Edge> edges = new ArrayList<Edge>();
		@SuppressWarnings("unchecked")
		public Graph(int v, int[] arr){
			this.v = v;
			adj = (List<Edge>[]) new ArrayList[this.v];
			for(int i = 0; i<v; i++){
				for(int j = i+1; j<v; j++){
					Edge e = new Edge(i, j, Math.abs(arr[i] - arr[j]));
					if(adj[i] == null) adj[i] = new ArrayList<Edge>();
					adj[i].add(e);
					if(adj[j] == null) adj[j] = new ArrayList<Edge>();
					adj[j].add(e);
					
					edges.add(e);
				}
			}
		}
		/*
		public int adjacent(Edge e1, Edge e2){
			if(adj[e1.v].contains(e2)) return e1.v;
			if(adj[e1.w].contains(e2)) return e1.w;
			else return -1;
		}
		*/
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Iterable<Integer> it = reorder(11,20,13,100);
		for(int i : it) System.out.print(i+" ");
	}

}
