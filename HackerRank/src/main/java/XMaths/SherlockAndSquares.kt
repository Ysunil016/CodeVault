package XMaths

fun main() {
    println(squares(10,200))
}

fun squares(a: Int, b: Int): Int {
    var numberCount = 0
    // 1 4 9 16 25
    val lowerValue = Math.sqrt(a.toDouble())
    val higherValue = Math.sqrt(b.toDouble())
    if (lowerValue % 1 == 0.0) numberCount++
    numberCount += higherValue.toInt() - lowerValue.toInt()
    return numberCount
}
