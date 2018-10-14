package com.datastructures.trees;

import java.util.LinkedList;

import com.datastructures.trees.model.Node;

public class BFS {
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.right.left = new Node(5);
		root.right.right = new Node(6);
		root.right.left.left = new Node(7);
		root.right.right.left = new Node(8);
		
		levelOrder(root);
	}
	
	public static void levelOrder(Node node) {
		LinkedList<Node> list = new LinkedList<Node>();
		list.add(node);
		
		Node temp = null;
		while(list.size() > 0) {
			temp = list.remove();
			
			System.out.print(temp.key + " ");
			if (temp.left != null) {
				list.add(temp.left);
			}
			if (temp.right != null) {
				list.add(temp.right);
			}
			
		}
	}
}
