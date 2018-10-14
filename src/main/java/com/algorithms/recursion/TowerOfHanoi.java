package com.algorithms.recursion;

public class TowerOfHanoi {

	public void recursion(int n, String fromRod, String auxRod, String toRod) {
		if(n == 1) {
			System.out.println("Move 1 from " + fromRod + " to " + toRod);
			return;
		}
		
		recursion(n-1, fromRod, toRod, auxRod);
		System.out.println("Move " + n + " from " + fromRod + " to " + toRod);
		recursion(n-1, auxRod, fromRod, toRod);
	}
	
	public static void main(String[] args) {
		TowerOfHanoi t = new TowerOfHanoi();
		
		t.recursion(4, "A", "B", "C");
	}
}