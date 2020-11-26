package medium

open class LinkedList(value: Int) {
    var value = value
    var next: LinkedList? = null
}
class RemoveKthNodeFromEnd {

    fun removeKthNodeFromEnd(head: LinkedList, k: Int) {
        var counter = 0
        var slow: LinkedList? = head
        var fast: LinkedList? = head
        var prev : LinkedList? = null
        while(fast != null){
            if(counter >= k){
                prev = slow!!
                slow = slow?.next
            }
            fast = fast.next
            counter++
        }
        if(prev!=null){
            prev.next = slow?.next
        }else{
            // Logical Thinking
            head.value = head.next!!.value
            head.next = head.next!!.next
        }
    }


}