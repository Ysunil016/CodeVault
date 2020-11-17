package easy

import java.util.*

class NodeDepth {

    fun nodeDepths(root: BinaryTree): Int {
        var queue = LinkedList<BinaryTree>();
        queue.add(root)
        var finalDepth = 0;
        var i = 0;
        while(!queue.isEmpty()){
            var nSize = queue.size
            while(nSize > 0){
                var curNode = queue.poll()
                if(curNode.left != (null)){
                    queue.add(curNode.left!!)
                }
                if(curNode.right != (null)){
                    queue.add(curNode.right!!)
                }
                nSize--
                finalDepth += i
            }
            i++
        }
        return finalDepth
    }

    fun nodeDepths_2(root: BinaryTree): Int {
        var stack = Stack<Int>()
        compute(root,stack,0)
        var finalSum = 0
        while(!stack.isEmpty()){
            finalSum += stack.pop();
        }
        return finalSum
    }

    fun compute(root:BinaryTree,stack:Stack<Int>,position:Int){
        if(root.equals(null)) return
        stack.push(position)
        if(root.left!=null)
            compute(root.left!!,stack,position+1)
        if(root.right!=null)
            compute(root.right!!,stack,position+1)
    }

}