package easy

import org.junit.Assert
import org.junit.Test


class NodeDepthTest{

    @Test
    fun shouldReturnDepthAsSix(){
        var root = BinaryTree(1)
        root.left = BinaryTree(2)
        root.right = BinaryTree(3)
        root.left?.left = BinaryTree(4)
        root.right?.right = BinaryTree(7)
        val expectedDepth = 6

        var nd = NodeDepth()
        var nodeDepthValue = nd.nodeDepths(root)

        Assert.assertEquals(expectedDepth,nodeDepthValue)
    }
    @Test
    fun shouldReturnDepthAsSixteen(){
        var root = BinaryTree(1)
        root.left = BinaryTree(2)
        root.right = BinaryTree(3)
        root.left?.right = BinaryTree(5)
        root.left?.left = BinaryTree(4)
        root.left?.left?.left = BinaryTree(8)
        root.left?.left?.right = BinaryTree(9)
        root.right?.left = BinaryTree(6)
        root.right?.right = BinaryTree(7)
        val expectedDepth = 16

        var nd = NodeDepth()
        var nodeDepthValue = nd.nodeDepths(root)

        Assert.assertEquals(expectedDepth,nodeDepthValue)
    }

    @Test
    fun shouldReturnDepthAsZero(){
        var root = BinaryTree(1)
        val expectedDepth = 0

        var nd = NodeDepth()
        var nodeDepthValue = nd.nodeDepths(root)

        Assert.assertEquals(expectedDepth,nodeDepthValue)
    }





    @Test
    fun shouldReturnDepthAsSix_(){
        var root = BinaryTree(1)
        root.left = BinaryTree(2)
        root.right = BinaryTree(3)
        root.left?.left = BinaryTree(4)
        root.right?.right = BinaryTree(7)
        val expectedDepth = 6

        var nd = NodeDepth()
        var nodeDepthValue = nd.nodeDepths_2(root)

        Assert.assertEquals(expectedDepth,nodeDepthValue)
    }
    @Test
    fun shouldReturnDepthAsSixteen_(){
        var root = BinaryTree(1)
        root.left = BinaryTree(2)
        root.right = BinaryTree(3)
        root.left?.right = BinaryTree(5)
        root.left?.left = BinaryTree(4)
        root.left?.left?.left = BinaryTree(8)
        root.left?.left?.right = BinaryTree(9)
        root.right?.left = BinaryTree(6)
        root.right?.right = BinaryTree(7)
        val expectedDepth = 16

        var nd = NodeDepth()
        var nodeDepthValue = nd.nodeDepths_2(root)

        Assert.assertEquals(expectedDepth,nodeDepthValue)
    }

    @Test
    fun shouldReturnDepthAsZero_(){
        var root = BinaryTree(1)
        val expectedDepth = 0

        var nd = NodeDepth()
        var nodeDepthValue = nd.nodeDepths_2(root)

        Assert.assertEquals(expectedDepth,nodeDepthValue)
    }

}