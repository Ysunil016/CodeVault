package hard

import java.util.*

open class LinkedList(value: Int) {
    var value = value
    var next: LinkedList? = null
}

class Palindrome {

    fun linkedListPalindrome(head: LinkedList?): Boolean {
        var slow = head
        var fast = head

        while(fast?.next != null){
            slow = slow?.next
            fast = fast.next?.next
        }
        var stack = Stack<Int>()
        while(slow !=null){
            stack.add(slow.value)
            slow = slow.next
        }
        var xhead = head
        while(!stack.isEmpty()){
            if(xhead == null) return false
            if(stack.pop() != xhead.value)
                return false
            xhead = xhead.next
        }
        return true
    }

}