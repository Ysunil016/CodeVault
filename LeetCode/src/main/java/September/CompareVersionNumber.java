package September;

public class CompareVersionNumber {

	public static void main(String[] args) {
		System.out.println(compareVersion("1.0.1", "1"));
	}

	public static int compareVersion(String version1, String version2) {
		String[] v1Numbers = version1.split("\\.");
		String[] v2Numbers = version2.split("\\.");

		int v1Pointer = 0;
		int v2Pointer = 0;
		while (v1Pointer < v1Numbers.length && v2Pointer < v2Numbers.length) {
			int v1Value = Integer.valueOf(v1Numbers[v1Pointer++]);
			int v2Value = Integer.valueOf(v2Numbers[v2Pointer++]);

			if (v1Value > v2Value)
				return 1;
			if (v1Value < v2Value)
				return -1;
		}

		while (v1Pointer < v1Numbers.length) {
			if (Integer.valueOf(v1Numbers[v1Pointer++]) > 0)
				return 1;
		}
		while (v2Pointer < v2Numbers.length) {
			if (Integer.valueOf(v2Numbers[v2Pointer++]) > 0)
				return -1;
		}

		return 0;

	}

}
