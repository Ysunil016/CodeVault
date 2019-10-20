package com.Start;

public class SubArray {

	public static void main(String[] args) {
		int[] array = { 10, 12, 5, 7, 15 };
		// Finding all Sub Array of the INPUT
		for (int i = 0; i < array.length; i++) {
			for (int j = i; j < array.length; j++) {
				int[] tempArray = new int[j - i + 1];
				for (int k = i; k <= j; k++) {
					tempArray[k-i] = array[k];
				}
				isGoodArray(tempArray);
			}
		}

	}

	public static boolean isGoodArray(int[] inputArray) {
		for (int i = 0; i < inputArray.length; i++) {
			System.out.print(inputArray[i] + " ");
			
			
			
		}
		System.out.println();
		return false;
	}

}
