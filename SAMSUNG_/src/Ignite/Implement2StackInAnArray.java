package Ignite;

public class Implement2StackInAnArray {

	public static void main(String[] args) {
		implement2StackUsingArray();
	}

	static int[] arrStack = new int[20];

	static void implement2StackUsingArray() {
		// Initiating Single Array of Length of 200 - 100 for StackOne and 100 for
		// StackTwo

//		int[] operations = { 1, 1, 2, 1, 1, 3, 2, 1, 4, 1, 2, 2, 2, 2, 2 }; // 112113214122222
		int[] operations = { 1, 1, 2, 2, 2, 1, 2, 2, 2 };

		for (int i : arrStack)
			arrStack[i] = 0;

		int counter = 0;
		while (counter < operations.length) {
			if (operations[counter] == 1) {
				// Operations Stack One
				if (operations[counter + 1] == 1) {
					pushStackOne(operations[counter + 2]);
					counter += 3;
				} else {
					popStackOne();
					counter += 2;
				}
			} else {
				// Operations Stack Two
				if (operations[counter + 1] == 1) {
					pushStackTwo(operations[counter + 2]);
					counter += 3;
				} else {
					popStackTwo();
					counter += 2;
				}
			}

		}

		for (int i : arrStack)
			System.out.print(" " + i);

	}

	static void popStackOne() {
		// Removing from Left Side of Array -> Arr/2
		int bottom = arrStack.length / 2;
		// Checking if Stack is Empty
		if (arrStack[bottom] == 0) {
			System.out.println(-1);
			return;
		}
		// If Stack Has ELement then Traverse from Left -> Middle until we find 0;
		int counter = 0;
		while (arrStack[counter] == 0 && counter <= bottom) {
			counter++;
		}
		if (arrStack[counter] != 0) {
			System.out.println(arrStack[counter]);
			arrStack[counter] = 0;
		}
	}

	static void popStackTwo() {
		// Removing from -> Right Side - > Arr/2
		int bottom = arrStack.length / 2 + 1;

		if (arrStack[bottom] == 0) {
			System.out.println(-1);
			return;
		}
		// If Stack Has ELement then Traverse from Middle -> Right until we find 0;
		int counter = arrStack.length - 1;
		while (arrStack[counter] == 0 && counter >= bottom) {
			counter--;
		}
		if (arrStack[counter] != 0) {
			System.out.println(arrStack[counter]);
			arrStack[counter] = 0;
		}

	}

	static void pushStackOne(int val) {
		// Push in At Left Side
		int bottom = arrStack.length / 2;
		int counter = 0;
		while (arrStack[counter] == 0 && counter < bottom) {
			counter++;
		}
		if (arrStack[counter] != 0 && counter != 0) {
			arrStack[counter - 1] = val;
		} else if (counter == bottom) {
			arrStack[counter] = val;
		}
	}

	static void pushStackTwo(int val) {
		// Push at Right Side
		int bottom = arrStack.length / 2 + 1;
		int counter = arrStack.length - 1;
		while (arrStack[counter] == 0 && counter > bottom) {
			counter--;
		}
		if (arrStack[counter] != 0 && counter != arrStack.length - 1) {
			arrStack[counter + 1] = val;
		} else if (counter == bottom) {
			arrStack[counter] = val;
		}
	}

}
