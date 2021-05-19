package Array;

public class RepeatingAndMissing {

	public static void main(String[] args) {
		int[] arr = { 1, 3, 3 };
		Keys result = getMissingElements(arr);
		System.out.println(result.repKey + " " + result.missKey);
	}

	static Keys getMissingElements(int[] arr) {
		int[] countHolder = new int[arr.length];

		Keys keyResult = new Keys(-1, -1);
		int sumOfAll = 0;
		int expCount = 0;

		for (int i = 0; i < arr.length; i++) {
			if (countHolder[arr[i] - 1] == 0) {
				countHolder[arr[i] - 1] = 1;
			} else {
				keyResult.repKey = arr[i];
			}
			expCount += i + 1;
			sumOfAll += arr[i];
		}

		sumOfAll -= keyResult.repKey;
		keyResult.missKey = expCount - sumOfAll;

		return keyResult;
	}

	static class Keys {
		int repKey;
		int missKey;

		Keys(int repKey, int missKey) {
			this.repKey = repKey;
			this.missKey = missKey;
		}
	}
}
