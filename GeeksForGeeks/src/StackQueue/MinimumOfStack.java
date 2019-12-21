package StackQueue;

import java.util.Scanner;
import java.util.Stack;

public class MinimumOfStack {

	static Scanner scan = new Scanner(System.in);
	
	static Stack<Integer> stackS = new Stack<Integer>();
	static Stack<Integer> minStack = new Stack<Integer>();

	public static void main(String[] args) {
		push(2);
		push(3);
		pop();
		push(20);
		push(10);
		pop();
		push(30);
		push(40);
		pop();
		pop();
		pop();
		pop();
		push(30);
		push(40);

		System.out.println(stackS);
		System.out.println();
		System.out.println(minStack);
	}

	static void push(int data) {
		stackS.push(data);
		if (minStack.isEmpty()) {
			minStack.push(data);
		} else {
			int tempData = minStack.pop();
			if (data <= tempData) {
				minStack.push(tempData);
				minStack.push(data);
			} else {
				minStack.push(tempData);
			}
		}
	}

	static int pop() {
		if (!stackS.isEmpty()) {
			int temp = minStack.pop();
			if (stackS.pop() != temp)
				minStack.push(temp);
			return -1;
		}
		return -1;
	}

}
