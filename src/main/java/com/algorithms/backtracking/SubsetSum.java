package com.algorithms.backtracking;

import java.util.HashSet;

public class SubsetSum {
	
	private static int SUM;

	public void SubsetSumLaunch(int[] elements) {
		HashSet<Integer> resultSet = new HashSet<Integer>();
		
		if(SubsetSumRecursiveUtil(elements, resultSet)) {
			for(int i: resultSet) {
				System.out.print(i + " ");
			}
		} else {
			System.out.println("No solution found");
		}
	}
	
	public boolean SubsetSumRecursiveUtil(int[] elements, HashSet<Integer> result) {
		int temp = 0;
		for(int i: result) {
			temp = temp + i;
		}
		if(temp == SUM) {
			return true;
		}
		
		for(int i=0; i<elements.length; i++) {
			if(isValid(result, elements[i])) {
				result.add(elements[i]);
				if(SubsetSumRecursiveUtil(elements, result)){
					return true;
				} else {
					result.remove(elements[i]);
				}
			}
		}
		
		return false;
	}
	
	public boolean isValid(HashSet<Integer> result, int newElement) {
		if(result.contains(newElement)) {
			return false;
		}
		
		int temp = 0;
		for(int i: result) {
			temp = temp + i;
		}
		if((temp + newElement) > SUM) {
			return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		SubsetSum s = new SubsetSum();
		
		SUM = 53;
		int[] elements = {15, 22, 14, 26, 32, 9, 16, 8};
		
		s.SubsetSumLaunch(elements);
	}
}