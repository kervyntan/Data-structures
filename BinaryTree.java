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
		Stack<TreeNode> stack = new Stack<>();

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

	public void recursiveInOrder(TreeNode root) {
		// Traverse to Left Node first
		// Visit root node
		// Traverse to right node

		if (root == null) {
			return; // Base case for the recursion
		}

		recursiveInOrder(root.left);
		System.out.print(root.data + " ");
		recursiveInOrder(root.right);
	}

	public void iterativeInOrder(TreeNode root) {

		if (root == null) {
			return;
		}
		TreeNode temp = root;

		Stack<TreeNode> stack = new Stack<>(); // Create a new stack for storing nodes

		while (!stack.isEmpty() || temp != null) {

			if (temp != null) {
				stack.push(temp);
				temp = temp.left;
			} else {
				temp = stack.pop();
				System.out.print(temp.data);
				temp = temp.right;
			}
		}

	}

	public void recursivePostOrder(TreeNode root) {
		if (root == null) {
			return;
		}

		recursivePostOrder(root.left);
		recursivePostOrder(root.right);
		System.out.print(root.data + " ");
	}

	public void iterativePostOrder(TreeNode root) {
		TreeNode temp = root;

		Stack<TreeNode> stack = new Stack<>();

		if (root == null) {
			return;
		}

		while (!stack.isEmpty() || temp != null) {
			if (temp != null) {

				stack.push(temp);

				temp = temp.left;
			}

			else {
				TreeNode current = stack.peek().right;

				if (current == null) {

					current = stack.pop();
					System.out.print(current.data + " ");

					while (!stack.isEmpty() && current == stack.peek().right) {

						current = stack.pop();
						System.out.print(current.data + " ");
					}
				}

				else {
					temp = current;
				}

			}
		}

	}
	
	
	public void levelOrderTraversal(TreeNode root) {
		// Queue is a FIFO data structure (First In First Out)
		// Enter from one side, exits through the next
		if (root == null) {
			return;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			TreeNode temp = queue.poll();

			System.out.print(temp.data + " ");

			if (temp.left != null) {
				queue.offer(temp.left);
			}

			if (temp.right != null) {
				queue.offer(temp.right);
			}
		}

	}
	
		public int findMax (TreeNode root) {
		if (root == null) { // Base Case
			return Integer.MIN_VALUE;
		}
		
		int answer = root.data;
		int leftRoot = findMax(root.left);
		int rightRoot = findMax(root.right);
		
		if (leftRoot > answer) {
			answer = leftRoot;
		} 
		
		if (rightRoot > answer) {
			answer = rightRoot;
		}
		
		return answer;
	}

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.createBinaryTree();
		tree.iterativeInOrder(tree.root);

	}
}
