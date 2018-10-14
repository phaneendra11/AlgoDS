package com.datastructures.trees;

import com.datastructures.trees.model.Node;

public class LevelOrder_Spiral {
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.right.left = new Node(5);
		root.right.right = new Node(6);
		root.right.left.left = new Node(7);
		root.right.right.left = new Node(8);
	}
	
	public static void levelOrderSpiral(Node node) {/*
		LinkedList<Node> list = new LinkedList<Node>();
		list.add(node);
		ArrayList<Node> tempArray = new ArrayList<Node>();
		int boolean leftToRight = true;
		
		Node temp = null;
		while(list.size() > 0) {
			while(list.size() == 0) {
				tempArray.add(list.remove());
			}
			if(leftToRight) {
				
			}
			
			temp = list.remove();
			
			System.out.print(temp.key + " ");
			if (temp.left != null) {
				list.add(temp.left);
			}
			if (temp.right != null) {
				list.add(temp.right);
			}
			
		}
	*/}

}