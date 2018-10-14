package com.algorithms.backtracking;

public class RatInMaze {
	
	public void MazeBTLauncher(int[][] matrix, int xPos, int yPos) {
		int[] xOptions = {0, 1};
		int[] yOptions = {1, 0};
		if(MazeBTImpl(matrix, xPos, yPos, xOptions, yOptions)){
			for(int i=0; i<matrix.length; i++) {
				for(int j=0; j<matrix[0].length; j++) {
					System.out.print(matrix[i][j] + " ");
				}
				System.out.println("");
			}
		} else {
			System.out.println("No path found");
		}
	}
	
	public boolean MazeBTImpl(int[][] matrix, int xPos, int yPos, int xOptions[], int yOptions[]) {
		// terminating condition
		if((xPos == matrix.length-1) && (yPos == matrix[0].length-1)) {
			return true;
		}
		
		int xNext, yNext;
		for(int i=0; i<2; i++) {
			xNext = xPos + xOptions[i];
			yNext = yPos + yOptions[i];
			
			if(isValidMove(matrix, xNext, yNext)) {
				matrix[xNext][yNext] = 1;
				if(MazeBTImpl(matrix, xNext, yNext, xOptions, yOptions)){
					return true;
				} else {
					matrix[xNext][yNext] = -1;
				}
			}
		}
		return false;
	}
	
	public boolean isValidMove(int[][] matrix, int xPos, int yPos) {
		if(xPos < 0 || xPos >= matrix.length) {
			return false;
		}
		if(yPos < 0 || yPos >= matrix[0].length) {
			return false;
		}
		if(matrix[xPos][yPos] == -1) {
			return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		RatInMaze maze = new RatInMaze();
		
		int[][] matrix = new int[7][5];
		//Init Matrix:
		for (int i=0; i<matrix.length; i++) {
			for (int j=0; j<matrix[0].length; j++) {
				matrix[i][j] = 0;
			}
		}
		matrix[0][2] = -1;
		matrix[1][0] = -1;
		matrix[1][2] = -1;
		matrix[2][0] = -1;
		matrix[2][2] = -1;
		matrix[3][4] = -1;
		matrix[4][1] = -1;
		matrix[4][2] = -1;
		matrix[5][2] = -1;
		matrix[5][4] = -1;
		int xPos = 0, yPos = 0;
		matrix[xPos][yPos] = 1;
		
		maze.MazeBTLauncher(matrix, xPos, yPos);
	}
}
