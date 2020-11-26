package medium

import org.junit.Assert
import org.junit.Test


class RemoveKthNodeFromEndTest{

    @Test
    fun removeKthNodeFromEnd(){
        var removeKthNodeFromEnd = RemoveKthNodeFromEnd()

        var head = LinkedList(10)
        head.next = LinkedList(20)
        head.next!!.next = LinkedList(30)
        head.next!!.next!!.next= LinkedList(40)
        head.next!!.next!!.next!!.next = LinkedList(50)

        removeKthNodeFromEnd.removeKthNodeFromEnd(head,5)

        var x = 0
        while(head.next != null){
            x += head.value
            if(head.next!=null)
                head = head.next!!
        }

        Assert.assertEquals(90,x)
    }

    @Test
    fun removeKthNodeFromEnd_(){
        var removeKthNodeFromEnd = RemoveKthNodeFromEnd()

        var head = LinkedList(10)
        head.next = LinkedList(20)
        head.next!!.next = LinkedList(30)
        head.next!!.next!!.next= LinkedList(40)
        head.next!!.next!!.next!!.next = LinkedList(50)

        removeKthNodeFromEnd.removeKthNodeFromEnd(head,4)

        var x = 0
        while(head.next != null){
            x += head.value
            if(head.next!=null)
                head = head.next!!
        }

        Assert.assertEquals(80,x)
    }



}