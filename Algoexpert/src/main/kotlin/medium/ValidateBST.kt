package medium

class ValidateBST {

    fun validateBst(tree: BST?): Boolean {
        return check(tree, Int.MIN_VALUE, Int.MAX_VALUE)
    }

    private fun check(root: BST?, min: Int, max: Int): Boolean {
        if (root == null) return true
        return if (root.value < min || root.value >= max) false else check(root.left, min, root.value) && check(root.right, root.value, max)
    }

    class BST(var value: Int) {
        var left: BST? = null
        var right: BST? = null
    }

}