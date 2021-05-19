package General.Array;

public class ImplementStrStr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getStrStr("hello", "ll"));
	}

	static int getStrStr(String haystack, String needle) {
		char[] hay = haystack.toCharArray();
		char[] pin = needle.toCharArray();
		if (pin.length == 0)
			return 0;
		if (pin.length > hay.length)
			return -1;

		for (int i = 0; i < hay.length - pin.length + 1; i++) {
			if (hay[i] == pin[0]) {
				for (int j = 0; j < pin.length; j++) {
					if (hay[i + j] != pin[j]) {
						break;
					}
					if (j == pin.length - 1)
						return i;
				}
			}

		}
		return -1;
	}

}
