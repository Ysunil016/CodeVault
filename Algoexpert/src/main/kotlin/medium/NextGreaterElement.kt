package medium

class NextGreaterElement {

    fun nextGreaterElement(array: MutableList<Int>): MutableList<Int> {
        val list = mutableListOf<Int>()
        for (i in 0 until array.size) {
            val findMax = findMax(i, array)
            list.add(findMax)
        }
        return list
    }

    private fun findMax(index: Int, array: MutableList<Int>): Int {
        var counter = index + 1;
        if (counter > array.size) return -1;
        while (counter < array.size) {
            if (array[counter] > array[index]) return array[counter]
            counter++;
        }
        counter = 0
        while (counter < index) {
            if (array[counter] > array[index]) return array[counter]
            counter++;
        }
        return -1;
    }

}