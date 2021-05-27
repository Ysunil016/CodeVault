package veryHard

open class LinkedList(value: Int) {
    var value = value
    var next: LinkedList? = null
}

class SwapNodeLL {

    fun nodeSwap(root: LinkedList): LinkedList {
        var head = root;
        var prevNode = head
        var result = head.next

        while (head.next != null && head != null) {
            println("XYZ")
            val nextNode = result?.next;
            prevNode = head;
            result?.next = prevNode
            head = nextNode!!
        }
        return result!!
    }

}