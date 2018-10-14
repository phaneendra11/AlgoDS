package com.datastructures.trees;

import java.util.Stack;

import com.datastructures.trees.model.Node;

public class DFS_using_stack {
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.right.left = new Node(5);
		root.right.right = new Node(6);
		root.right.left.left = new Node(7);
		root.right.right.left = new Node(8);
		
		//dfs_inorder_Stack(root);
		//dfs_preorder_Stack(root);
		dfs_postorder_Stack(root);
	}
	
	public static void dfs_inorder_Stack(Node node) {
		Stack<Node> s = new Stack<Node>();
		Node current = node;
		
		while(current != null || !s.isEmpty()) {
			while(current != null) {
				s.push(current);
				current = current.left;
			}
			
			current = s.pop();
			System.out.print(current.key + " ");
			
			current = current.right;
		}
	}
	
	public static void dfs_preorder_Stack(Node node) {
		Stack<Node> s = new Stack<Node>();
		Node current = node;
		s.push(current);
		
		while(!s.isEmpty()) {
			current = s.pop();
			System.out.print(current.key + " ");
			
			if(current.right != null) {
				s.push(current.right);
			}
			
			if(current.left != null) {
				s.push(current.left);
			}
		}
	}
	
	public static void dfs_postorder_Stack(Node node) {
		//Stack<Node> s = new Stack<Node>();
		//Node current = node;
		
		// TODO - HARD
		
	}
}