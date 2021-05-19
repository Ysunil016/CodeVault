package easy

class TandemBicycle {

    fun tandemBicycle(redShirtSpeeds: MutableList<Int>, blueShirtSpeeds: MutableList<Int>, fastest: Boolean): Int {
        redShirtSpeeds.sort()
        var result = 0
        if (fastest) {
            blueShirtSpeeds.sortDescending()
            for (i in 0 until blueShirtSpeeds.size) {
                result += blueShirtSpeeds[i].coerceAtLeast(redShirtSpeeds[i])
            }
        } else {
            blueShirtSpeeds.sort()
            for (i in 0 until blueShirtSpeeds.size) {
                result += blueShirtSpeeds[i].coerceAtLeast(redShirtSpeeds[i])
            }
        }
        return result;
    }
}