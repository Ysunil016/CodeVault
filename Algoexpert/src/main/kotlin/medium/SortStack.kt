package medium

// TODO

class SortStack {

    fun sortStack(stack: MutableList<Int>): MutableList<Int> {
        val value = stack.removeLast()
        while (!isSorted(stack)) {
            sortStackUtil(stack, value)
            println(stack);
        }
        println(stack)
        return stack
    }

    private fun isSorted(stack: MutableList<Int>): Boolean {
        val topValue = stack.last();
        for (i in stack.size-2 downTo 0) {
            if (topValue > stack[i]) return false;
        }
        return true
    }

    private fun sortStackUtil(stack: MutableList<Int>, value: Int) {
        if (stack.isEmpty()) return

        val topValue = stack.removeLast();

        if (value > topValue) {
            stack.add(value);
            stack.add(topValue);
            return;
        }

        sortStackUtil(stack, value);

        stack.add(topValue);
    }
}