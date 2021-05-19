package General.StackP;

import java.util.Stack;

public class ParenthesesValidation {

	public static void main(String[] args) {
		System.out.println(isValid("[][][]{}{}{}({})"));
	}

	static boolean isValid(String input) {
		Stack<Character> stack = new Stack<Character>();
		char[] charA = input.toCharArray();

		for (int i = 0; i < charA.length; i++) {
			switch (charA[i]) {
			case '{':
				stack.push('{');
				break;
			case '(':
				stack.push('(');
				break;
			case '[':
				stack.push('[');
				break;

			case '}':
				if (stack.isEmpty())
					return false;
				if (stack.pop() != '{')
					return false;

				break;
			case ')':
				if (stack.isEmpty())
					return false;
				if (stack.pop() != '(')
					return false;
				break;
			case ']':
				if (stack.isEmpty())
					return false;
				if (stack.pop() != '[')
					return false;
				break;

			default:
				break;
			}
		}
		
		if(!stack.isEmpty()) return false;
		
		return true;
	}

}
