package Array;

public class CountingValley {

	public static void main(String[] args) {
		System.out.println(countingValleys(5, "UDDUD"));
	}

	static int countingValleys(int n, String s) {
		int vallyCounter = 0;
		char[] stepsTaken = s.toCharArray();

		boolean isDownInVally = false;
		int interimStepCounter = 0;
		for (int i = 0; i < stepsTaken.length; i++) {
			char step = stepsTaken[i];
			if (step == 'U') {
				interimStepCounter++;
			} else {
				interimStepCounter--;
			}
			if (interimStepCounter >= 0) {
				isDownInVally = false;
			}

			if (interimStepCounter < 0 && !isDownInVally) {
				vallyCounter++;
				isDownInVally = true;
			}
		}

		return vallyCounter;
	}

}
