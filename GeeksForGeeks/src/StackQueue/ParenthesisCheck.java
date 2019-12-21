package StackQueue;

import java.util.Scanner;
import java.util.Stack;

public class ParenthesisCheck {
	static Scanner scan = new Scanner(System.in);
	static Stack<Character> stackStore = new Stack<Character>();

	public static void main(String[] args) {
		int testCase = scan.nextInt();
		scan.nextLine();
		for (int i = 0; i < testCase; i++) {
			String inputS = scan.nextLine();
			if(isPalidrome(inputS)) {
				System.out.println("balanced");
			}else
				System.out.println("not balanced");
		}
	}

	static boolean isPalidrome(String inputS) {
		for (int i = 0; i < inputS.length(); i++) {
			switch (inputS.charAt(i)) {
			case '[':
				push('[');
				break;
			case '{':
				push('{');
				break;
			case '(':
				push('(');
				break;
			case ')':
				if (pop() != '(')
					return false;
				break;
			case '}':
				if (pop() != '{')
					return false;
				break;
			case ']':
				if (pop() != '[')
					return false;
				break;

			}
		}

		if (!stackStore.isEmpty())
			return false;

		return true;
	}

	static void push(char data) {
		stackStore.push(data);
	}

	static char pop() {
		if (!stackStore.isEmpty()) {
			return stackStore.pop();
		}
		return '#';
	}

}
