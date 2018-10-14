package com.algorithms.backtracking;

public class KnightsTour {

	private static int N = 8;
	
	public void KnightLauncher() {
		// This order is very important otherwise it may go in infinite loops
		int xOptions[] = {2, 1, -1, -2, -2, -1, 1, 2}; 
        int yOptions[] = {1, 2, 2, 1, -1, -2, -2, -1}; 
		
		int count = 0;
		int[][] matrix = new int[N][N];
		for(int i=0; i<N;i++) {
			for(int j=0; j<N; j++) {
				matrix[i][j] = -1;
			}
		}
		matrix[0][0] = 0;
		boolean found = KnightBTUtilImpl(matrix, 0, 0, xOptions, yOptions, count + 1);
		
		if(found) {
			for(int i=0; i<N;i++) {
				for(int j=0; j<N; j++) {
					System.out.print(matrix[i][j] + " ");
				}
				System.out.println("");
			}
		} else {
			System.out.println("Solution not available");
		}
	}
	
	public boolean KnightBTUtilImpl(int[][] matrix, int xPos, int yPos, int[] xOptions, int[] yOptions, int count) {
		//System.out.println(count+ "; " + xPos + ", " + yPos);
		if(count == 64) {
			return true;
		}
		int i, nextX, nextY;
		for(i=0; i<N; i++) {
			nextX = xPos + xOptions[i];
			nextY = yPos + yOptions[i];
			if(isValidMove(matrix, nextX, nextY)) {
				matrix[nextX][nextY] = count;
				if(KnightBTUtilImpl(matrix, nextX, nextY, xOptions, yOptions, count + 1)) {
					return true;
				} else {
					matrix[nextX][nextY] = -1;
				}
			}
		}
		return false;
	}
	
	public boolean isValidMove(int[][] matrix, int xPos, int yPos) {
		if(xPos < 0 || xPos > 7) {
			return false;
		}
		if(yPos < 0 || yPos > 7) {
			return false;
		}
		if(matrix[xPos][yPos] != -1) {
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		KnightsTour knightTour = new KnightsTour();
		knightTour.KnightLauncher();
	}
}