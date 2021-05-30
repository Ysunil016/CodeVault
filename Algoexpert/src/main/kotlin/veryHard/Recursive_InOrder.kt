package veryHard

open class BinaryTree(value: Int, parent: BinaryTree?) {
    var value = value
    var left: BinaryTree? = null
    var right: BinaryTree? = null
    var parent: BinaryTree? = parent
}

fun iterativeInOrderTraversal(tree: BinaryTree?, callback: (BinaryTree?) -> Unit) {
    if(tree == null) return;
    iterativeInOrderTraversal(tree?.left,callback)
    callback(tree)
    iterativeInOrderTraversal(tree?.right,callback)
}
