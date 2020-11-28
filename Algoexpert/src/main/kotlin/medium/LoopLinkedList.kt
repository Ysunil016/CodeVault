package medium

class LoopLinkedList {

    fun findLoop(head: LinkedList?): LinkedList? {
        var slowPointer = head
        var fastPointer = head

        while(fastPointer != null){
            slowPointer = slowPointer?.next
            fastPointer = fastPointer.next?.next
            if(slowPointer == fastPointer)
                break;
        }
        if(fastPointer?.next == null) return head

        var headCounter = head
        while(headCounter!=slowPointer){
            headCounter = headCounter?.next
            slowPointer = slowPointer?.next
        }

        return headCounter
    }
}