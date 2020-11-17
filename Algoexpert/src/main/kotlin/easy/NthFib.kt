package easy

class NthFib {

    fun getNthFib(n: Int): Int {
        if(n <= 1) return 0
        if(n == 2) return 1
        return getNthFib(n-1) + getNthFib(n-2)
    }


    fun getNthFib_DP(n: Int): Int {
        var arrayL = IntArray(n+1)
        return getNthFibDP(n,arrayL)
    }

    fun getNthFibDP(n:Int,dp:IntArray):Int{
        if(n <= 1) return 0
        if(n == 2) return 1
        if(dp[n] != 0)
            return dp[n]
        dp[n] = getNthFibDP(n-1,dp)+getNthFibDP(n-2,dp)
        return dp[n]
    }

}