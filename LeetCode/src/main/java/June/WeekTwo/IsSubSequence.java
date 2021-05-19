package June.WeekTwo;

public class IsSubSequence {

	public static void main(String[] args) {
		System.out.println(isSubsequence("absdsdjks", "asjdasadbasdmamsndbnisdbkhbds"));
	}

	public static boolean isSubsequence(String s, String t) {
		if (s.length() == 0) {
			return true;
		}
		if (t.length() == 0) {
			return false;
		}
		char[] S = s.toCharArray();
		char[] T = t.toCharArray();
		int sCounter = 0;
		for (int i = 0; i < T.length; i++) {
			if (T[i] == S[sCounter]) {
				System.out.println(T[i]);
				sCounter++;
			}
			if (sCounter == S.length) {
				return true;
			}
		}
		return false;
	}

}
