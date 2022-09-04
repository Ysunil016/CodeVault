package com.Array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BuySellStockTest {

    @Test
    void shouldFindMaxProfitBrute() {
        int[] stocks = new int[]{7, 1, 5, 3, 6, 4};
        int expectedProfit = 5;
        int actualProfit = new BuySellStock().play(stocks, 1);
        assertEquals(expectedProfit, actualProfit);
    }

    @Test
    void shouldFindMaxProfitNoBrute() {
        int[] stocks = new int[]{7, 6, 4, 3, 1};
        int expectedProfit = 0;
        int actualProfit = new BuySellStock().play(stocks, 1);
        assertEquals(expectedProfit, actualProfit);
    }

    @Test
    void shouldFindMaxProfitBest() {
        int[] stocks = new int[]{7, 1, 5, 3, 6, 4};
        int expectedProfit = 5;
        int actualProfit = new BuySellStock().play(stocks, 2);
        assertEquals(expectedProfit, actualProfit);
    }

    @Test
    void shouldFindMaxProfitNoBest() {
        int[] stocks = new int[]{7, 6, 4, 3, 1};
        int expectedProfit = 0;
        int actualProfit = new BuySellStock().play(stocks, 2);
        assertEquals(expectedProfit, actualProfit);
    }
}