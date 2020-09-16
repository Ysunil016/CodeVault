package Array;

public class HackerRankString {

	public static void main(String[] args) {
		System.out.println(hackerrankInString("haasasdscasdkasderdsadradaasddnaak"));
	}

	static String hackerrankInString(String s) {
		char[] hackerRank = { 'h', 'a', 'c', 'k', 'e', 'r', 'r', 'a', 'n', 'k' };

		int counter = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == hackerRank[counter]) {
				counter++;
			}
			if (counter == hackerRank.length) {
				return "YES";
			}
		}
		return "NO";
	}

}
