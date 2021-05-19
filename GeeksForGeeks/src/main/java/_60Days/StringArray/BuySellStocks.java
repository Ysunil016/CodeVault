package _60Days.StringArray;

public class BuySellStocks {

	public static void main(String[] args) {
		int[] stockList = { 100, 180, 260, 310, 440, 535, 695 };
		System.out.println(getMaxProfit(stockList));
	}

	static int getMaxProfit(int[] stockArray) {
		int fResult = 0;
		int resProfit = 0;

		int tillMin = Integer.MAX_VALUE;
		for (int num : stockArray) {
			if (num < tillMin) {
				tillMin = num;
				fResult += resProfit;
			} else {
				resProfit = Math.max(resProfit, num - tillMin);
			}
		}
		fResult += resProfit;

		return fResult;
	}

}
