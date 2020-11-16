package easy

import org.junit.Assert
import org.junit.Test
class BranchSumTest{

    @Test
    fun shouldReturnValues(){
        var root = BinaryTree(1)
        root.left = BinaryTree(2)
        root.right = BinaryTree(3)
        root.left?.left = BinaryTree(4)
        root.left?.right = BinaryTree(5)
        root.left?.left?.left = BinaryTree(8)
        root.left?.left?.right = BinaryTree(9)
        root.left?.right?.left = BinaryTree(10)
        root.right?.left = BinaryTree(6)
        root.right?.right = BinaryTree(7)
        var branchSum = BranchSum()
        var expectedCount = 5
        var expectedList = listOf<Int>(15,16,18,10,11)

        var actualList = branchSum.branchSums(root)

        Assert.assertEquals(expectedCount,actualList.size)
        Assert.assertArrayEquals(expectedList.toIntArray(),actualList.toIntArray())
    }

    @Test
    fun shouldReturnValues_(){
        var root = BinaryTree(1)
        root.left = BinaryTree(2)
        root.right = BinaryTree(3)
        root.left?.left = BinaryTree(4)
        root.right?.right = BinaryTree(7)

        var branchSum = BranchSum()
        var expectedCount = 2
        var expectedList = listOf<Int>(7,11)

        var actualList = branchSum.branchSums(root)

        Assert.assertEquals(expectedCount,actualList.size)
        println(actualList)
        Assert.assertArrayEquals(expectedList.toIntArray(),actualList.toIntArray())
    }

}