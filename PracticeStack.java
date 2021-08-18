package com.example.practice;

import java.util.Stack;
public class PracticeStack {
	
	public static Stack<Integer> sort(Stack<Integer> input) {

		if (input.isEmpty()) {
			return null;
		}

		int temp;

		Stack<Integer> tempStack = new Stack<>();

		while (!input.isEmpty()) {
			temp = input.pop();

			while (!tempStack.isEmpty() && tempStack.peek() > temp) {
				input.push(tempStack.pop());
			}
			tempStack.push(temp);
		}
		
		return tempStack;
	}
	
	public static void main (String[] args) {
		Stack<Integer> stack = new Stack <>();
		
		stack.add(3);
		stack.add(9);
		stack.add(5);
		
		stack.toArray();
		
		System.out.println(stack);
		
		Stack<Integer> sortedStack = sort(stack);
		
		sortedStack.toArray();
		
		System.out.println(sortedStack);
		
		
	}

}
