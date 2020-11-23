package medium

import org.junit.Assert
import org.junit.Before
import org.junit.Test


internal class BSTTraversalTest {

    lateinit var bst:BST

    @Before
    fun setUp() {
        bst = BST(10)
        bst.left = BST(5)
        bst.right = BST(15)
        bst.right!!.left = BST(12)
        bst.right!!.right = BST(20)
    }

    @Test
    fun inOrderTraverse() {
        var placeHolder = mutableListOf<Int>()
        BSTTraversal().inOrderTraverse(bst,placeHolder)

        Assert.assertArrayEquals(listOf<Int>(5,10,12,15,20).toIntArray(),placeHolder.toIntArray())
    }

    @Test
    fun preOrderTraverse() {
        var placeHolder = mutableListOf<Int>()
        BSTTraversal().preOrderTraverse(bst,placeHolder)

        Assert.assertArrayEquals(listOf<Int>(10, 5, 15, 12, 20).toIntArray(),placeHolder.toIntArray())
    }

    @Test
    fun postOrderTraverse() {
        var placeHolder = mutableListOf<Int>()
        BSTTraversal().postOrderTraverse(bst,placeHolder)

        Assert.assertArrayEquals(listOf<Int>(5, 12, 20, 15, 10).toIntArray(),placeHolder.toIntArray())
    }
}