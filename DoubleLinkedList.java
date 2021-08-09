package com.example.practice;

public class DoubleLinkedList {

	private ListNode head; // First Node
	private ListNode tail; // Last Node
	private int length;

	private static class ListNode { // declare static to allow main method to access methods

		private int data; // value given to each Node
		private ListNode previous; // new addition to the class compared to SinglyLinkedList (points back + front)
		private ListNode next; // imagine each of these as "partial object declaration" ( no new object on the
								// RHS )

		public ListNode(int data) {
			this.data = data;
		}
	}

	public DoubleLinkedList() {
		this.head = null; // when list is initialized, the list is empty
		this.tail = null;
		this.length = 0;
	}

	public boolean isEmpty() {
		return length == 0; // returns true if head == null
	}

	public int length() {
		return length;
	}

	public void display() {

		ListNode current = head; // current is an object of ListNode class

		while (current != null) {

			System.out.print(current.data + " -- > ");
			current = current.next; // calls the value of next and assigns it to current

		}
		System.out.print("null");
	}

	public void insertFirstNode(int data) {

		ListNode firstNode = new ListNode(data); // new object insertNode to be added

		if (isEmpty()) { // new method compared to Singly Linked List

			tail = firstNode; // if list is empty

		} else {

			head.previous = firstNode; // Allows for new node to be added directly to previous
		}

		firstNode.next = head; // sets a pointer; new Node's next points to head

		head = firstNode; // assign beginning of list to new node

	}

	public void insertEndNode(int data) {

		ListNode lastNode = new ListNode(data);

		if (isEmpty()) {

			head = lastNode;

		} else {
			tail.next = lastNode;
			lastNode.previous = tail;
		}
		
		tail = lastNode;

	}
	
	public void deleteFirstNode () {
		
		ListNode current = head;
		
		head = head.next;
		
		current = null;
		
	}

	public static void main(String[] args) {
		DoubleLinkedList dll = new DoubleLinkedList();

		dll.head = new ListNode(1); // assigns a value to head, initializes it
		ListNode second = new ListNode(2);
		ListNode third = new ListNode(3);
		ListNode tail = new ListNode(4);

		dll.head.next = second;
		second.next = third;
		third.next = tail;
		tail.next = null;

		
		dll.deleteFirstNode();
		dll.display();

	}

}
