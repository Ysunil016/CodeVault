package hard

data class BST(val value:Int){
    var left:BST? = null
    var right:BST? = null
}

fun main() {
    val arrayOne = listOf<Int>(10, 15, 8, 12, 94, 81, 5, 2, 10)
    val arrayTwo = listOf<Int>(10, 8, 5, 15, 2, 10, 12, 94, 81)
    println(sameBsts(arrayOne,arrayTwo))
}

fun sameBsts(arrayOne: List<Int>, arrayTwo: List<Int>): Boolean {
    if(arrayOne[0]!=arrayTwo[0]) return false
    val rootOne = BST(arrayOne[0])
    val rootTwo = BST(arrayTwo[0])
    makeBSTFromArray(rootOne,arrayOne)
    makeBSTFromArray(rootTwo,arrayTwo)
    displayBST(rootOne)
    println()
    displayBST(rootTwo)
    return compareBST(rootOne,rootTwo)
}

fun displayBST(rootTwo: BST?) {
    if (rootTwo == null) return
    displayBST(rootTwo.left)
    print("${rootTwo.value} ")
    displayBST(rootTwo.right)
}

fun makeBSTFromArray(root:BST,array:List<Int>){
    for(i in 1 until array.size){
        makeBST(root,array[i])
    }
}
fun makeBST(root:BST,value:Int){
    if(value >= root.value){
        if(root.right == null)
            root.right = BST(value)
        else
            makeBST(root.right!!,value)
    }else{
        if(root.left == null)
            root.left = BST(value)
        else
            makeBST(root.left!!,value)
    }
}

fun compareBST(one:BST?,two:BST?):Boolean{
    if(one == null && two == null) return true
    if(one==null || two==null) return false
    if(one.value != two.value) return false
    return compareBST(one.left,two.left) && compareBST(one.right,two.right)
}
