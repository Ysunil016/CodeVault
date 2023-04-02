package _60Days.StringArray;

public class AllPermutationsString {

	public static void main(String[] args) {
		getAllPalindrome("geeks");
	}

	private static void getAllPalindrome(String str) {
		char[] chArray = str.toCharArray();

		for (int i = 0; i < chArray.length; i++) {
			if (isPalindrome(chArray, i, i)) {
				System.out.println(chArray[i] + " ");
			}

		}
	}

	private static boolean isPalindrome(char[] x, int start, int end) {
		while (start < end) {
			if (x[start] != x[end])
				return false;
			start++;
			end--;
		}
		return true;
	}

}
