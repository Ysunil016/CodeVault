package Stack;

public class MinMaxRiddle {

	public static void main(String[] args) {
		long[] arr = { 3, 5, 4, 7, 6, 2 };
		get(arr);
	}

	static long[] get(long[] arr) {
		int len = arr.length;
		long[] maxR = new long[len];

		// Finding the Elements of Each Window and Calculating Its Min
		for (int i = 0; i < len; i++)
			maxR[i] = getMinMaxVal(arr, i);

		for (int i = 0; i < len; i++) {
			System.out.print(maxR[i] + " ");
		}

		return maxR;
	}

	// Complexity is High, It is Require to Using Stack
	static long getMinMaxVal(long[] arr, int window) {
		long maxVal = Long.MIN_VALUE;

		for (int i = 0; i < arr.length - window; i++) {
			long tempV = arr[i];
			for (int j = i + 1; j < window + i + 1; j++) {
				tempV = Math.min(tempV, arr[j]);
			}
			maxVal = Math.max(maxVal, tempV);
		}

		return maxVal;
	}

}
