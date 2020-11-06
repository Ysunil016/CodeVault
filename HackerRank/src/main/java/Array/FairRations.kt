package Array

fun main() {
    print(FairRations().fairRations(intArrayOf(1,2,3,4)))
}

class FairRations {
    fun fairRations(B: IntArray): Int {
        var resultCount = 0
        for (i in 0 until B.size - 1) {
            if (B[i] % 2 != 0) {
                B[i]++
                B[i + 1]++
                resultCount += 2
            }
        }
        // Checking if All the Element is Even
        for (x in B) {
            if (x % 2 != 0) return -1
        }
        return resultCount
    }

}