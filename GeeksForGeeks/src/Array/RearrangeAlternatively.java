package Array;

/*
Given a sorted array of positive integers. Your task is to rearrange  the array elements alternatively i.e first element should be max value, second should be min value, third should be second max, fourth should be second min and so on...

Note: O(1) extra space is allowed. Also, try to modify the input array as required.

Input:
First line of input contains number of test cases T. First line of test case contain an integer denoting the array size N and second line of test case contain N space separated integers denoting the array elements.

Output:
Output the modified array with alternated elements.

Constraints:
1 <=T<= 100
1 <=N<= 107
1 <=arr[i]<= 107

Example:
Input:
2
6
1 2 3 4 5 6
11 
10 20 30 40 50 60 70 80 90 100 110

Output:
6 1 5 2 4 3
110 10 100 20 90 30 80 40 70 50 60

Explanation:
Testcase 1: Max element = 6, min = 1, second max = 5, second min = 2, and so on... Modified array is : 6 1 5 2 4 3.

 */

public class RearrangeAlternatively {

//	1 2 3 4 5 6
//	6 1 5 2 4 3

	public static void main(String[] args) {

		int[] array = { 1, 2, 3, 4, 5, 6 };
		rearrangedSequence(array);
	}

	// Brutforce => Jugad
	// Spliting Aray into Left and Right Sub Arrays and Then Combining for Desired
	// Result
	static void rearrangedSequence(int[] array) {
		int arrayLen = array.length;
		int arrLenMid = (arrayLen / 2);
		int[] leftArray = new int[arrLenMid];
		int[] rightArray = new int[arrLenMid];

		for (int i = 0; i < arrayLen; i++) {
			if (i < arrayLen / 2) {
				leftArray[i] = array[i];
			} else {
				rightArray[i - arrLenMid] = array[i];
			}
		}
		printArray(leftArray);
		System.out.println();
		printArray(rightArray);

		MERGEARRAY(leftArray, rightArray);
	}

	static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++)
			System.out.println(array[i]);
	}

	static void MERGEARRAY(int[] left, int[] right) {
		int[] result = new int[left.length + right.length];

		int resultCounter = 0;
		for (int i = 0; i < left.length; i++) {
			result[resultCounter] = right[right.length - 1 - i];
			result[resultCounter + 1] = left[i];
			resultCounter += 2;
		}
		System.out.println();
		printArray(result);

	}
}
