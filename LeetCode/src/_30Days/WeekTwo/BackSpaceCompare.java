package _30Days.WeekTwo;

import java.util.Stack;

public class BackSpaceCompare {

	public static void main(String[] args) {
		String S = "ab#c";
		String T = "ad#c";
		System.out.println(backspaceCompare(S, T));
	}

	public static boolean backspaceCompare(String S, String T) {
		Stack<Character> charStoreS = new Stack<>();
		Stack<Character> charStoreT = new Stack<>();
		char[] S_Array = S.toCharArray();
		char[] T_Array = T.toCharArray();

		for (char key : S_Array) {
			if (key == '#') {
				if (!charStoreS.isEmpty())
					charStoreS.pop();
			} else {
				charStoreS.push(key);
			}
		}
		for (char key : T_Array) {
			if (key == '#') {
				if (!charStoreT.isEmpty())
					charStoreT.pop();
			} else {
				charStoreT.push(key);
			}
		}
		// Comparing Both the Stacks
		while (!charStoreS.isEmpty() && !charStoreT.isEmpty()) {
			if (!(charStoreS.pop() == charStoreT.pop()))
				return false;
		}

		if (!charStoreS.isEmpty() || !charStoreT.isEmpty())
			return false;

		return true;
	}

}
