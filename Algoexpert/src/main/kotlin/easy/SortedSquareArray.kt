package easy

class SortedSquareArray {
    fun sortedSquaredArray(array: List<Int>): List<Int> {
        return array.map{it*it}.sorted();
    }
}