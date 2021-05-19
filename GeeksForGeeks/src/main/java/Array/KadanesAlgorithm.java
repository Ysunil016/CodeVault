package Array;

/*
Given an array arr of N integers. Find the contiguous sub-array with maximum sum.

Input:
The first line of input contains an integer T denoting the number of test cases. The description of T test cases follows. The first line of each test case contains a single integer N denoting the size of array. The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the array.

Output:
Print the maximum sum of the contiguous sub-array in a separate line for each test case.

Constraints:
1 ≤ T ≤ 110
1 ≤ N ≤ 106
-107 ≤ A[i] <= 107   

Example:
Input
2
5
1 2 3 -2 5
4
-1 -2 -3 -4
Output
9
-1

Explanation:
Testcase 1: Max subarray sum is 9 of elements (1, 2, 3, -2, 5) which is a contiguous subarray.
 */

//Since Input is Bound in 107 Range We can use XOR Operator to find if element is making Contigous MAXIMA
public class KadanesAlgorithm {

	public static void main(String[] args) {

		int[] array = { 1, 2, 3, -2, 5 };
		int[] array2 = { -1, -2, -3, -4 };

		System.out.println(findMaxContigousSubArray(array));
		System.out.println(findMaxContigousSubArray(array2));

		System.out.println();
	
	}

	// Generic BruteForce Approach
	static int findMaxContigousSubArray(int[] array) {
		int arrLength = array.length;
		int MAX = array[0];

		// Tracing for SubArray in Order to Find the Max of SubArray
		for (int i = 0; i < arrLength - 1; i++) {
			int tempSum = array[i];
			for (int j = i + 1; j < arrLength; j++) {
				tempSum += array[j];
				if (tempSum > MAX) {
					MAX = tempSum;
				}
			}
		}

		return MAX;
	}

	// Optimum Approach
	static int findMaxContigousSubArray2(int[] array) {
		int MAX = Integer.MIN_VALUE;
		int max_end = 0;
		for (int i = 0; i < array.length; i++) {
			max_end += array[i];
			if (MAX < max_end)
				MAX = max_end;
			if (max_end < 0)
				max_end = 0;
		}
		return MAX;
	}

}
