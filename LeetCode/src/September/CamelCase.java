package September;

public class CamelCase {

	public static void main(String[] args) {
		System.out.println(camelcase("iAmPostingMessage"));
	}

	static int camelcase(String s) {
		if (s.length() == 0 || s == null)
			return 0;

		int wordCount = 1;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= 65 && s.charAt(i) < 97) {
				wordCount++;
			}
		}
		return wordCount;
	}

}
