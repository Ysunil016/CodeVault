package August;

public class TitleToNumber {

	public static void main(String[] args) {
		System.out.println(titleToNumber("XXX"));
	}

	public static int titleToNumber(String s) {
		int result = 0;
		for (int i = 0; i < s.length(); i++) {
			int factor = (int) Math.pow(26, i);
			result += factor * (s.charAt(s.length() - i - 1) - 'A' + 1);
		}
		return result;
	}

}
