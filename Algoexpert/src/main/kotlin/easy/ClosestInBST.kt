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
// O(n) - Time Complexity
// O(n) - Space Complexity
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

// O(lgn) = Avg. Time Complexity
// O(lgn) => Avg. Stack Frame
// O(1) => Space
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

    // Iterative
    fun checkForSolutionOptimal(tree: BST, target: Int,closest:Int):Int{
        var cNode = tree
        var clo = closest
        while (!cNode.equals(null)) {
            if (abs(target - closest) > abs(target - cNode.value))
                clo = cNode.value
            cNode = if (target < cNode.value && cNode.left != null) {
                cNode.left!!
            } else if(target > cNode.value && cNode.right != null) {
                cNode.right!!
            }else{
                break
            }
        }
        return clo
    }

}
