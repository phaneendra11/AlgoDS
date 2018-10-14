package com.datastructures.trees.model;

public class Node {
	public int key;
	public Node left;
	public Node right;
	
	public Node() {
		//
	}
	
	public Node(int key) {
		this.key = key;
	}

	public Node(int key, Node left, Node right) {
		this.key = key;
		this.left = left;
		this.right = right;
	}
}
