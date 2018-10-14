package com.algorithms.backtracking;

public class NQueens {
	
	public void NQueensLaunch(int[][] matrix) {
		if(NQueensRecursiveUtil(matrix, 0)){
			for(int i=0; i<matrix.length; i++) {
				for(int j=0; j<matrix.length; j++) {
					System.out.print(matrix[i][j] + " ");
				}
				System.out.println("");
			}
		} else {
			System.out.println("Solution not found");
		}
	}
	
	public boolean NQueensRecursiveUtil(int[][] matrix, int col) {
		if(col >= matrix.length) {
			return true;
		}
		
		for(int i=0; i<matrix.length; i++) {
			if(isSafeMove(matrix, i, col)) {
				matrix[i][col] = 1;
				if(NQueensRecursiveUtil(matrix, col+1)) {
					return true;
				} else {
					matrix[i][col] = 0;
				}
			}
		}
		
		return false;
	}
	
	public boolean isSafeMove(int[][] matrix, int row, int col) {
		int len = matrix.length;
		
		if(row < 0 || row >= len) {
			return false;
		}
		if(col < 0 || col >= len) {
			return false;
		}
		
		for(int i=0; i<len; i++) {
			if(matrix[row][i] == 1){
				return false;
			}
		}
		for(int i=0; i<len; i++) {
			if(matrix[i][col] == 1){
				return false;
			}
		}
		
		for(int i=0; (row+i)<len && (col+i)<len; i++) {
			if(matrix[row+i][col+i] == 1) {
				return false;
			}
		}
		for(int i=0; (row-i)>=0 && (col-i)>=0; i++) {
			if(matrix[row-i][col-i] == 1) {
				return false;
			}
		}
		for(int i=0; (row+i)<len && (col-i)>=0; i++) {
			if(matrix[row+i][col-i] == 1) {
				return false;
			}
		}
		for(int i=0; (row-i)>=0 && (col+i)<len; i++) {
			if(matrix[row-i][col+i] == 1) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		int N = 4;
		
		// Initialize matrix
		int[][] matrix = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				matrix[i][j] = 0;
			}
		}
		
		NQueens queens = new NQueens();
		queens.NQueensLaunch(matrix);
	}
}