package com.example.practice;

import java.util.*;

public class Stack {
      
	// Instance variables
	
	private ListNode top; // Points to null 
	private int length; // 0 originally
	
	public static class ListNode {
		private int data;
		private ListNode next;
		
		public ListNode (int data) {
			this.data = data;
		}
	}
	
	public Stack () {
		top = null;
		length = 0;
	}
	
	public boolean isEmpty() {
		return length == 0;
	}
	
	public int length() {
		return length;
	}
	
	public void push (int data) {
		ListNode temp = new ListNode(data);
		
		temp.next = top;
		
		top = temp;
		
		length++;
		
	}
	
	public void pop () {
		
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		
		int poppedValue = top.data;
		
		top = top.next;
		
		length--;
		
		System.out.println(poppedValue + " Removed. ");
		
	}
	
	public void peek() {
		
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		
		System.out.println(top.data);
	}
	
	
	public static void main (String[] args) {
		Stack stack = new Stack();
		
		stack.push(10);
		stack.push(15);
		stack.push(20);
		
		stack.peek();
		stack.pop();
		stack.peek();
	}
	
	
}
