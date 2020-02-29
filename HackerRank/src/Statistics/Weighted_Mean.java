package Statistics;

public class Weighted_Mean {

	public static void main(String[] args) {

		int[] arr = { 10, 40, 30, 50, 20, 10, 40, 30, 50, 20 };
		int[] weight = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		System.out.println(getWeightedMean(arr, weight, 10));
	}

	static float getWeightedMean(int[] arr, int[] weight, int N) {
		int totalDenom = 0;
		int totalNum = 0;
		for (int i = 0; i < N; i++) {
			totalNum += arr[i] * weight[i];
			totalDenom += weight[i];
		}

		float result = ((float) totalNum / totalDenom) * 10;

		return (float) Math.round(result) / 10;
	}

}
