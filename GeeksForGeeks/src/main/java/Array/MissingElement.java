package Array;

/*
Given an array C of size N-1 and given that there are numbers from 1 to N with one element missing, the missing number is to be found.

Input:
The first line of input contains an integer T denoting the number of test cases. For each test case first line contains N(size of array). The subsequent line contains N-1 array elements.

Output:
Print the missing number in array.

Constraints:
1 ≤ T ≤ 200
1 ≤ N ≤ 107
1 ≤ C[i] ≤ 107

Example:
Input:
2
5
1 2 3 5
10
1 2 3 4 5 6 7 8 10

Output:
4
9

Explanation:
Testcase 1: Given array : 1 2 3 5. Missing element is 4.


 */

public class MissingElement {

	public static void main(String[] args) {

		int[] input = { 1, 3,4, 5,6,7};
		int[] input2 = { 1, 2, 3, 5, 6, 7, 8 };

//		System.out.println("Missing Element is " + findMissingElement(input, input.length + 1));

		//
//		System.out.println("Missing Element is " + findMissingElement2(input, input.length + 1));

		//
		System.out.println("Missing Element is " + findMissingElement3(input, input.length));
		System.out.println("Missing Element is " + findMissingElement3(input2, input2.length));

	}

	// Normal BruteForce - O(n)
	static int findMissingElement(int[] array, int totalSize) {
		int missingElement = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] != i + 1) {
				missingElement = i + 1;
				break;
			}
		}
		return missingElement;
	}

	// Interesting Approach
	static int findMissingElement2(int[] array, int totalSize) {
		int totalMax = 0;
		int foundSum = 0;
		for (int i = 0; i < totalSize; i++) {
			totalMax += i + 1;
		}

		for (int i = 0; i < array.length; i++) {
			foundSum += array[i];
		}

		return totalMax - foundSum;
	}

	static int findMissingElement3(int[] array, int totalSize) {
		int x2 = 1;
		int x1 = array[0];
		for (int j = 1; j < totalSize; j++) {
			x1 = x1 ^ array[j];
		}
		for (int j = 2; j <= totalSize + 1; j++) {
			x2 = x2 ^ j;
		}

		return (x1 ^ x2);
	}

}
