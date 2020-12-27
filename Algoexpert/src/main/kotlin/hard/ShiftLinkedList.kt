package hard

import kotlin.math.abs

class ShiftLinkedList {

    open class LinkedList(value: Int) {
        var value = value
        var next: LinkedList? = null
    }

    fun shiftLinkedList(head: LinkedList, k: Int): LinkedList {
        if (k == 0) return head;
        var length = 1
        var list = head
        while (list.next != null) {
            length++
            list = list.next!!
        }
        val t = abs(k) % length
        if (t == 0) return head
        val newTailPos = if (k > 0) length - t else t
        var newTail = head
        for (i in 1 until newTailPos) {
            newTail = newTail.next!!
        }
        val newHead = newTail.next!!
        newTail.next = null
        list.next = head
        return newHead
    }
}

