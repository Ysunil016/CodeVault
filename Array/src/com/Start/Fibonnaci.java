package com.Start;

public class Fibonnaci {
	static int[] fibStore = new int[11];

	public static void main(String[] args) {
//		int positon = 7;
//		System.out.println(recursiveFib(positon));
		System.out.println(iterativeFib(6));
	}

	public static int recursiveFib(int position) {
		if (position < 2)
			return position;
		if (fibStore[position] != 0)
			return fibStore[position];
		else
			fibStore[position] = recursiveFib(position - 1) + recursiveFib(position - 2);

		return fibStore[position];
	}

	public static int iterativeFib(int position) {
		if (position < 2)
			return position;
		int sLast = 0;
		int Last = 1;
		int currentPos = 2;
		while (currentPos <= position) {
			int temp = sLast;
			sLast = Last;
			Last = temp + Last;
			currentPos++;
		}
		return Last;
	}

}
