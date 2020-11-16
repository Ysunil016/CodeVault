package easy

open class BinaryTree(value: Int) {
    var value = value
    var left: BinaryTree? = null
    var right: BinaryTree? = null
}

class BranchSum{

    fun branchSums(root: BinaryTree): List<Int> {
        var listOfElements = arrayListOf<Int>()
        branch(root,0,listOfElements)
        return listOfElements
    }

    fun branch(root:BinaryTree,sumValue:Int,values:ArrayList<Int>){
        if(root.equals(null)) return

        if(root.left == null && root.right == null){
            values.add(sumValue+root.value)
        }
        if(root.left!=null)
        branch(root.left!!,sumValue+root.value,values)
        if(root.right!=null)
        branch(root.right!!,sumValue+root.value,values)
    }


}
