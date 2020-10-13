package XMaths

fun main() {
    println(ChocolateFeast().chocolateFeast(10,2,5))
}

class ChocolateFeast {

    fun chocolateFeast(n: Int, c: Int, m: Int): Int {
        var chocolates = n / c // This Much Chocolates He Can Buy in Initial
        var wrappers = chocolates
        while (wrappers >= m) {
            wrappers -= m
            chocolates++ // Adding 1 Chocolate for M Wrapper
            wrappers++ // Adding 1 Wrapper for 1 Chocolate
        }
        return chocolates
    }
}