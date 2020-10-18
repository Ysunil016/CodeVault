package October

import java.util.*

object BuyAndSellStock4 {
    @JvmStatic
    fun main(args: Array<String>) {
        println(maxProfit(2, intArrayOf(2, 3, 4, 1)))
    }

    private fun maxProfit(k: Int, prices: IntArray): Int {
        var k = k
        k = Math.min(k, prices.size / 2)
        val buy = IntArray(k + 1)
        val sell = IntArray(k + 1)
        Arrays.fill(buy, Int.MIN_VALUE)
        for (price in prices) {
            for (i in 1..k) {
                buy[i] = Math.max(buy[i], sell[i - 1] - price)
                sell[i] = Math.max(sell[i], buy[i] + price)
            }
        }
        return sell[k]
    }
}