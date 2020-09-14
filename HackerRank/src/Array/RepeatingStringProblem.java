package Array;

public class RepeatingStringProblem {

	public static void main(String[] args) {
		System.out.println(repeatedString("ahbdsasdjfhdfhjva", 300));
	}

	static long repeatedString(String s, long n) {
		if (s == null)
			return (long) 0;

		if (n < s.length()) {
			int initialACount = 0;
			for (int i = 0; i < n; i++) {
				if (s.charAt(i) == 'a') {
					initialACount++;
				}
			}
			return initialACount;
		}

		long longDivLen = n / s.length();
		long additionalSting = n % longDivLen;

		long initialACount = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'a') {
				initialACount++;
			}
		}
		initialACount *= longDivLen;
		for (int i = 0; i < additionalSting; i++) {
			if (s.charAt(i) == 'a') {
				initialACount++;
			}
		}
		return initialACount;
	}
}
