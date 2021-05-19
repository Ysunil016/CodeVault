package String;

public class CheckIfStingRotatedTwoPlace {

	public static void main(String[] args) {
		System.out.println(isTwoPlace("rellnmpapqfwkhop", "llnmpapqfwkhopre"));
	}

	static boolean isTwoPlace(String in, String out) {
		int sLen = in.length();
		char[] inC = in.toCharArray();
		for (int i = 0; i < 2; i++) {
			char prem = inC[0];
			for (int j = 0; j < sLen - 1; j++) {
				inC[i] = inC[i + 1];
			}
			inC[sLen - 1] = prem;
		}
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < inC.length; i++) {
			res.append(inC[i]);
		}
		System.out.println(res);
		return res.toString().equals(in);
	}
}
