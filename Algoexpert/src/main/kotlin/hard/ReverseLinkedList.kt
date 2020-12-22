package hard

open class RLinkedList(value: Int) {
    var value = value
    var next: RLinkedList? = null
}

fun main() {
    var root = RLinkedList(10)
    root.next = RLinkedList(20)
    root.next!!.next = RLinkedList(30)
    root.next!!.next!!.next = RLinkedList(40)
    root.next!!.next!!.next!!.next = RLinkedList(50)

    display(head = root)
    println("X")
    var x = reverseLinkedList(root)
    display(x)
}

fun display(head:RLinkedList){
    var xHead = head
    while(xHead.next !=null){
        println(xHead.value)
        xHead = xHead.next!!
    }
}

fun reverseLinkedList(head: RLinkedList): RLinkedList {
    var prevNode: RLinkedList? = null
    var curNode: RLinkedList?  = head
    while(curNode != null ){
        var nextNode = curNode.next
        curNode.next = prevNode
        prevNode = curNode
        curNode = nextNode
    }
    return prevNode!!
}