package StackQueue;

import java.util.Stack;

public class QueueUsingTwoStacks {
	static Stack<Integer> s1 = new Stack<Integer>();
	static Stack<Integer> s2 = new Stack<Integer>();

	public static void main(String[] args) {
		insert(10);
		insert(20);
		insert(30);
		System.out.println(remove());
		insert(10);
		insert(20);
		insert(30);
		System.out.println(remove());
		System.out.println(remove());
		System.out.println(remove());
		System.out.println(remove());
		System.out.println(remove());
		System.out.println(remove());

	}

	static void insert(int B) {
		s1.push(B);
	}

	static int remove() {
		if (s2.isEmpty()) {
			while (!s1.isEmpty()) {
				int data = s1.pop();
				s2.push(data);
			}
			if (s2.isEmpty())
				return -1;
			return s2.pop();
		} else {
			return s2.pop();
		}
	}
}
