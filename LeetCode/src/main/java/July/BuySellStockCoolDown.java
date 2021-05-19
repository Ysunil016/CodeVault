package July;

import java.util.HashMap;

public class BuySellStockCoolDown {

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 0, 2 };
		System.out.println(maxProfit(array));
	}

	static private int maxProfit(int[] prices) {
		HashMap<String, Integer> hashStore = new HashMap<>();
		return profit(prices, false, 0, hashStore);
	}

	static private int profit(int[] prices, boolean buyOrSell, int runningIndex, HashMap<String, Integer> hm) {
		if (runningIndex >= prices.length)
			return 0;

		String key = runningIndex + "Codigo" + String.valueOf(buyOrSell);
		if (hm.containsKey(key)) {
			return hm.get(key);
		}

		int result = 0;
		if (!buyOrSell) {
			int buy = profit(prices, true, runningIndex + 1, hm) - prices[runningIndex];
			int noBuy = profit(prices, false, runningIndex + 1, hm);
			result = Math.max(buy, noBuy);
		} else {
			int sell = profit(prices, false, runningIndex + 2, hm) + prices[runningIndex];
			int noSell = profit(prices, true, runningIndex + 1, hm);
			result = Math.max(sell, noSell);
		}

		hm.put(key, result);

		return result;
	}

	public static int maxProfitOptamized(int[] prices) {
		if (prices == null || prices.length <= 1) {
			return 0;
		}
		int[] buy = new int[prices.length];
		int[] sell = new int[prices.length];
		buy[0] = -prices[0];
		buy[1] = Math.max(-prices[0], -prices[1]);
		sell[1] = Math.max(0, prices[1] - prices[0]);
		for (int i = 2; i < prices.length; i++) {
			buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);
			sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
		}
		return sell[prices.length - 1];
	}

}
