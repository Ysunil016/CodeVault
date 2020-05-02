package April.WeekOne;

public class Buy_Sell_Stocks {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		System.out.println(findMax(arr));
	}

	static int findMax(int[] arr) {
		if (arr.length == 0 || arr == null) {
			return 0;
		}
		int profit = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i + 1] > arr[i]) {
				profit += arr[i + 1] - arr[i];
			}
		}
		return profit;
	}
}
