package com.algorithms.backtracking;

public class Sudoku {

	public void SudokuLauncher(int[][] input, int count) {
		if(SudokuRecursionImpl(input, count)) {
			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) {
					System.out.print(input[i][j] + " ");
				}
				System.out.println("");
			}
		} else {
			System.out.println("No solution found!");
			
			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) {
					System.out.print(input[i][j] + " ");
				}
				System.out.println("");
			}
		}
	}
	
	public boolean SudokuRecursionImpl(int[][] input, int count) {
		if(count <= 0) {
			return true;
		}
		boolean found = false;
		int x=0,y=0;
		for(x=0;x<=8;x++) {
			for(y=0;y<=8;y++) {
				if(input[x][y] == 0){
					found = true;
					break;
				}
			}
			if(found) {
				break;
			}
		}
		
		for(int i=1; i<=9; i++) {
			if(isValid(input, x, y, i)) {
				input[x][y] = i;
				if(SudokuRecursionImpl(input, count-1)) {
					return true;
				} else {
					input[x][y] = 0;
				}
			}
		}
		
		return false;
	}
	
	public boolean isValid(int[][] input, int xPos, int yPos, int value) {
		for(int i=0; i<9; i++) {
			if(input[xPos][i] == value) {
				return false;
			}
		}
		for(int i=0; i<9; i++) {
			if(input[i][yPos] == value) {
				return false;
			}	
		}
		
		
		int xStart=0, xEnd=0, yStart=0, yEnd=0;
		if (0<=xPos && xPos<=2) {
			xStart = 0;xEnd = 2;
		}
		if (3<=xPos && xPos<=5) {
			xStart = 3;xEnd = 5;
		}
		if (6<=xPos && xPos<=8) {
			xStart = 6;xEnd = 8;
		}
		if (0<=yPos && yPos<=2) {
			yStart = 0;yEnd = 2;
		}
		if (3<=yPos && yPos<=5) {
			yStart = 3;yEnd = 5;
		}
		if (6<=yPos && yPos<=8) {
			yStart = 6;yEnd = 8;
		}
		
		for(int i=xStart; i<=xEnd; i++) {
			for(int j=yStart; j<=yEnd; j++) {
				if(input[i][j] == value) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		int[][] input = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
                		 {5, 2, 0, 0, 0, 0, 0, 0, 0}, 
                		 {0, 8, 7, 0, 0, 0, 0, 3, 1}, 
                		 {0, 0, 3, 0, 1, 0, 0, 8, 0}, 
                		 {9, 0, 0, 8, 6, 3, 0, 0, 5}, 
                		 {0, 5, 0, 0, 9, 0, 6, 0, 0}, 
                		 {1, 3, 0, 0, 0, 0, 2, 5, 0}, 
                		 {0, 0, 0, 0, 0, 0, 0, 7, 4}, 
                		 {0, 0, 5, 2, 0, 6, 3, 0, 0}};
		
		int count = 0;
		for(int i=0; i<input.length; i++) {
			for(int j=0; j<input.length; j++) {
				if(input[i][j] == 0) {
					count++;
				}
			}
		}
		
		Sudoku s = new Sudoku();
		s.SudokuLauncher(input, count);
	}
}