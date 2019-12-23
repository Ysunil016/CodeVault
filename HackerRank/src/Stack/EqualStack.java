package Stack;

import java.util.Stack;

public class EqualStack {

	public static void main(String[] args) {
		int[] a1 = { 3, 2, 1, 1, 1 };
		int[] a2 = { 4, 3, 2 };
		int[] a3 = { 1, 1, 4, 1 };

		Stack<Integer> stackOne = new Stack<Integer>();
		Stack<Integer> stackTwo = new Stack<Integer>();
		Stack<Integer> stackThree = new Stack<Integer>();

		for (int i = a1.length - 1; i >= 0; i--) {
			stackOne.push(a1[i]);
		}
		for (int i = a2.length - 1; i >= 0; i--) {
			stackTwo.push(a2[i]);
		}
		for (int i = a3.length - 1; i >= 0; i--) {
			stackThree.push(a3[i]);
		}

		System.out.println(getEqualStackPos(stackOne, stackTwo, stackThree));

//		3 2 1 1 1
//		4 3 2
//		1 1 4 1

	}

	static int getEqualStackPos(Stack<Integer> stackOne, Stack<Integer> stackTwo, Stack<Integer> stackThree) {
		while (!areStackEqual(stackOne, stackTwo, stackThree)) {
			switch (maxStackHeight(stackOne, stackTwo, stackThree)) {
			case 1:
				stackOne.pop();
				break;
			case 2:
				stackTwo.pop();
				break;
			case 3:
				stackThree.pop();
				break;
			}

		}

		return getStackHeight(stackOne);
	}

	static int maxStackHeight(Stack<Integer> stackOne, Stack<Integer> stackTwo, Stack<Integer> stackThree) {
		int stackHOne = getStackHeight(stackOne);
		int stackHTwo = getStackHeight(stackTwo);
		int stackHThree = getStackHeight(stackThree);

		if (stackHOne >= stackHTwo && stackHOne >= stackHThree) {
			return 1;
		} else {
			if (stackHTwo >= stackHThree) {
				return 2;
			} else {
				return 3;
			}
		}
	}

	static int getStackHeight(Stack<Integer> stack) {
		int max = 0;
		Stack<Integer> stackN = new Stack<Integer>();
		while (!stack.isEmpty()) {
			stackN.push(stack.peek());
			max += stack.pop();
		}

		while (!stackN.isEmpty()) {
			stack.push(stackN.pop());
		}
		return max;
	}

	static boolean areStackEqual(Stack<Integer> stackOne, Stack<Integer> stackTwo, Stack<Integer> stackThree) {
		if (getStackHeight(stackOne) == getStackHeight(stackTwo)) {
			if (getStackHeight(stackOne) == getStackHeight(stackThree)) {
				return true;
			} else
				return false;
		} else
			return false;
	}

}
