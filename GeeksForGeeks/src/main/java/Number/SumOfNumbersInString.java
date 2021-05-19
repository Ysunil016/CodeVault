package Number;

//Extracting Integer from String

public class SumOfNumbersInString {

	public static void main(String[] args) {
		System.out.println(getSum("1abc23"));
		System.out.println(getSum("geeks4geeks"));
		System.out.println(getSum("1abc2x30yz67"));
		System.out.println(getSum("123abc"));
	}

	static int getSum(String input) {
		int sum = 0;
		char[] arl = input.toCharArray();
		StringBuilder temp = new StringBuilder();
		for (int i = 0; i < arl.length; i++) {
			if (('0' <= arl[i]) && (arl[i] <= '9')) {
				temp.append(arl[i]);
			} else {
				if (temp.length() != 0) {
					sum += Integer.valueOf(new String(temp));
					temp = new StringBuilder();
				}
			}
		}

		if (temp.length() != 0)
			sum += Integer.valueOf(new String(temp));
		return sum;
	}

}
