package com.example.practice;

import java.util.Stack;

public class StackStringReverse {

	public static String stringReverse(String word) {
		Stack<Character> stack = new Stack<>(); // empty stack
		char[] chars = word.toCharArray(); // convert string to array of chars

		for (char c : chars) { // Inserts each element into the stack
			stack.push(c);
		}

		for (int i = 0; i < chars.length; i++) { // Pops and inserts elements in the opposite direction
			chars[i] = stack.pop();
		}

		return new String(chars); // converts char array to a string
	}

	public static void main(String[] args) {
		String animal = "Salamander";
		System.out.println("Before reversing " + animal);
		System.out.println("After reversing " + stringReverse(animal));
	}
}
