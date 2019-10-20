package Stack;

import java.util.Scanner;
import java.util.Stack;

public class MaxElement {
	static Stack<Integer> abStack = new Stack<Integer>();
	static Stack<Integer> minStack = new Stack<Integer>();
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		int count = scan.nextInt();
		for (int i = 0; i < count; i++) {
			int actionKey = scan.nextInt();
			switch (actionKey) {
			case 1:
				pushInStack();
				break;
			case 2:
				popInStack();
				break;
			case 3:
				printStack();
				break;

			default:
				break;
			}
		}
		scan.close();
	}

	public static void pushInStack() {
		int data2Push = scan.nextInt();
		abStack.push(data2Push);
		if (!minStack.isEmpty()) {
			if (data2Push > minStack.peek()) {
				minStack.push(data2Push);
			}
		} else {
			minStack.push(data2Push);
		}
	}

	public static void popInStack() {
		int poopedOut = abStack.pop();
		if (!minStack.isEmpty()) {
			if (poopedOut == minStack.peek()) {
				minStack.pop();
			}
		}
	}

	public static void printStack() {
		if (!minStack.isEmpty())
			System.out.println(minStack.peek());
	}

}
