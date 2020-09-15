package XMaths;

public class Encryption {

	public static void main(String[] args) {
		System.out.println(encryption("feedthedog"));
	}

	static String encryption(String s) {
		StringBuilder strBuilder = new StringBuilder();

		int strLen = s.length();
		double sqrtOfLen = Math.sqrt(strLen);

		int celin = (int) Math.ceil(sqrtOfLen);
		int floor = (int) Math.floor(sqrtOfLen);

		while (celin * floor < s.length()) {
			floor++;
		}

		char[][] charCollection = new char[floor][celin];

		int charCount = 0;
		for (int i = 0; i < floor; i++) {
			for (int j = 0; j < celin && charCount < s.length(); j++) {
				charCollection[i][j] = s.charAt(charCount);
				charCount++;
			}
		}

		for (int i = 0; i < celin; i++) {
			for (int j = 0; j < floor; j++) {
				if (Character.getNumericValue(charCollection[j][i]) != -1)
					strBuilder.append(charCollection[j][i]);
			}
			if (i < (celin - 1))
				strBuilder.append(" ");
		}
		return new String(strBuilder).trim();
	}

}
