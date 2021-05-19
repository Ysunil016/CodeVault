package Array;

import java.util.Scanner;

/*
 Given an unsorted array A of size N of non-negative integers, find a continuous sub-array which adds to a given number S.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of two lines. The first line of each test case is N and S, where N is the size of array and S is the sum. The second line of each test case contains N space separated integers denoting the array elements.

Output:
For each testcase, in a new line, print the starting and ending positions(1 indexing) of first such occuring subarray from the left if sum equals to subarray, else print -1.

Constraints:
1 <= T <= 100
1 <= N <= 107
1 <= Ai <= 1010

Example:
Input:
2
5 12
1 2 3 7 5
10 15
1 2 3 4 5 6 7 8 9 10
Output:
2 4
1 5

Explanation :
Testcase1: sum of elements from 2nd position to 4th position is 12
Testcase2: sum of elements from 1st position to 5th position is 15
 */

public class SubarrayWithGivenSum {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		int testCases = scan.nextInt();
		// Getting Data for Fetching
		for (int i = 0; i < testCases; i++) {
			int arraySize = scan.nextInt();
			int sumTotal = scan.nextInt();

			// Storing Array Data in Array of Integer Type
			int[] array = new int[arraySize];
			for (int j = 0; j < arraySize; j++) {
				array[j] = scan.nextInt();
			}

			// Calling Function to find if there is any Combination BruteForce
			int[] result = SubarrayWithGivenSumMethodOne(array, sumTotal);

			if (result != null)
				System.out.println(result[0] + " " + result[1]);
			else
				System.out.println(-1);
		}

	}

	// Brute Force Solution with Complexity ~ O(n^2)
	static int[] SubarrayWithGivenSumMethodOne(int[] array, int sumTotal) {

		// Finding SubArray from Given Array has Complexity O(n^2)
		for (int i = 0; i < array.length; i++) {
			int[] resultArray = new int[2];
			int sum = 0;
			for (int j = i; j < array.length; j++) {
				sum += array[j];
				// If Condition Meet
				if (sum == sumTotal) {
					resultArray[0] = i + 1;
					resultArray[1] = j + 1;
					return resultArray;
				}
			}
		}
		return null;
	}

	// Optimum Solution with Complexity ~ O(n)
	// ************ It Doesn't Support for Negative Values
	static int[] SubarrayWithGivenSumMethodTwo(int[] array, int sumTotal) {

		int currentSum = array[0];
		int start = 0;
		int[] result = new int[2];
		// Finding SubArray from Given Array has Complexity O(n^2)
		for (int i = 1; i < array.length; i++) {

			// Checking if Current Total Index's Sum Overflows sumTotal
			while (currentSum > sumTotal && start < i - 1) {
				currentSum -= array[start];
				start++;
			}

			// If First CurrentSum is Found then Return
			if (currentSum == sumTotal) {
				result[0] = start + 1;
				result[1] = i;
				return result;
			}

			if (i < array.length)
				currentSum += array[i];

		}
		return null;
	}

}
