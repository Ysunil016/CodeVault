package August;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class ToGoatLatin {

	public static void main(String[] args) {
		System.out.println(toGoatLatin("The quick brown fox jumped over the lazy dog"));
	}

	public static String toGoatLatin(String S) {
		String[] splitString = S.split(" ");
		ArrayList<String> result = new ArrayList<>();
		HashSet<Character> hashSet = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
		int numberOfA = 1;
		for (String Str : splitString) {
			if (!hashSet.contains(Str.charAt(0))) {
				StringBuilder x = new StringBuilder(Str.substring(1, Str.length()));
				x.append(Str.charAt(0) + "ma");
				for (int i = 0; i < numberOfA; i++)
					x.append('a');

				result.add(new String(x));
			} else {
				StringBuilder x = new StringBuilder(Str);
				x.append("ma");
				for (int i = 0; i < numberOfA; i++)
					x.append('a');

				result.add(new String(x));
			}
			numberOfA++;
		}
		return String.join(" ", result);
	}

}
