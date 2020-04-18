package Stack;

import java.util.Scanner;
import java.util.Stack;

public class SpecialStack {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		int count = scan.nextInt();
		Stack<Integer> stack = new Stack<Integer>();
		GFG specialOps = new GFG();
		while (count-- > 0) {
			while (!specialOps.isFull(stack, count)) {
				specialOps.push(scan.nextInt(), stack);
			}
		}

		System.out.println(specialOps.min(stack));
	}

}

class GFG {

	static Stack<Integer> minStack = new Stack<Integer>();
	static int totalCount = 0;

	public void push(int a, Stack<Integer> s) {
		s.push(a);
		totalCount++;
		if (!minStack.isEmpty()) {
			if (a <= minStack.peek())
				minStack.push(a);
		} else
			minStack.push(a);
	}

	public int pop(Stack<Integer> s) {
		totalCount--;
		int poop = s.pop();
		if (!minStack.isEmpty())
			if (poop == minStack.peek())
				minStack.pop();
		return poop;
	}

	public int min(Stack<Integer> s) {
		if (!minStack.isEmpty()) {
			return minStack.peek();
		}
		return -1;
	}

	public boolean isFull(Stack<Integer> s, int n) {
		if (n < totalCount)
			return true;
		return false;
	}

	public boolean isEmpty(Stack<Integer> s) {
		if (s.isEmpty())
			return true;

		return false;
	}

}
