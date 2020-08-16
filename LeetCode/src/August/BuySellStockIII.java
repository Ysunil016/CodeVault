package August;

public class BuySellStockIII {

	public static void main(String[] args) {
		System.out.println(maxProfit(new int[] { 1, 2, 4, 2, 5, 7, 2, 4, 9, 0 }));
	}

	public static int maxProfit(int[] prices) {
		if (prices.length == 0)
			return 0;

		int fB = Integer.MIN_VALUE;
		int fS = 0;
		int sB = Integer.MIN_VALUE;
		int sS = 0;

		int i = 0;
		while (i < prices.length) {
			fB = Math.max(fB, -prices[i]);
			fS = Math.max(fS, fB + prices[i]);
			sB = Math.max(sB, fS - prices[i]);
			sS = Math.max(sS, sB + prices[i]);
			i++;
		}
		return sS;
	}

}
