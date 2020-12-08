package hard

import org.junit.Assert
import org.junit.Test

internal class PalindromeTest {

    @Test
    fun linkedListPalindrome() {
        var x = LinkedList(10)
        x.next = LinkedList(20)
        x.next!!.next = LinkedList(30)
        x.next!!.next!!.next = LinkedList(20)
        x.next!!.next!!.next!!.next = LinkedList(10)
       Assert.assertTrue(Palindrome().linkedListPalindrome(x))
    }
}