package Array;

/*
Given two sorted arrays arr1[] and arr2[] in non-decreasing order with size n and m. The task is to merge the two sorted arrays into one sorted array (in non-decreasing order).

Note: Expected time complexity is O((n+m) log(n+m)). DO NOT use extra space.  We need to modify existing arrays as following.

Input: arr1[] = {10};
       arr2[] = {2, 3};
Output: arr1[] = {2}
        arr2[] = {3, 10}  

Input: arr1[] = {1, 5, 9, 10, 15, 20};
       arr2[] = {2, 3, 8, 13};
Output: arr1[] = {1, 2, 3, 5, 8, 9}
        arr2[] = {10, 13, 15, 20} 
Input:
First line contains an integer T, denoting the number of test cases. First line of each test case contains two space separated integers X and Y, denoting the size of the two sorted arrays. Second line of each test case contains X space separated integers, denoting the first sorted array P. Third line of each test case contains Y space separated integers, denoting the second array Q.

Output:
For each test case, print (X + Y) space separated integer representing the merged array.

Constraints:
1 <= T <= 100
1 <= X, Y <= 5*104
0 <= arr1i, arr2i <= 109

Example:
Input:
2
4 5
1 3 5 7
0 2 6 8 9
2 3
10 12
5 18 20

Output:
0 1 2 3 5 6 7 8 9
5 10 12 18 20

Explanation:
Testcase 1: After merging two non-decreasing arrays, we have, 0 1 2 3 5 6 7 8 9.


 */

public class MergingTwoSortedArray {

	public static void main(String[] args) {

		int[] array1 = { 1, 5, 9, 10, 15, 20 };
		int[] array2 = { 2, 3, 8, 13 };
		MERGE_WITHOUT_EXTRA_SPACE(array1, array2);
	}

	public static int[] MERGE_WITHOUT_EXTRA_SPACE(int[] arr, int[] arr2) {
		int a1Len = arr.length;
		int a2Len = arr2.length;

		// Iterating Array 2 from Last
		for (int i = a2Len - 1; i >= 0; i--) {

			// Storing its last Index Value in Variable
			int last = arr[a1Len - 1];
			int j;

			// Checking Condition and Shifting Indices to One Point Starting from Second
			// Last Index of Array 1
			for (j = a1Len - 2; j >= 0 && arr[j] > arr2[i]; j--) {
				arr[j + 1] = arr[j];
			}

			// If there is any Shift or last(arr1[len-1]) > arr2[i]
			if (j != a2Len - 2 || last > arr2[i]) {
				arr[j + 1] = arr2[i];
				arr2[i] = last;
			}

		}

		printArray(arr);
		System.out.println();
		printArray(arr2);

		return arr;
	}

	static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}

}
