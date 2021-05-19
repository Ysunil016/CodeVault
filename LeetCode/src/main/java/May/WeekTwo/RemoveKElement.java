package May.WeekTwo;

import java.util.LinkedList;
import java.util.Stack;

public class RemoveKElement {

	public static void main(String[] args) {
		System.err.println(removeKdigitsOptamized("5337", 2));
	}

	public static String removeKdigits(String num, int k) {
		LinkedList<Character> link = new LinkedList<Character>();
		char[] arrY = num.toCharArray();

		if (arrY.length <= k) {
			return "0";
		}

		for (char x : arrY) {
			link.add(x);
		}

		int counter = 1;
		int prev = 0;
		int XCounter = 0;
		while (counter < link.size()) {

			if (XCounter == k)
				break;

			System.out.println("Prev " + prev + " and COunter " + counter);

			if (link.get(prev) > link.get(counter)) {
				System.out.println("Prev > Counter" + " with " + link.get(prev));
				link.remove(prev);
				XCounter++;
				if (counter != 1) {
					counter -= 1;
					prev -= 1;
				}
			}

			else if (counter == link.size() - 1) {
				link.remove(counter);
				XCounter++;
				counter--;
				prev--;
			} else {
				prev++;
				counter++;
			}
		}

		boolean firstZero = true;
		boolean hasOnlyZero = true;
		StringBuilder strB = new StringBuilder();
		for (char x : link) {
			if (x == '0') {
				if (!firstZero) {
					strB.append(x);
				}
			} else {
				hasOnlyZero = false;
				firstZero = false;
				strB.append(x);
			}
		}

		if (hasOnlyZero) {
			return "0";
		}

		return new String(strB);
	}

	public static String removeKdigitsOptamized(String num, int k) {
		LinkedList<Character> stack = new LinkedList<Character>();

		for (char digit : num.toCharArray()) {
			while (stack.size() > 0 && k > 0 && stack.peekLast() > digit) {
				stack.removeLast();
				k -= 1;
			}
			stack.addLast(digit);
		}

		/* remove the remaining digits from the tail. */
		for (int i = 0; i < k; ++i) {
			stack.removeLast();
		}

		// build the final string, while removing the leading zeros.
		StringBuilder ret = new StringBuilder();
		boolean leadingZero = true;
		for (char digit : stack) {
			if (leadingZero && digit == '0')
				continue;
			leadingZero = false;
			ret.append(digit);
		}

		/* return the final string */
		if (ret.length() == 0)
			return "0";
		return ret.toString();
	}

	
	// Best Solution
	public static String removeKdigitsOptamizedStack(String num, int k) {
		char[] charArray = num.toCharArray();
		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < charArray.length; i++) {
			while (k > 0 && !stack.isEmpty() && stack.peek() > charArray[i]) {
				stack.pop();
				k--;
			}
			stack.push(charArray[i]);
			i++;
		}
		// Now Largest Element Exist at the Top Of Stack
		while (k > 0) {
			stack.pop();
			k--;
		}

		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty())
			sb.append(stack.pop());
		sb.reverse();
		while (sb.length() > 1 && sb.charAt(0) == '0')
			sb.deleteCharAt(0);
		return sb.toString();
	}

}
