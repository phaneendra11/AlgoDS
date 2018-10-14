package com.datastructures.trees;

import com.datastructures.trees.model.Node;

public class DFS_Recursion {
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.right.left = new Node(5);
		root.right.right = new Node(6);
		root.right.left.left = new Node(7);
		root.right.right.left = new Node(8);
	
		System.out.println("in-Order: ");
		inOrder(root);
		
		System.out.println("");
		System.out.println("pre-Order: ");
		preOrder(root);
		
		System.out.println("");
		System.out.println("post-Order: ");
		postOrder(root);
	}
	
	public static void inOrder(Node node) {
		if(node == null) {
			return;
		}
		
		inOrder(node.left);
		System.out.print(node.key + " ");
		inOrder(node.right);
	}
	
	public static void preOrder(Node node) {
		if(node == null) {
			return;
		}
		
		System.out.print(node.key + " ");
		preOrder(node.left);
		preOrder(node.right);
	}
	
	public static void postOrder(Node node) {
		if(node == null) {
			return;
		}
		
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.key + " ");
	}
}
