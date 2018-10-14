package com.algorithms.sorting;

public class SortingAlgorithms {
	
	public static void main(String[] args) {
		
	}

	public static void print(int[] input) {
		for(int i: input) {
			System.out.print(i + " ");
		}
		System.out.println("");
	}
	
	public static void selectionSort(int[] input) {
		int minElement = Integer.MAX_VALUE;
		int minElementIndex = -1;
		int tempElement = 0;
		for(int i=0; i<input.length; i++) {
			minElement = Integer.MAX_VALUE;
			minElementIndex = -1;
			tempElement = 0;
			
			for(int j=i; j<input.length; j++) {
				if(input[j] < minElement) {
					minElement = input[j];
					minElementIndex = j;
				}
			}
			tempElement = input[i];
			input[i] = minElement;
			input[minElementIndex] = tempElement;
		}
	}
	
	public static void bubbleSort(int[] input) {
		int tempElement = 0;
		for(int i=0; i<input.length-1; i++) {
			for(int j=0; j<input.length-1-i; j++) {
				if(input[j] > input[j+1]){
					tempElement = input[j];
					input[j] = input[j+1];
					input[j+1] = tempElement;
				}
			}
		}
	}
	
	public static void insertionSort(int[] input) {
		for(int i=1; i<input.length; i++) {
			int value = input[i];
			int insertionPosition = i-1;
			while(insertionPosition >= 0 && value < input[insertionPosition]) {
				input[insertionPosition + 1] = input[insertionPosition];
				insertionPosition--;
			}
			input[insertionPosition+1] = value;
		}
	}
	
	public static void mergeSort(int[] input) {
		if(input.length < 2) {
			return;
		} else {
			int n = input.length;
			int mid = n/2;
			int[] leftArray = new int[mid];
			int[] rightArray = new int[n-mid];
			for(int i=0,j=0,k=0; i<n; i++) {
				if(i<mid) {
					leftArray[j++] = input[i];
				}
				else {
					rightArray[k++] = input[i];
				}
			}
		
			mergeSort(leftArray);
			mergeSort(rightArray);
			merge(leftArray, rightArray, input);
		}
	}
	
	public static void merge(int[] leftArray, int[] rightArray, int[] input) {
		int i=0,j=0,k=0;
		while(i<leftArray.length && j<rightArray.length) {
			if(leftArray[i] <= rightArray[j]) {
				input[k] = leftArray[i++];
			} else {
				input[k] = rightArray[j++];
			}
			k++;
		}
		while(i<leftArray.length) {
			input[k++] = leftArray[i++];
		}
		while(j<rightArray.length) {
			input[k++] = rightArray[j++];
		}
	}
	
	public static void quickSort(int[] input, int start, int end) {
		
	}
	
}