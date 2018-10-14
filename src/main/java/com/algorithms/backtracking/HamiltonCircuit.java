package com.algorithms.backtracking;

import java.util.Stack;

public class HamiltonCircuit {

	private static int V;
	
	public void hamiltonCircuitLauncher(int[][] adjMatrix) {
		//int[] result = new int[V+1];
		Stack<Integer> result = new Stack<Integer>();
		/*for(int i=0; i<result.length; i++) {
			result[i] = -1;
		}*/
		
		if(hamiltonRecursiveUtil(adjMatrix, result)){
			for(int i=0; i<result.size(); i++) {
				System.out.print(result.get(i) + " ");
			}
		} else {
			System.out.println("false");
		}
	}
	
	public boolean hamiltonRecursiveUtil(int[][] adjMatrix, Stack<Integer> result) {
		//exit condition
		if(result.size() > 0 && result.size() == V+1 && result.peek() == result.get(0)) {
			return true;
		}
		
		for(int i=0; i<V; i++) {
			if(isValidPath(adjMatrix, result, i)){
				result.push(i);
				if(hamiltonRecursiveUtil(adjMatrix, result)) {
					return true;
				} else {
					result.pop();
				}
			}
		}
		
		return false;
	}
	
	public boolean isValidPath(int[][] adjMatrix, Stack<Integer> result, int currentVertex) {
		for(int i=1; i<result.size(); i++) {
			if(currentVertex == result.get(i)) {
				return false; 
			}
		}
		if(result.size() > 0 && adjMatrix[result.peek()][currentVertex] == 0 && adjMatrix[currentVertex][result.peek()] == 0) {
			return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		V = 5;
		int[][] adjMatrix = {{0, 1, 0, 1, 0},
                			 {1, 0, 1, 1, 1}, 
                			 {0, 1, 0, 0, 1}, 
                			 {1, 1, 0, 0, 0}, 
                			 {0, 1, 1, 0, 0}};
		
		HamiltonCircuit h = new HamiltonCircuit();
		h.hamiltonCircuitLauncher(adjMatrix);
		
	}
}