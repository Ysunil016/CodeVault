package Print;

public class SplitN {

	public static void main(String[] args) {
		splitNumber("12345", 2);
	}

	static String[] splitNumber(String number, int k) {
		int resInt = number.length() / k;
		resInt++;
		String[] res = new String[resInt];
		for (int i = 0; i < resInt; i++)
			res[i] = "";

		int counter = 0;
		for (int i = 0; i < resInt - 1; i++) {
			for (int z = 0; z < k; z++) {
				res[i] = res[i].concat(String.valueOf(number.charAt(counter)));
				counter++;
			}
		}

		if (counter != number.length()) {
			for (int i = counter; i != number.length(); i++)
				res[resInt - 1] = res[resInt - 1].concat(String.valueOf(number.charAt(i)));
		}

		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}

		return res;
	}

}
