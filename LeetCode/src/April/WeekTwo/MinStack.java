package April.WeekTwo;

import java.util.Stack;

public class MinStack {

	public static void main(String[] args) {
		MinStackSolution minStack = new MinStackSolution();
		minStack.push(512);
		minStack.push(-1024);
		minStack.push(-1024);
		minStack.push(512);
		minStack.pop();
		System.out.println(minStack.getMin());
		minStack.pop();
		System.out.println(minStack.getMin());
		minStack.pop();
		System.out.println(minStack.getMin());
	}

}

class MinStackSolution {

	Stack<Integer> stack;
	Stack<Integer> minStack;

	public MinStackSolution() {
		stack = new Stack<Integer>();
		minStack = new Stack<Integer>();
	}

	public void push(int x) {
		stack.push(x);
		if (minStack.isEmpty())
			minStack.push(x);
		else if (minStack.peek() >= x)
			minStack.push(x);
	}

	public void pop() {
		int pop = stack.pop();
		if (pop == minStack.peek()) {
			minStack.pop();
		}
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return minStack.peek();
	}
}
