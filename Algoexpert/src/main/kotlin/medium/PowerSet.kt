package medium

class PowerSet {
    fun powerset(array: List<Int>): List<List<Int>> {
        val finalResult = mutableListOf<List<Int>>(listOf())
        array.forEach {
            val finalListElement = finalResult.size
            for (i in 0 until finalListElement) {
                val currentList = finalResult[i].toMutableList()
                currentList.add(it)
                finalResult.add(currentList)
            }
        }
        return finalResult
    }
}