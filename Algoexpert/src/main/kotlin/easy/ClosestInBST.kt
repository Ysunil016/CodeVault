package easy

import java.util.*
import kotlin.math.abs
import kotlin.math.min

fun main() {

}

open class BST(value: Int) {
    var value = value
    var left: BST? = null
    var right: BST? = null
}

// O(n)
// Using BST
fun findClosestValueInBst(tree: BST, target: Int): Int {
    var queue = LinkedList<BST>()
    queue.add(tree)

    var minDifference = Int.MAX_VALUE
    var selectedElement = tree.value

    while (!queue.isEmpty()){
        var size = queue.size

        while(size > 0){
            var curNode = queue.poll()
            if(abs(curNode.value - target) < minDifference){
                minDifference = abs(curNode.value - target)
                selectedElement = curNode.value
            }
            if(curNode.left!=null)
                queue.add(curNode.left!!)
            if(curNode.right!=null)
                queue.add(curNode.right!!)
            size--
        }
    }
    return selectedElement
}