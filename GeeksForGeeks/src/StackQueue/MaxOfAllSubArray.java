package StackQueue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class MaxOfAllSubArray {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
//		int[] arr = { 1, 2, 3, 1, 4, 5, 2, 3, 6 };
//		int win = 3;
//		getMaxOfSubArray(arr, win);

		int testCase = scan.nextInt();
		scan.nextLine();
		for (int i = 0; i < testCase; i++) {
			int count = scan.nextInt();
			int window = scan.nextInt();
			int[] arr = new int[count];
			scan.nextLine();
			for (int j = 0; j < count; j++) {
				arr[j] = scan.nextInt();
			}
//			getMaxOfSubArray(arr, window);
			printMax(arr, window);
			System.out.println();
		}

	}

	static void printMax(int[] arr, int window) {
		int n = arr.length;
		Deque<Integer> Qi = new LinkedList<Integer>();

		int i;
		for (i = 0; i < window; ++i) {
			while (!Qi.isEmpty() && arr[i] >= arr[Qi.peekLast()])
				Qi.removeLast();
			Qi.addLast(i);
		}

		for (; i < n; ++i) {
			System.out.print(arr[Qi.peek()] + " ");

			// Remove the elements which are out of this window
			while ((!Qi.isEmpty()) && Qi.peek() <= i - window)
				Qi.removeFirst();

			// Remove all elements smaller than the currently
			// being added element (remove useless elements)
			while ((!Qi.isEmpty()) && arr[i] >= arr[Qi.peekLast()])
				Qi.removeLast();

			// Add current element at the rear of Qi
			Qi.addLast(i);
		}

		// Print the maximum element of last window
		System.out.print(arr[Qi.peek()]);

	}

	// No Stack Used
	static void getMaxOfSubArray(int[] arr, int window) {
		int len = arr.length;

		for (int i = 0; i <= len - window; i++) {
			int max = 0;
			for (int j = i; j < window + i; j++) {
				max = (max < arr[j]) ? arr[j] : max;
			}
			System.out.print(max + " ");
		}

	}

}
