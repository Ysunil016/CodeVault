package easy

import org.junit.Assert.*
import org.junit.Test

class ClosestInBSTKtTest{
    @Test
    fun shouldReturnThirteen(){
        var root = BST(10)
        root.left = BST(5)
        root.right = BST(15)
        root.left?.left = BST(2)
        root.left?.right = BST(5)
        root.left?.left?.left = BST(1)
        root.right?.left = BST(13)
        root.right?.right = BST(22)
        root.right?.left = BST(13)
        root.right?.left?.left = BST(14)

        val expectedValue = 13

        val close = ClosestInBST()
        val actualValue = close.findClosestValueInBst(root,12)

        assertEquals(expectedValue,actualValue)
    }

    @Test
    fun shouldReturnDFS(){
        var root = BST(10)
        root.left = BST(5)
        root.right = BST(15)
        root.left?.left = BST(2)
        root.left?.right = BST(5)
        root.left?.left?.left = BST(1)
        root.right?.left = BST(13)
        root.right?.right = BST(22)
        root.right?.left = BST(13)
        root.right?.left?.left = BST(14)

        val expectedValue = 13

        val close = ClosestInBST()
        val actualValue = close.findClosestValueInBstDFS(root,12)

        assertEquals(expectedValue,actualValue)
    }

    @Test
    fun shouldReturnBFS_(){
        var root = BST(10)
        root.left = BST(5)
        root.right = BST(15)
        root.left?.left = BST(2)
        root.left?.right = BST(15)
        root.left?.left?.left = BST(1)
        root.right?.left = BST(13)
        root.right?.right = BST(422)
        root.right?.left = BST(13)
        root.right?.left?.left = BST(14)

        val expectedValue = 422

        val close = ClosestInBST()
        val actualValue = close.findClosestValueInBst(root,400)

        assertEquals(expectedValue,actualValue)
    }

    @Test
    fun shouldReturnDFS_(){
        var root = BST(10)
        root.left = BST(5)
        root.right = BST(15)
        root.left?.left = BST(-22)
        root.left?.right = BST(5)
        root.left?.left?.left = BST(1)
        root.right?.left = BST(13)
        root.right?.right = BST(22)
        root.right?.left = BST(13)
        root.right?.left?.left = BST(14)

        val expectedValue = -22

        val close = ClosestInBST()
        val actualValue = close.findClosestValueInBstDFS(root,-20)

        assertEquals(expectedValue,actualValue)
    }

}