package com.example.practice;

import java.util.*;

public class CircularSinglyLinkedList {
	private ListNode last;
	private int length;

	private static class ListNode {
		private ListNode next;
		private int data;

		public ListNode(int data) {
			this.data = data;

		}
	}

	public CircularSinglyLinkedList() {
		last = null; // Original list is empty.
		length = 0;
	}

	public boolean isEmpty() {
		return length == 0;
	}

	public int length() {
		return length;
	}

	public void createCircularLinkedList() {

		ListNode first = new ListNode(1);
		ListNode second = new ListNode(2);
		ListNode third = new ListNode(3);
		ListNode fourth = new ListNode(4);

		first.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = first;

		last = fourth; // End of circular linked list
	}

	public void display() {

		ListNode first = last.next; // Since the last node points to the first

		if (last == null) { // Print null if the list is empty
			System.out.println("null");
		}

		while (first != last) { // Loops through the list until it reaches the last node
			System.out.print(first.data + " -- > ");
			first = first.next;
		}

		System.out.print(first.data);
	}

	public void insertFirstNode(int data) {

		ListNode newNode = new ListNode(data);
		ListNode first = last.next;

		if (last == null) {

			last = newNode;

		} else {

			newNode.next = first; // Establishes link between new node and (now) second node

			last.next = newNode; // Establishes new link between last node and new node

		}

		length++;
	}

	public void insertEndNode(int data) {

		ListNode newNode = new ListNode(data);

		ListNode first = last.next;

		if (last == null) {

			last = newNode;
			last.next = last;

		} else {

			last.next = newNode;

			newNode.next = first;

			last = newNode;

		}

		length++;
	}

	public void removeFirstNode() {

		if (isEmpty()) {
			throw new NoSuchElementException(); // if the list is empty
		}

		ListNode first = last.next;

		ListNode second = first.next;

		if (length == 1) {

			last = null; // Removes the last node in the list

		}

		first.next = null; // Breaks the pointer from the first to the second node
		last.next = second; // Establishes pointer from last to new first node

		length--;
	}

	public static void main(String[] args) {

		CircularSinglyLinkedList csll = new CircularSinglyLinkedList();

		csll.createCircularLinkedList();
		csll.insertFirstNode(12);
		csll.insertEndNode(13);
		csll.removeFirstNode();
		csll.display();
	}
}
