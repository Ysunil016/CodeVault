package com.Array;

public class BuySellStock {

    public int play(int[] stocks, int algoType) {
        return 0;
    }

    private int brute(int[] stocks) {
        int maxProfit = 0;
        for (int buyIdx = 0; buyIdx < stocks.length; buyIdx++) {
            for (int sellIdx = buyIdx + 1; sellIdx < stocks.length; sellIdx++) {
                maxProfit = Math.max(maxProfit, stocks[sellIdx] - stocks[buyIdx]);
            }
        }
        return maxProfit;
    }

    private int best(int[] stocks) {
        int buyIdx = 0;
        int maxProfit = 0;

        for (int idx = 1; idx < stocks.length; idx++) {
            int buyPrice = stocks[buyIdx];
            int sellPrice = stocks[idx];
            if (sellPrice < buyPrice)
                buyIdx = idx;

            maxProfit = Math.max(maxProfit, sellPrice - buyPrice);
        }
        return maxProfit;
    }
}
