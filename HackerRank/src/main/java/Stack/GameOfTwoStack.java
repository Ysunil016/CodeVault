package Stack;

import java.util.Stack;

public class GameOfTwoStack {

	public static void main(String[] args) {
		int a[] = { 4, 2, 4, 6, 1 };
		int b[] = { 2, 1, 8, 5 };
		System.out.println(twoStacks(10, a, b));
	}

	static int twoStacks(int x, int[] a, int[] b) {
		Stack<Integer> aStack = new Stack<Integer>();
		Stack<Integer> bStack = new Stack<Integer>();

		for (int i = a.length - 1; i >= 0; i--) {
			aStack.push(a[i]);
		}
		for (int i = b.length - 1; i >= 0; i--) {
			bStack.push(b[i]);
		}

		int sum = 0;
		int move = 0;
		while (sum <= x && !aStack.isEmpty() && !bStack.isEmpty()) {
			if (aStack.peek() > bStack.peek()) {
				sum += bStack.pop();
				move++;
			} else {
				sum += aStack.pop();
				move++;
			}
		}

		while (!aStack.isEmpty() && sum <= x) {
			sum += aStack.pop();
			move++;
		}
		while (!bStack.isEmpty() && sum <= x) {
			sum += bStack.pop();
			move++;
		}

		if (move == 0)
			return 0;

		return move - 1;
	}

}
