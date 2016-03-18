package com.linwei.clubos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CodeChallenge {
	private static class Edge{
		String page1;
		String page2;
		Set<String> common;
		public Edge(String str1, String str2, String user){
			page1 = str1;
			page2 = str2;
			common = new HashSet<String>();
			common.add(user);
		}
		public List<String> getNodes(){
			List<String> nodes = new ArrayList<String>();
			nodes.add(page1);
			nodes.add(page2);
			return nodes;
		}
		/*
		public String other(String string){
			if(page1.equals(string)) return page2;
			if(page2.equals(string)) return page1;
			else throw new IllegalArgumentException();
		}
		*/
		public String toString(){
			StringBuilder sb = new StringBuilder(page1);
			sb.append(",").append(page2);
			return sb.toString();
		}
		public void addCommonUser(String user){
			common.add(user);
		}
		public int getWeight(){
			return common.size();
		}
	}
	public static String highestAffinity(String logfile){
		String line = null;
		//<user, list of web pages>
		Map<String, List<String>> invertedIndex = new HashMap<String, List<String>>();
		List<Edge> edgePool = new ArrayList<Edge>();
		int max = 0;
		//Edge affinity = null;
		List<Edge> winners = null;
		try{
			FileReader filereader = new FileReader(logfile);
			BufferedReader bufferedreader = new BufferedReader(filereader);
			while((line = bufferedreader.readLine()) != null){
				String[] strings = line.split(",");
				String webPage = strings[0].trim().toLowerCase();
				String user = strings[1].trim().toLowerCase();
				if(invertedIndex.containsKey(user)){
					List<String> adjPages = invertedIndex.get(user);
					for(String adj : adjPages){
						int flag = 0; //indicates if an edge with webPage is in the edge pool
						//traverse all the pages that this user visits, create pair or increment weight
						for(Edge edge : edgePool){
							if(edge.getNodes().contains(webPage) && edge.getNodes().contains(adj)){
								if(!edge.common.contains(user)){
									edge.addCommonUser(user);
								}
								flag = 1;
								break;
							}
						}
						if(flag == 0){
							//add edge into edge pool
							Edge e = new Edge(webPage, adj, user);
							edgePool.add(e);
						}
					}
					adjPages.add(webPage);
				}
				else{
					//new user, add a new entry in the inverted index for the user
					List<String> webPageList = new ArrayList<String>();
					webPageList.add(webPage);
					invertedIndex.put(user, webPageList);
				}
			}
			bufferedreader.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		//calculate edge with highest weight
		for(Edge e: edgePool){
			//System.out.println(e.toString() + " " + e.getWeight());
			if(e.getWeight() > max) {
				winners = new ArrayList<Edge>();
				winners.add(e);
				max = e.getWeight();
			}
			else if(e.getWeight() == max){
				winners.add(e);
			}
		}
		StringBuilder sb = new StringBuilder();
		for(Edge winner: winners){
			sb.append(winner.toString()+ " ");
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(highestAffinity("test.txt"));
	}

}
