package com.algorithms.dynamicProgramming;
import java.util.HashMap;

public class DynamicProgramming {
	public static void main(String[] args) {
		
		/*System.out.println(" ----------------------- Fibinocci Series --------------------------");
		int N = 19;
		System.out.println(N + "th number in the Fibinocci series is: " + getFibinocciNumber_Recursion(N));
		int[] memoryArray = new int[N+1];
		System.out.println(N + "th number in the Fibinocci series is: " + getFibinocciNumber_Memoization(N, memoryArray));
		System.out.println(N + "th number in the Fibinocci series is: " + getFibinocciNumber_Bottomup(N, memoryArray));
		System.out.println(" -------------------------------------------------------------------");*/
		
		/*System.out.println(" ----------------------- Bionomial Coefficient --------------------------");
		int N=3, K=3;
		HashMap<String , Integer> memoryMap = new HashMap<>();
		System.out.println("Bionomial Coefficient of C(" + N + ", " + K + ") is: " + getBionomialCoefficient_Recursion(N, K));
		System.out.println("Bionomial Coefficient of C(" + N + ", " + K + ") is: " + getBionomialCoefficient_Memoization(N, K, memoryMap));
		
		System.out.println(" ------------------------------------------------------------------------");*/
		
		/*int n=5, k=2;
		int result = nthDegreeCoefficient(n, k, memory);
		System.out.println("Result is: " + result);*/
		
		StringBuilder sb = new StringBuilder();
		String s1 = "AGBGTDS"; String s2 = "GXDS";
		System.out.println("Inputs strings are " + s1 + " and " + s2);
		int result = longestSubSequence(s1.toCharArray(), s2.toCharArray(), s1.length(), s2.length(), sb);
		System.out.println("Length of the longest sub sequence is: " + result);
		System.out.println("Longest sub sequence is: " + sb.toString());
		
	}
	
	/**
	 * This method will find the Nth number in the Fibinocci series using recursion technique
	 * */
	public static int getFibinocciNumber_Recursion(int N) {
		if (N == 1) {
			return 1;
		} else if (N == 2) {
			return 1;
		} else {
			return (getFibinocciNumber_Recursion(N-1) + getFibinocciNumber_Recursion(N-2));
		}
	}
	
	/**
	 * This method will find the Nth number in the Fibinocci series using memoization technique
	 * */
	public static int getFibinocciNumber_Memoization(int N, int[] memory) {
		if(memory[N] != 0) {
			return memory[N];
		}
		
		int result;
		if (N == 1) {
			result = 1;
		} else if (N == 2) {
			result = 1;
		} else {
			result = (getFibinocciNumber_Recursion(N-1) + getFibinocciNumber_Recursion(N-2));
		}
		memory[N] = result;
		return result;
	}
	
	/**
	 * This method will find the Nth number in the Fibinocci series using bottom up approach
	 * */
	public static int getFibinocciNumber_Bottomup(int N, int[] memory) {
		memory[1] = memory[2] = 1;
		for (int i=3; i<=N; i++) {
			memory[i] = memory[i-1] + memory[i-2];
		}
		return memory[N];
	}
	
	/**
	 * This method will find the Bionomial coefficient C(N, K) using recursion
	 * */
	public static int getBionomialCoefficient_Recursion(int N, int K) {
		if (K == 0) {
			return 1;
		} else if (N == 0) {
			return 0;
		} else {
			return (getBionomialCoefficient_Recursion(N-1, K-1) + getBionomialCoefficient_Recursion(N-1, K)); 
		}
	}
	
	/**
	 * This method will find the Bionomial coefficient C(N, K) using memoization
	 * */
	public static int getBionomialCoefficient_Memoization(int N, int K, HashMap<String, Integer> memoryMap) {
		String key = N + ":" + K;
		if(memoryMap.containsKey(key)) {
			return memoryMap.get(key);
		}
		
		int result = 0;
		if (K == 0) {
			result =  1;
		} else if (N == 0) {
			result = 0;
		} else {
			result = (getBionomialCoefficient_Recursion(N-1, K-1) + getBionomialCoefficient_Recursion(N-1, K)); 
		}
		memoryMap.put(key, result);
		return result;
	}
	
	/**
	 * This method will find the Bionomial coefficient C(N, K) using button up approach
	 * */
	/*public static int nthDegreeCoefficient(int n, int k, HashMap<String, Integer> memory) {
		if (memory.containsKey(n+":"+k)) {
			return memory.get(n+":"+k);
		}
		if (k == 0) {
			return 1;
		} else if (n == 0) {
			return 0;
		} else {
			int temp = nthDegreeCoefficient(n-1, k-1, memory) + nthDegreeCoefficient(n-1, k, memory);
			memory.put(n+":"+k, temp);
			return temp;
		}
		
		
		for (int i=1; i<k; i++) {
			
		}
		
		
		
	}*/
	
	public static int longestSubSequence(char[] X, char[] Y, int m, int n, StringBuilder sb) {
		if(m == 0 || n == 0) {
			return 0;
		}
		else if (X[m-1] == Y[n-1]) {
			sb.append(X[m-1]);
			return (1 + longestSubSequence(X, Y, m-1, n-1, sb) );
		} else {
			return Math.max(longestSubSequence(X, Y, m, n-1, sb), longestSubSequence(X, Y, m-1, n, sb));
		}
	}
}