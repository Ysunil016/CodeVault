package medium

class BST(value: Int){
    var value = value
    var left: BST? = null
    var right: BST? = null
}


class BSTTraversal {
    fun inOrderTraverse(tree: BST, array: MutableList<Int>): List<Int> {
        if(tree.equals(null)) return array

        if(tree.left!=null)
        inOrderTraverse(tree.left!!,array)

        array.add(tree.value)

        if(tree.right!=null)
        inOrderTraverse(tree.right!!,array)

        return array
    }

    fun preOrderTraverse(tree: BST, array: MutableList<Int>): List<Int> {
        if(tree.equals(null)) return array
        array.add(tree.value)
        if(tree.left!=null)
        preOrderTraverse(tree.left!!,array)
        if(tree.right!=null)
        preOrderTraverse(tree.right!!,array)

        println(array)

        return array
    }


    fun postOrderTraverse(tree: BST, array: MutableList<Int>): List<Int> {
        if(tree.equals(null)) return array
        if(tree.left!=null)
        postOrderTraverse(tree.left!!,array)
        if(tree.right!=null)
        postOrderTraverse(tree.right!!,array)
        array.add(tree.value)

        println(array)

        return array
    }

}


