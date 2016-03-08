package com.linwei.amazon.oa;

public class FindPathinMaze {
	static int[][] visited;
	public static boolean maze(int[][] grid){
		if(grid == null) return false;
		int row = grid.length;
		int col = grid[0].length;
		if(row == 0 || col == 0) return false;
		visited = new int[row][col];
		int i=0, j=0;
		return dfs(grid, visited, i, j, row, col);
	}
	private static boolean dfs(int[][] grid, int[][] visited, int i, int j, int row, int col){
		if(0<=i && i<row && 0<=j && j<col && grid[i][j] == 9) {
			visited[i][j] = 1;
			return true;
		}
		if(isSafe(grid, visited, i, j, row, col)){
			visited[i][j] = 1;
			if(dfs(grid, visited, i-1, j, row, col)) return true;
			if(dfs(grid, visited, i+1, j, row, col)) return true;
			if(dfs(grid, visited, i, j-1, row, col)) return true;
			if(dfs(grid, visited, i, j+1, row, col)) return true;
			//if none of the directions can get to the destination un-mark current visit point
			visited[i][j] = 0;
		}
		return false;
	}
	private static boolean isSafe(int[][] grid, int[][] visited, int i, int j, int row, int col){
		if(0<=i && i<row && 0<=j && j<col && grid[i][j]==1 && visited[i][j] == 0) return true;
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = {
				{1, 1, 1, 1, 0, 0},
				{1, 0, 0, 1, 0, 0},
				{0, 1, 1, 1, 1, 9},
				{0, 1, 0, 1, 0, 0},
				{0, 1, 1, 1, 0, 0}};
		System.out.println(maze(grid));
		for(int i = 0; i< visited.length; i++){
			for(int j = 0; j< visited[0].length; j++){
				System.out.print(visited[i][j]+" ");
			}
			System.out.println();
		}

	}

}
