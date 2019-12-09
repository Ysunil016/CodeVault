package Array;

/*
Given an array of distinct integers. The task is to count all the triplets such that sum of two elements equals the third element.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of two lines. First line of each test case contains an Integer N denoting size of array and the second line contains N space separated elements.

Output:
For each test case, print the count of all triplets, in new line. If no such triplets can form, print "-1".

Constraints:
1 <= T <= 100
3 <= N <= 105
1 <= A[i] <= 106

Example:
Input:
2
4
1 5 3 2
3
3 2 7
Output:
2
-1

Explanation:
Testcase 1: There are 2 triplets: 1 + 2 = 3 and 3 + 2 = 5


 */

public class CountTriplets {

	public static void main(String[] args) {

		int[] inputs = { 1, 1, 1, 2, 2 };

		System.out.println(findAllTriplestOfAnArray(inputs));

	}

	static int findAllTriplestOfAnArray(int[] array) {
		int arrayLength = array.length;
		int resultCounter = 0;
		for (int i = 0; i < arrayLength - 1; i++) {
			for (int j = i; j < arrayLength; j++) {
				if (i != j) {
					int pairSum = array[i] + array[j];
					if (elementPresentInArray(pairSum, array)) {
						resultCounter++;
					}
				}
			}

		}

		return resultCounter;
	}

	static boolean elementPresentInArray(int key, int[] array) {
		for (int i = 0; i < array.length; i++)
			if (key == array[i])
				return true;
		return false;
	}

}
