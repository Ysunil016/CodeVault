package veryHard

import org.junit.Test


class SwapNodeLLTest {
    @Test
    fun swapNode() {
        val root = LinkedList(0)
        root.next = LinkedList(1);
        root.next?.next = LinkedList(2);
        root.next?.next?.next = LinkedList(3);
        root.next?.next?.next?.next = LinkedList(4);
        root.next?.next?.next?.next?.next = LinkedList(5);

        var linkedList = SwapNodeLL().nodeSwap(root);
        while (linkedList != null) {
            println(linkedList.value)
            linkedList = linkedList.next!!
        }
    }
}