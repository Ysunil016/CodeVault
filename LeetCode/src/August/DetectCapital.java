package August;

public class DetectCapital {

	public static void main(String[] args) {
		System.out.println(isCapital("FFFFFFFFFFFFFFFFFFFFf"));
	}

	static boolean isCapital(String word) {
		char[] arr = word.toCharArray();
		if (arr.length == 0 || arr.length == 1)
			return true;

		boolean isRight = true;
		boolean isFirstCapital = false;

		if (arr[0] > 64 && arr[0] < 91) {
			isFirstCapital = true;
		}

		boolean isNextCapital = (arr[1] > 64 && arr[1] < 91) ? true : false;
		for (int i = 2; i < arr.length; i++) {
			if (isNextCapital) {
				if (arr[i] < 65 || arr[i] > 90) {
					return false;
				}
			} else {
				if (arr[i] > 64 && arr[i] < 91) {
					return false;
				}
			}
		}

		if (!isFirstCapital) {
			if (isNextCapital) {
				return false;
			}
		}

		return isRight;
	}

}
