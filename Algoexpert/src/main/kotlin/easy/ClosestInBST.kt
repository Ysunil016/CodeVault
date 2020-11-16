package easy

import java.util.*
import kotlin.math.abs
import kotlin.math.min

open class BST(value: Int) {
    var value = value
    var left: BST? = null
    var right: BST? = null
}

class ClosestInBST{


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


    var optimalDifference = Int.MAX_VALUE
    var optimalElement = -1


    fun findClosestValueInBstDFS(tree: BST, target: Int): Int {
        optimalDifference = Int.MAX_VALUE
        optimalElement = -1

        checkForSolution(tree,target)

        return optimalElement;
    }


    fun checkForSolution(tree: BST, target: Int){
        if(abs(tree.value - target) < optimalDifference){
            optimalDifference = abs(tree.value - target)
            optimalElement = tree.value
        }
        if(target > tree.value && tree.right!=null){
            checkForSolution(tree.right!!,target)
        }else{
            if(tree.left!=null)
                checkForSolution(tree.left!!,target)
        }
    }

}
