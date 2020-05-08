package May.WeekOne;

public class JewelsStone {

	public static void main(String[] args) {
		String J = "aA";
		String S = "aAAANNBBH";
		System.out.println(numJewelsInStones(J, S));
	}

	public static int numJewelsInStones(String J, String S) {
		if (J == null || S == null || J.length() == 0 || S.length() == 0)
			return 0;

		int jCount = 0;

		for (int i=0;i<S.length();i++) {
			for (int j=0;j<J.length();j++) {
				if (S.charAt(i) == J.charAt(j)) {
					jCount++;
					break;
				}
			}
		}
		return jCount;
	}

}
