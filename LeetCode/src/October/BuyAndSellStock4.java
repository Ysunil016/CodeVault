package October;

import java.util.Arrays;

public class BuyAndSellStock4 {
    public static void main(String[] args) {
        System.out.println(maxProfit(2,new int[]{2,3,4,1}));
    }

    public static int maxProfit(int k, int[] prices) {
        k = Math.min(k, prices.length / 2);
        int[] buy = new int[k + 1], sell = new int[k + 1];
        Arrays.fill(buy, Integer.MIN_VALUE);
        for (int price : prices) {
            for (int i = 1; i <= k; i++) {
                buy[i] = Math.max(buy[i], sell[i - 1] - price);
                sell[i] = Math.max(sell[i], buy[i] + price);
            }
        }
        return sell[k];
    }
}
