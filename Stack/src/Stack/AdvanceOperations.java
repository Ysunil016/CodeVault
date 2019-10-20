package Stack;

import java.util.Stack;

public class AdvanceOperations<Char> {
	static Stack<Integer> stackOne = new Stack<Integer>();
	static Stack<Integer> stackTwo = new Stack<Integer>();

	public String isBalanced(String s) {
		Stack<Character> stackStore = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			switch (s.charAt(i)) {
			case '{':
			case '[':
			case '(':
				stackStore.push(s.charAt(i));
				break;
			case '}':
				if (stackStore.isEmpty())
					return "NO";
				if (stackStore.pop() != '{')
					return "NO";
				break;
			case ']':
				if (stackStore.isEmpty())
					return "NO";
				if (stackStore.pop() != '[')
					return "NO";
				break;
			case ')':
				if (stackStore.isEmpty())
					return "NO";
				if (stackStore.pop() != '(')
					return "NO";
				break;
			}

		}
		if (stackStore.isEmpty())
			return "YES";
		return "NO";
	}

	public void pushDataToStackMaxStack(int data) {
		stackOne.push(data);
		if (!stackTwo.isEmpty()) {
			if (stackTwo.peek() < data) {
				stackTwo.push(data);
			}
		} else {
			stackTwo.push(data);
		}

	}

	public int maxStack() {
		return stackTwo.peek();
	}

	public void popStack() {
		if (stackTwo.peek() == stackOne.pop())
			stackTwo.pop();
	}

}
