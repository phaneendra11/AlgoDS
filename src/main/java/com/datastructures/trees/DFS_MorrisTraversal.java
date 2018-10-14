package com.datastructures.trees;

import com.datastructures.trees.model.Node;

public class DFS_MorrisTraversal {
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.right.left = new Node(5);
		root.right.right = new Node(6);
		root.right.left.left = new Node(7);
		root.right.right.left = new Node(8);
		
		morrisAlgo(root);
	}
	
	public static void morrisAlgo(Node node) {
		Node current = node;
		Node predecessor = null;
		
		while(current != null) {
			if(current.left == null) {
				System.out.print(current.key + " ");
				current = current.right;
			} else {
				predecessor = findPredecessor(current);
				if(predecessor.right == null) {
					predecessor.right = current;
					current = current.left;
				} else if(predecessor.right == current) {
					predecessor.right = null;
					System.out.print(current.key + " ");
					current = current.right;
				}
			}
		}
		
	}
	
	private static Node findPredecessor(Node node) {
		Node temp = node.left;
		while(temp.right != null && temp.right != node) {
			temp = temp.right;	
		}
		return temp;
		
	}
}