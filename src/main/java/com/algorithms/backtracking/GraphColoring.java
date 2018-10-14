package com.algorithms.backtracking;

public class GraphColoring {

	public void graphColoringLauncher(int[][] adjMatrix, int m) {
		int[] result = new int[adjMatrix.length];
		for(int i=0; i<result.length; i++) {
			result[i] = -1;
		}
		
		if(graphColoringRecursiveUtil(adjMatrix, m, result, 0)){
			for(int i: result) {
				System.out.print(i + " ");
			}
		} else {
			System.out.println("false");
		}
	}
	
	public boolean graphColoringRecursiveUtil(int[][] adjMatrix, int m, int[] result, int currentVertex) {
		if(currentVertex == result.length) {
			return true;
		}
		
		for(int i=0; i<m; i++) {
			if(isValid(adjMatrix, result, currentVertex, i)) {
				result[currentVertex] = i;
				if(graphColoringRecursiveUtil(adjMatrix, m, result, currentVertex + 1)) {
					return true;
				} else {
					result[currentVertex] = -1;	
				}
			}
		}
		
		return false;
	}
	
	public boolean isValid(int[][] adjMatrix, int[] result, int currentVertex, int color) {
		for(int i=0; i<adjMatrix.length; i++) {
			if(adjMatrix[currentVertex][i] == 1 && result[i] == color) {
				return false;
			}
		}
		for(int i=0; i<adjMatrix.length; i++) {
			if(adjMatrix[i][currentVertex] == 1 && result[i] == color) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		int V = 4;
		//int[][] adjMatrix = new int[V][V];
		int[][] adjMatrix = {
				{0, 1, 1, 1},
				{1, 0, 1, 0},
				{1, 1, 0, 1},
				{1, 0, 1, 0}};
		int m = 3;
		
		GraphColoring g = new GraphColoring();
		g.graphColoringLauncher(adjMatrix, m);
	}
}