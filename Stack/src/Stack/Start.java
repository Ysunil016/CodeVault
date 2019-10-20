package Stack;

import java.util.Scanner;
import java.util.Stack;

public class Start {

	static Stack<Integer> stackOne = new Stack<Integer>();
	static Stack<Integer> stackTwo = new Stack<Integer>();

	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {

		AdvanceOperations<Character> aOperation = new AdvanceOperations<Character>();
//		System.out.println(aOperation.isBalanced("}][}}(}][))]"));
//		System.out.println(aOperation.isBalanced("[](){()}"));
//		System.out.println(aOperation.isBalanced("()"));
//		System.out.println(aOperation.isBalanced("({}([][]))[]()"));
//		System.out.println(aOperation.isBalanced("{)[](}]}]}))}(())("));
//		System.out.println(aOperation.isBalanced("([[)"));

//		int operations = input.nextInt();
//		for (int i = 0; i < operations; i++) {
//			int operation = input.nextInt();
//			switch (operation) {
//			case 1:
//				int data = input.nextInt();
//				enqueue(data);
//				break;
//			case 2:
//				dequeue();
//				break;
//			case 3:
//				peek();
//				break;
//		}

//		enqueue(10);
//		enqueue(20);
//		enqueue(30);
//		enqueue(40);
//		dequeue();
//		System.out.println();
//		System.out.println(peek());
//		dequeue();
//		dequeue();
//		System.out.println();
//		System.out.println(peek());

//		aOperation.pushDataToStackMaxStack(1);
//		aOperation.pushDataToStackMaxStack(2);
//		aOperation.pushDataToStackMaxStack(5);
//		aOperation.pushDataToStackMaxStack(4);
//		aOperation.pushDataToStackMaxStack(3);
//		aOperation.popStack();
//		aOperation.popStack();
//		aOperation.popStack();
//		System.out.println(aOperation.maxStack());

		Stack<Integer> unSorted = new Stack<Integer>();
		unSorted.add(5);
		unSorted.add(3);
		unSorted.add(9);
		unSorted.add(2);

		unSorted = sortStack(unSorted);
		System.out.println(unSorted);

	}

	static void enqueue(int data) {
		stackOne.push(data);
	}

	static int dequeue() {
		if (stackTwo.isEmpty()) {
			while (!stackOne.isEmpty())
				stackTwo.push(stackOne.pop());
			return stackTwo.pop();
		} else
			return stackTwo.pop();

	}

	static int peek() {
		if (stackTwo.isEmpty()) {
			while (!stackOne.isEmpty())
				stackTwo.push(stackOne.pop());
			return stackTwo.peek();
		} else
			return stackTwo.peek();
	}

	static Stack<Integer> sortStack(Stack<Integer> stack) {
		Stack<Integer> rem = new Stack<Integer>();
		while (!stack.empty()) {
			int pope = stack.pop();
			while (!rem.isEmpty() && rem.peek() > pope) {
				stack.push(rem.pop());
			}
			rem.push(pope);
		}
		while (!rem.isEmpty())
			stack.push(rem.pop());
		return stack;
	}

}
