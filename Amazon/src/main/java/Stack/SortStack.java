package Stack;

import java.util.Stack;

public class SortStack {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			{
				push(11);
				push(2);
				push(32);
				push(3);
				push(41);
			}
		};

		stack = sort(stack);
		while (!stack.isEmpty())
			System.out.print(stack.pop() + " ");
	}

	static Stack<Integer> sort(Stack<Integer> stack) {
		Stack<Integer> fStack = new Stack<Integer>();
		while (!stack.isEmpty()) {
			int pop = stack.pop();
			if (fStack.isEmpty())
				fStack.push(pop);
			else {
				if (fStack.peek() < pop)
					fStack.push(pop);
				else {
					while (!fStack.isEmpty() && fStack.peek() > pop) {
						stack.push(fStack.pop());
					}
					fStack.push(pop);
				}
			}
		}

		return fStack;
	}

}
