package Array;

public class MoveZeroToEnd {

	public static void main(String[] args) {

		int[] in = { 0, 0, 0, 0, 0, 2, 0, 2, 3, 4, 5, 0 };
		move(in);
		for (int x : in) {
			System.out.print(x + " ");
		}

	}

	static void move(int[] arr) {

		int slowPointer = 0;
		int fastPointer = 0;
		while (fastPointer != arr.length) {
			if (arr[fastPointer] != 0 && arr[slowPointer] == 0) {
				arr[slowPointer] = arr[fastPointer];
				arr[fastPointer] = 0;
				slowPointer++;
			}
			if (arr[slowPointer] != 0)
				slowPointer++;

			fastPointer++;
		}
	}

}
