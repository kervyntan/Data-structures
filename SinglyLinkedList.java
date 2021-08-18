package com.example.practice;

public class SinglyLinkedList {
	
	private ListNode head;

	private static class ListNode {
		
		private int data; // value to pass through to each ListNode
		private ListNode next;

		public ListNode(int data) {
			this.data = data; // constructor for ListNode class
			this.next = null; // the next ListNode has a value of null;
		}
	}

	public void display(ListNode head) {
		
		ListNode current = head;
		while (current != null) { // 
			System.out.print(current.data + " -- >"); // data stores the value of int passed through current
			current = current.next;
		}
		System.out.print("null");
	}

	public int length() {
		ListNode current = head;
		int count = 0;
3
		while (current != null) {
			count++;
			current = current.next;
		}
		return count;
	}

	public void insertFirst(int data) {

		ListNode insertInFront = new ListNode(data);

		insertInFront.next = head;

		head = insertInFront;
	}

	public void insertEnd(int data) {
		ListNode endNode = new ListNode(data);

		if (head == null) { // if head is null, means that singly linked list is empty
			head = endNode;
			return;
		}

		ListNode current = head;

		while (null != current.next) { // keeps checking if the current.next has reached the last node
			current = current.next;
		}
		current.next = endNode;
	}

	public void insertAnywhere(int data, int pos) {
		ListNode node = new ListNode(data); // new node to be added

		int position = pos; // position is directly related to the value of count

		if (position == 1) {
			node.next = head; // assigns the node after the newly inserted node to head;
			head = node; // assigns the first node to be the new node
		}

		else {
			ListNode counterNode = head; // previous points to head, starts from head and transverse
			int count = 1; // count begins from 1 as the we count positions in the linkedlist from 1

			while (count < position - 1) { // condition to stop us where we need to add new node
				counterNode = counterNode.next; // assigns previous to its next node to keep moving down
				count++; // allows us to move to the next position

			}
			ListNode current = counterNode.next; // node that points to the node before the one we adding
			node.next = current; // assigns the node to the value itself
			counterNode.next = node;

		}

	}

	public void deleteFirstNode() {

		ListNode temp = head; // assign a temp listnode to the value of head
		head = head.next; // head is assigned to the node after that
		temp.next = null; // assigns head next to null;
	}
	


	public void deleteLastNode(int length) {

		ListNode current = head;

		int count = 1;
		int position = length;

		while (count < position - 1) {
			current = current.next;
			count++;
		}

		current.next = null;

	}
	
	public void deleteAnywhere(int id) {
		ListNode counterNode = head;
		int position = id;
		
		int count = 1;
		
		while (count < position - 1) {
			counterNode = counterNode.next;
			count++;
		}
		
		ListNode current = counterNode.next;
		counterNode.next = current.next;
		current.next = null;
	}
	
	public boolean find(ListNode head, int searchKey) {
		
		if (head == null) {
			return false;
		}
		
		ListNode current = head;
		
		while (current != null) {
			if (current.data == searchKey) {
				return true;
			} 
			current = current.next;
		}
		return false;
	}
	
	public ListNode reverse(ListNode head) {
		
		ListNode current = head;
		ListNode previous = null;
		ListNode next = null;
		
		while (current != null ) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		
		return previous;
	}
	
	public ListNode getMiddleNode () {
		if (head == null) {
			return null;
		}
		
		ListNode middleNode = head;
		ListNode traverser = head;
		
		while (traverser != null & traverser.next != null) {
			
		// traverser.next checks if traverser has reached the end, and hence 
		// should point to null
		      middleNode = middleNode.next;
		      traverser = traverser.next.next;
		}
		
		return middleNode;
	}
	
	public boolean recursiveSearch(ListNode head, int searchKey) {
		// base case

		if (head == null) { // eventually they'll reach this base case
			return false;
		}

		if (head.data == searchKey) {
			return true;
		}

		return recursiveSearch(head.next, searchKey); // head = head.next (traversing list)
		// return the final value once it reaches the last call in the stack (whether is true/false)
		// avoid the need to loop printing using Sysout 

	}

	public static void main(String[] args) {
		SinglyLinkedList sll = new SinglyLinkedList(); // object declaration

		sll.head = new ListNode(10); // passing value of 10 to the ListNode head

		ListNode second = new ListNode(12); // declarations for the subsequent ListNodes (new objects)
		ListNode third = new ListNode(45); // each declaration is a new object of ListNode
		ListNode fourth = new ListNode(57);
		ListNode fifth = new ListNode(87);

		sll.head.next = second; // each calls a new instance of next, due to each being a separate Obj
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		
		ListNode middlenode = sll.getMiddleNode(); // middleNode return value stored in this 
		
		System.out.println(middlenode.data);

		ListNode reverseList = sll.reverse(sll.head);
		
		sll.display(reverseList);
		
		
		
		

	}

}
