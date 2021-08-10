package com.example.practice;

public class OneDimensionalArray {

	public OneDimensionalArray() {
		
		int[] myArray = new int[0];

	}

	public static void printArray(int[] numbers) {

		for (int x : numbers) {
			System.out.print(x + " | ");
		}

		System.out.println();
	}

	public static void reverseArray(int[] numbers, int start, int end) {
		// start is 0, end will be the array.length - 1
		while (start < end) {
			int temp = numbers[start]; // stores the value at the beginning of the array

			numbers[start] = numbers[end]; // Assign the value of the end index to the start

			numbers[end] = temp; // Assigns the value of the prev start index to the end

			start++; // Traverses down the array to the next value

			end--; // Allows for respective swap with the next value of number[start]
		}

	}

	public static void findMinValue(int[] numbers, int start, int end) {

		if (numbers == null || numbers.length == 0) { // Catch empty arrays
			throw new IllegalArgumentException("Invalid Input");
		}

		int min = numbers[start]; // Holds the minimum value of the array, starting from index 0

		for (int i = 1; i < numbers.length; i++) {
			if (numbers[i] < min) {
				min = numbers[i];
			}
		}

		System.out.println(min);

	}

	// Useful additional algorithms

	public void moveZeros(int[] numbers, int n) {
		// n is the length of the array
		int j = 0; // pointer that focuses on elements that are '0'

		for (int i = 0; i < n; i++) { // pointer that focuses on elements that are NON-ZERO
			if (numbers[i] != 0 && numbers[j] == 0) {
				int temp = numbers[i]; // Store i'th index number
				numbers[i] = numbers[j]; // Number at i'th takes the value of 0
				numbers[j] = temp; // Swap is completed between i'th and j'th position
			}

			if (numbers[j] != 0) {
				j++; // Allows j to move to the next index until it reaches 0
			}

		}

	}

	public int[] resize(int[] numbers, int newLength) {
		
		int[] temp = new int[newLength]; // making a new temp array, new capacity based on newLength

		for (int i = 0; i < numbers.length; i++) { // Loops through each element
			
			temp[i] = numbers[i]; // Assigns each index in temp to element in given array, 'numbers'

		}

		numbers = temp;
		return numbers; 
		
		// Must return the resized array***
		// Allows for storing of the resized array straight from the top of the heap's memory
	}
	
	public boolean isPalindrome (String word) {
		
		char[] checkPalindrome = word.toCharArray(); // **Convert string to array of chars
		int start = 0; // start index 
		int end = checkPalindrome.length - 1; // The last index of the array
		
		while (start < end) { // Not '!=', to eliminate the error when it hits the middle element
			
			if (checkPalindrome[start] != checkPalindrome[end]) {
				return false; // if at any point the letters don't match, conclude false
			}
			start++;
			end--;
		}
		return true;
	}

	public static void main(String[] args) {
		OneDimensionalArray oda = new OneDimensionalArray();
		int[] myArray = new int[5];
		myArray[0] = 3;
		myArray[1] = 0;
		myArray[2] = 2;
		myArray[3] = 4;
		myArray[4] = 5;

		oda.printArray(myArray);
		int[] newarray = oda.resize(myArray, 10);
		oda.printArray(newarray);

	}
}
