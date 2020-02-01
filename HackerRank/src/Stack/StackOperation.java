package Stack;

import java.util.Stack;

public class StackOperation {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(5);
		stack.push(3);
		stack.push(3);
		stack.push(4);
		stack.push(2);
		stack.push(1);
		stack.push(5);

		System.out.println(getMax(stack, 4));
	}

	static int getMax(Stack<Integer> stack, int operations) {
		int max = Integer.MIN_VALUE;
		if (stack.isEmpty())
			return -1;
		
		for (int i = 0; i < operations - 1; i++) {
			if (!stack.isEmpty()) {
				int storeInt = stack.pop();
				if (max < storeInt)
					max = storeInt;
			} else {
				break;
			}
		}

		System.out.println(max);

		return max;
	}

}
