package medium

class Node(value: Int) {
    val value = value
    var prev: Node? = null
    var next: Node? = null
}

class DoublyLinkedList {
    private var head: Node? = null
    private var tail: Node? = null

    fun setHead(node: Node) {
        if(this.head == null){
            this.head = node
            this.tail = node
            return
        }
        this.insertBefore(this.head!!,node)
    }

    fun setTail(node: Node) {
        if(this.tail == null){
            setHead(node)
            return
        }
        insertAfter(this.tail!!,node)
    }

    fun insertBefore(node: Node, nodeToInsert: Node) {
        if(nodeToInsert == this.head && nodeToInsert == this.tail) return
        remove(nodeToInsert)
        nodeToInsert.prev = node.prev
        nodeToInsert.next = node
        if(node.prev == null){
            this.head = nodeToInsert
        }else{
            node.prev!!.next = nodeToInsert
        }
        node.prev = nodeToInsert
    }

    fun insertAfter(node: Node, nodeToInsert: Node) {
        if(nodeToInsert == this.head && nodeToInsert == this.tail) return
        remove(nodeToInsert)
        nodeToInsert.prev = node
        nodeToInsert.next = node.next
        if(node.next == null){
            this.tail = nodeToInsert
        }else{
            node.next!!.prev = nodeToInsert
        }
        node.next = nodeToInsert
    }

    fun insertAtPosition(position: Int, nodeToInsert: Node) {
        if(position == 1){
            setHead(nodeToInsert)
            return
        }
        var node:Node? = this.head
        var cPosition = 1
        while(node != null && cPosition++ != position){
            node = node.next
        }
        if(node!=null){
            insertBefore(node,nodeToInsert)
        }else{
            setTail(nodeToInsert)
        }
    }

    fun removeNodesWithValue(value: Int) {
        var node:Node? = head
        while(node !=null ){
            var nextNode = node.next;
            if(node.value == value) remove(node)
            node = nextNode;
        }
    }

    fun remove(node: Node) {
        if(node == this.head) this.head = node.next
        if(node == this.tail) this.tail = node.prev
        removeNodeBindings(node)
    }

    fun removeNodeBindings(node:Node){
        if(node.prev != null) node.prev!!.next = node.next
        if(node.next != null) node.next!!.prev = node.prev
        node.prev = null
        node.next = null
    }

    fun containsNodeWithValue(value: Int): Boolean {
        var node : Node ? = this.head
        while(node != null){
            if(node.value == value)
                return true
            node = node.next
        }
        return false
    }

    fun getHead(): Node? { return this.head }

    fun getTail(): Node? { return this.tail }
}
