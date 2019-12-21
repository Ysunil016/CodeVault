package StackQueue;

import java.util.Scanner;
import java.util.Stack;

public class NextLargestElement {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		int testCase = scan.nextInt();
		scan.nextLine();
		for (int i = 0; i < testCase; i++) {
			int elemCount = scan.nextInt();
			int arr[] = new int[elemCount];
			for (int j = 0; j < elemCount; j++) {
				arr[j] = scan.nextInt();
			}
			printLargestNode(arr, elemCount);
		}
	}

	static void printLargestNode(int arr[], int n) {
		int i = 0;
		Stack<Integer> s = new Stack<Integer>();
		int element, next;
		s.push(arr[0]);
		for (i = 1; i < n; i++) {
			next = arr[i];
			if (s.isEmpty() == false) {
				element = s.pop();
				while (element < next) {
					System.out.print(next + " ");
					if (s.isEmpty() == true)
						break;
					element = s.pop();
				}
				if (element > next)
					s.push(element);
			}
			s.push(next);
		}
		while (s.isEmpty() == false) {
			element = s.pop();
			next = -1;
			System.out.print(next + " ");
		}
	}
}
