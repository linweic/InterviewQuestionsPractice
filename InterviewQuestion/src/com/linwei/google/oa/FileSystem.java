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
	//static int offset;
	public static int solution(String string){
		constructFileMap(string);
		StringBuilder result = new StringBuilder();
		for(String node : map.get("root")){
			StringBuilder path = new StringBuilder();
			dfs(node, path, result);
		}
		System.out.println(result);
		return result.length();
	}
	private static void constructFileMap(String string){
		map = new HashMap<String, List<String>>();
		int offset = 0;
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
		/*
		for(String s : map.keySet()){
			System.out.println(s + " " + map.get(s));
		}
		*/
	}
	private static void dfs(String node, StringBuilder path, StringBuilder result){
		StringBuilder curpath = new StringBuilder();
		curpath.append(path).append("/").append(node);
		List<String> subNodes = map.get(node);
		if(subNodes == null) return;
		boolean checked = false;//indicate whether we have found a picture in this fold
		for(String subNode: subNodes){
			if((subNode.endsWith(".jpeg")||subNode.endsWith(".png")||subNode.endsWith(".gif")) && checked == false){
				//System.out.println(subNode);
				result.append(curpath);
				checked = true;
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
	/**
	 * use tree to construct file system
	 * @author linweic
	 *
	 */
	public static int solution2(String string){
		TreeNode root = constructFileTree(string);
		StringBuilder result = new StringBuilder();
		for(TreeNode node : root.children){
			StringBuilder path = new StringBuilder();
			dfs(node, path, result);
		}
		return result.length();
	}
	private static class TreeNode{
		String name;
		List<TreeNode> children;
		public TreeNode(String name){
			this.name = name;
			children = new ArrayList<TreeNode>();
		}
	}
	private static TreeNode constructFileTree(String string){
		int offset = 0;
		String parent = new String("root");
		String strings[] = string.split("\n");
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode root = new TreeNode(parent);
		stack.push(root);
		//TreeNode cur = root;
		root.children.add(new TreeNode(strings[0]));
		for(int i = 1; i<strings.length; i++){
			int leadingspace = strings[i].length() - strings[i].trim().length();
			if(leadingspace > offset){
				offset = leadingspace;
				parent = strings[i-1].trim();
				//TreeNode cur = new TreeNode(parent);
				TreeNode cur = stack.peek();
				for(TreeNode node : cur.children){
					if(node.name.equals(parent)){
						stack.push(node);
					}
				}
			}
			else if(leadingspace < offset){
				for(int j = offset - leadingspace; j>0; j--){
					stack.pop();
				}
				offset = leadingspace;
			}	
			stack.peek().children.add(new TreeNode(strings[i].trim()));
		}
		printTree(root);
		//printChildren(root.children.get(0));
		return root;
	}
	private static void printTree(TreeNode root){
		if(root.children.isEmpty()) return;
		printChildren(root);
		for(TreeNode node : root.children){
			printTree(node);
		}
	}
	private static void printChildren(TreeNode root){
		System.out.print(root.name+": ");
		for(TreeNode node : root.children){
			System.out.print(node.name+" ");
		}
		System.out.println();
	}
	private static void dfs(TreeNode node, StringBuilder path, StringBuilder result){
		StringBuilder curPath = new StringBuilder();
		curPath.append(path).append("/").append(node.name);
		if(node.children.isEmpty()) return;
		boolean checked = false;
		for(TreeNode subnode : node.children){
			if((subnode.name.endsWith(".jpeg")||subnode.name.endsWith(".png")||subnode.name.endsWith(".gif"))
					&& checked == false){
						result.append(curPath);
					}
			else{
				if(subnode.name.endsWith(".(\\w)+")){
					continue;
				}
				else{
					dfs(subnode, curPath, result);
				}
			}
				
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "dir1\n dir11\n dir12\n  picture.jpeg\n  dir121\n   file3.png\n  file1.txt\ndir2\n file2.gif";
		System.out.println(solution(s));
		System.out.println(solution2(s));
		//String s1 = "a\n b\n c\n d\ne\n f\n g\n  h\n i\n";
		//System.out.println(solution(s1));
	}

}
