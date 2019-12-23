package String;

import java.util.ArrayList;
import java.util.Collections;

public class PermutationOfString {

	public static void main(String[] args) {

		ArrayList<String> res = new ArrayList<String>();
		permString("SABHD", "", res);
		// Sorting Lexicographically
		Collections.sort(res);
		for (int i = 0; i < res.size(); i++)
			System.out.println(res.get(i));
		System.out.println();
	}

	static void permString(String str, String ans, ArrayList<String> res) {
		if (str.length() == 0) {
			res.add(ans);
			return;
		}

		// Recursive Procedure for Dividing String
		for (int i = 0; i < str.length(); i++) {
			char currentCh = str.charAt(i);
			String ros = str.substring(0, i) + str.substring(i + 1);
			permString(ros, ans + currentCh, res);
		}

	}

}
