package StackQueue;

import java.util.Scanner;
import java.util.Stack;

public class StackUsingTwoQueue {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		int[] arr = { 3, 4, 5, 2, 8, 6, 1 };
		nextLargest(arr);
	}

	static void nextLargest(int arr[]) {
		Stack<Integer> s = new Stack<Integer>();
		int n = arr.length;
		int arr1[] = new int[arr.length];
		for (int i = n - 1; i >= 0; i--) {
			while (!s.isEmpty() && s.peek() <= arr[i])
				s.pop();
			if (s.empty())
				arr1[i] = -1;
			else
				arr1[i] = s.peek();
			s.push(arr[i]);
		}

		for (int i = 0; i < n; i++)
			System.out.println(arr1[i]+" ");

	}
}
