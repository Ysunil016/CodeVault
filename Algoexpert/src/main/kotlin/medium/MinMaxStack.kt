package medium

open class MinMaxStack {
    private val stackList = mutableListOf<Int>()

    private val minStack = mutableListOf<Int>()

    private val maxStack = mutableListOf<Int>()

    fun peek(): Int? {
        return stackList[stackList.size - 1]
    }

    fun pop(): Int? {
        val removeLast = stackList.removeAt(maxStack.size - 1)
        while (maxStack.size >= 0 && removeLast >= maxStack[maxStack.size - 1]) {
            maxStack.removeAt(maxStack.size - 1)
        }
        while (minStack.size >= 0 && removeLast <= minStack[minStack.size - 1]) {
            minStack.removeAt(minStack.size - 1)
        }

        return removeLast
    }

    fun push(number: Int) {
        while (number >= maxStack[maxStack.size - 1])
            maxStack.add(number)
        while (number <= minStack[minStack.size - 1])
            minStack.add(number)

        stackList.add(number)
    }

    fun getMin(): Int? {
        if (minStack.size == 0) return -1
        return minStack.last()
    }

    fun getMax(): Int? {
        if (maxStack.size == 0) return -1
        return maxStack.last()
    }
}
