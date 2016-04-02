package com.linwei.google.oa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class FileSystem {
	/**
	 * use hashmap to store parent dir and the list of files/directories in the parent dir
	 * a root directory is the parent directory of all directories
	 * use dfs to find image files and get the path
	 * @param string
	 * @return
	 */
	static Map<String, List<String>> map;
	static int offset;
	public static int solution(String string){
		constructFileTree(string);
		StringBuilder result = new StringBuilder();
		for(String node : map.get("root")){
			StringBuilder path = new StringBuilder();
			dfs(node, path, result);
		}
		System.out.println(result);
		return result.length();
	}
	private static void constructFileTree(String string){
		map = new HashMap<String, List<String>>();
		offset = 0;
		Stack<String> stack = new Stack<String>();
		String parent = new String("root");
		stack.push(parent);
		String strings[] = string.split("\n");
		map.put("root", new ArrayList<String>());
		map.get("root").add(strings[0]);
		for(int i = 1; i<strings.length; i++){
			//System.out.println(strings[i].trim());
			int leadingspace = strings[i].length() - strings[i].trim().length();
			if(leadingspace > offset){
				offset = leadingspace;
				stack.push(strings[i-1].trim());
			}
			else if(leadingspace < offset){
				for(int j = offset - leadingspace; j > 0; j--){
					stack.pop();
				}
				offset = leadingspace;
			}
			parent = stack.peek();
			if(map.get(parent) == null){
				map.put(parent, new ArrayList<String>());
			}
			map.get(parent).add(strings[i].trim());
		}
		for(String s : map.keySet()){
			System.out.println(s + " " + map.get(s));
		}
	}
	private static void dfs(String node, StringBuilder path, StringBuilder result){
		StringBuilder curpath = new StringBuilder();
		curpath.append(path).append("/").append(node);
		List<String> subNodes = map.get(node);
		if(subNodes == null) return;
		for(String subNode: subNodes){
			if(subNode.endsWith(".jpeg")||subNode.endsWith(".png")||subNode.endsWith(".gif")){
				System.out.println(subNode);
				result.append(curpath);
				return;
			}
			else{
				if(subNode.endsWith(".(\\w)+")){
					continue;
				}
				else{
					dfs(subNode, curpath, result);
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "dir1\n dir11\n dir12\n  picture.jpeg\n  dir121\n  file1.txt\ndir2\n file2.gif";
		System.out.println(solution(s));
		String s1 = "a\n b\n c\n d\ne\n f\n g\n  h\n i\n";
		System.out.println(solution(s1));
	}

}
