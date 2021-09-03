package com.example.practice;

public class BST {

	private TreeNode root;

	public class TreeNode {
		private int data;
		private TreeNode left;
		private TreeNode right;

		public TreeNode(int data) {
			this.data = data;
		}
	}

	public void inOrder() {
		inOrder(root);
	}

	public void inOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);
	}

	public void insert(int value) {
		root = insert(root, value);
	}

	public TreeNode insert(TreeNode root, int value) {
		if (root == null) { // base case for recursion
			// In case BST is empty
			root = new TreeNode(value);
			return root;
		}

		if (value < root.data) { // Binary Search; cuts the tree in half, removes the irrelevant half
			root.left = insert(root.left, value);
			// 1. Assigns the new node and value to root.left
			// 2. Assigns root = root.left by passing root.left as parameter, causing root
			// to equals to null
			// 3. When null, insert method will reach base case, and assign root to the new
			// node
			// 4. After return statement, recursive call is removed from call stack
			// 5. Code begins at the above statement again, where root is back to value
			// present when recursive call was made (the parent node of newNode)
			// 6. Value of return in (4) is stored in the recursive call of
			// insert(root.left, value)
			// 7. Value is then assigned to root.left (left of parent node)
		} else {
			root.right = insert(root.right, value);
		}

		return root; // End of execution of method
	}

	public TreeNode search(TreeNode root, int key) {
		if (root == null || root.data == key) {
			return root;
		}

		if (key < root.data) {
			return search(root.left, key);
		} else {
			return search(root.right, key);
		}

	}

}
