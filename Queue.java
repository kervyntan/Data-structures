package com.example.practice;

import java.util.*;

public class Queue {

	private ListNode front; // ListNode used here as a queue is a type of a list
	private ListNode rear;
	private int length;

	public Queue() {
		this.front = null;
		this.rear = null;
		this.length = 0;
	}

	private static class ListNode {
		private int data;
		private ListNode next;

		public ListNode(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public boolean isEmpty() {
		return length == 0;
	}

	public int length() {
		return length;
	}

	public void enqueue(int data) { // adding a element into the queue
		// Elements are added from the rear end
		ListNode newNode = new ListNode(data);

		if (isEmpty()) {
			front = newNode;
		}

		rear.next = newNode;
		rear = newNode; // Assigns the new rear to the added node

		length++;

	}

	public int dequeue() {
		// Elements are deleted from the front end

		if (isEmpty()) {
			throw new NoSuchElementException("Queue is already empty. ");

		}

		int result = front.data; // Obtain value of node in front

		front = front.next; // Establishes the new front node

		if (front == null) {
			// Both front and rear must point to null to break the links to the last node
			// if removing the node leads to an empty queue
			rear = null;
		}

		length--; // Node removed

		return result;

	}



}
