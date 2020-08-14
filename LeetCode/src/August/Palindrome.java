package August;

public class Palindrome {

	public static void main(String[] args) {
		System.out.println(longestPalindrome("AAAAA"));
	}

	public static int longestPalindrome(String s) {
		int[] alphaCount = new int[80];
		for (int i = 0; i < s.length(); i++) {
			alphaCount[s.charAt(i) - 'A'] += 1;
		}

		int count = 0;
		for (int i = 0; i < 72; i++) {
			count += alphaCount[i] / 2;
		}
		count *= 2;
		if (count < s.length()) {
			count++;
		}

		return count;
	}

}
