package com.example.practice;

import java.util.*;
import java.util.Stack;

public class BinaryTree {

	private TreeNode root;

	private static class TreeNode {

		private int data;
		private TreeNode left;
		private TreeNode right;

		public TreeNode(int data) {
			this.data = data;
		}
	}

	public BinaryTree() {
		this.root = null;
	}

	public void createBinaryTree() {
		TreeNode first = new TreeNode(1);
		TreeNode second = new TreeNode(2);
		TreeNode third = new TreeNode(3);
		TreeNode fourth = new TreeNode(4);
		TreeNode fifth = new TreeNode(5);

		root = first; // Assign first TreeNode to root ( root ---> first )
		first.left = second; // Each node can point to up to 2 children
		first.right = third; // second <--- first ---> third

		second.left = fourth;
		second.right = fifth;
	}

	public void recursivePreOrder(TreeNode root) {
		if (root == null) { // Base case for the recursion
			return; // Processes the method and removes it from the top of the call stack
		}
		System.out.print(root.data + " ");
		// root = root.left
		recursivePreOrder(root.left); // Keep executing until root.left points to null
		recursivePreOrder(root.right); // Keep executing until root.right points to null
	}
	
	public void iterativePreOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		Stack <TreeNode> stack = new Stack <>();
		
		stack.push(root); // Push root into stack first
		
		while (!stack.isEmpty()) {
			TreeNode temp = stack.pop();
			System.out.print(temp.data + " "); // Process the value of temp
			
			if (temp.right != null) { // Push the right node into the stack first
				// Stack is LIFO, so push left last to allow it to be popped first
				stack.push(temp.right);
			} 
			
			if (temp.left != null) { 
				// Stack is LIFO, so push left last to allow it to be popped first
				stack.push(temp.left);
			}
		}
		
	}
	
	public void recursiveInOrder (TreeNode root) {
		// Visit processes the value of the node itself
		
		if (root == null) {
			return;
		}
		// Passing root = root.left 
		recursiveInOrder(root.left);
		System.out.print(root.data + " ");
		// Passing root = root.right
		recursiveInOrder(root.right);
		
	} // The value is processed off the stack only at the end of the block of code


	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.createBinaryTree();
		tree.recursivePreOrder(tree.root);

	}
}
