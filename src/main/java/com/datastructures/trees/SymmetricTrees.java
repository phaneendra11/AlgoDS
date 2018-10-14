package com.datastructures.trees;

import com.datastructures.trees.model.Node;

public class SymmetricTrees {
	public static void main(String[] args) {
		/*Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.right.left = new Node(5);
		root.right.right = new Node(6);
		root.right.left.left = new Node(7);
		root.right.right.left = new Node(8);*/
		
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(2);
		root.left.left = new Node(3);
		root.right.right = new Node(3);
		
		
		System.out.println(isSymmetric(root, root));
	}
	
	public static boolean isSymmetric(Node left, Node right) {
		if(right == null && left == null) {
			return true;
		}
		
		if(right != null && left != null && right.key == left.key) {
			return (isSymmetric(left.right, right.left) && isSymmetric(left.left, right.right));
		}
		
		return false;
	}
}