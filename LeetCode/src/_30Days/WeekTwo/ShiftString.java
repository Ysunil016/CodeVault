package _30Days.WeekTwo;

import java.util.Deque;
import java.util.LinkedList;

public class ShiftString {

	public static void main(String[] args) {
		String s = "abc";
		int[][] arr = {{0,1},{1,2}};
		System.out.println(stringShift(s, arr));
	}

	public static String stringShift(String s, int[][] shift) {
		Deque<Character> queue = new LinkedList<Character>();
		char[] strA = s.toCharArray();
		for (char x : strA)
			queue.add(x);

		for (int[] arr : shift) {
			switch (arr[0]) {
			// Left Shift
			case 0:
				for (int i = 0; i < arr[1]; i++)
					queue.addLast(queue.poll());
				break;
			case 1:
				for (int i = 0; i < arr[1]; i++)
					queue.addFirst(queue.pollLast());
				break;
			}
		}

		StringBuilder builder = new StringBuilder();
		while (!queue.isEmpty()) {
			builder.append(queue.poll());
		}
		
		return new String(builder);
	}

}
