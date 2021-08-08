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

	public void display() {
		ListNode current = head;
		while (current != null) {
			System.out.print(current.data + " -- >"); // data stores the value of int passed through current
			current = current.next;
		}
		System.out.print("null");
	}

	public int length() {
		ListNode current = head;
		int count = 0;

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
	
	public void insertAnywhere (int data, int pos) {
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
		node.next = current; //assigns the node to the value itself
		counterNode.next = node;
		
		}
		
	}
	
	public void deleteFirstNode () {
		
		ListNode temp = head; // assign a temp listnode to the value of head
		head = head.next; // head is assigned to the node after that
		temp.next = null; // assigns head next to null;
	}
	
	public void deleteLastNode(int length) {
		
		ListNode current = head;
		
		int count = 1;
		int position = length;
		
		while(count < position - 1) {
			current = current.next;
			count++;
		}
		
		current.next = null;
	
		
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

		

		sll.deleteLastNode(3);
		sll.display();

	}

}