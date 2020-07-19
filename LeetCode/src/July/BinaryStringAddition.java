package July;

public class BinaryStringAddition {

	public static void main(String[] args) {
		System.out.println(addBinary("101010", "111"));
	}

	static String addBinary(String a, String b) {
		char[] aArray = a.toCharArray();
		char[] bArray = b.toCharArray();
		int counter = 0;
		int carry = 0;
		StringBuilder strBuilder = new StringBuilder();
		while (counter < aArray.length && counter < bArray.length) {
			char x = aArray[aArray.length - 1 - counter];
			char y = bArray[bArray.length - 1 - counter];
			if (carry == 1) {
				if (x == '1' && y == '1') {
					strBuilder.append("1");
				} else if (x == '0' && y == '0') {
					strBuilder.append("1");
					carry = 0;
				} else {
					strBuilder.append("0");
				}
			} else {
				if (x == '1' && y == '1') {
					strBuilder.append("0");
					carry = 1;
				} else if (x == '0' && y == '0') {
					strBuilder.append("0");
				} else {
					strBuilder.append("1");
				}
			}
			counter++;
		}

		while (counter < aArray.length) {
			char x = aArray[aArray.length - 1 - counter];
			if (carry == 1) {
				if (x == '0') {
					strBuilder.append("1");
					carry = 0;
				} else {
					strBuilder.append("0");
					carry = 1;
				}
			} else {
				strBuilder.append(x);
			}
			counter++;
		}
		while (counter < bArray.length) {
			char y = bArray[bArray.length - 1 - counter];
			if (carry == 1) {
				if (y == '0') {
					strBuilder.append("1");
					carry = 0;
				} else {
					strBuilder.append("0");
					carry = 1;
				}
			} else {
				strBuilder.append(y);
			}
			counter++;
		}

		if (carry == 1) {
			strBuilder.append("1");
		}
		strBuilder.reverse();
		return new String(strBuilder);
	}

}
