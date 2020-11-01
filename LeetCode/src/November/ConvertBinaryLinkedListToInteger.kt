package November

fun main() {

}

fun getDecimalValue(head: ListNode?): Int {
    var leadCount = 0;
    var cHead:ListNode? = head;
    while(cHead!=null)
    {
        leadCount++
        cHead = cHead.next;
    }
    if(leadCount==0)
        return 0;

    return findTheValue(head,leadCount-1);
}

class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

fun findTheValue(head:ListNode?,running:Int):Int{
    if(head == null)
        return 0;

    return findTheValue(head.next,running-1) + head.`val`* Math.pow(2.0,running.toDouble()).toInt();
}