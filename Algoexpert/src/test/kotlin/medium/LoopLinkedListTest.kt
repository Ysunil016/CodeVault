package medium

import org.junit.Assert
import org.junit.Test


class LoopLinkedListTest{

    @Test
    fun shouldFindLoop(){
        var head = LinkedList(10)
        head.next = LinkedList(20)
        head.next?.next = LinkedList(30)
        head.next?.next?.next = LinkedList(40)
        head.next?.next?.next?.next = LinkedList(50)
        head.next?.next?.next?.next?.next = head.next?.next

        Assert.assertEquals(head.next?.next,LoopLinkedList().findLoop(head))

    }

}
