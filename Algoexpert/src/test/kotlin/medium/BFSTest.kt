package medium

import org.junit.Assert
import org.junit.Test

class BFSTest{

    @Test
    fun shouldReturnBFS(){
        var root = BFS.Node("A")
        root.children = mutableListOf<BFS.Node>(BFS.Node("C"),BFS.Node("M"))

        var expectedList = listOf<String>("A","C","M")

        Assert.assertArrayEquals(expectedList.toTypedArray(),root.breadthFirstSearch().toTypedArray())
    }

    @Test
    fun shouldReturnBFS_(){
        var root = BFS.Node("A")

        var expectedList = listOf<String>("A")

        Assert.assertArrayEquals(expectedList.toTypedArray(),root.breadthFirstSearch().toTypedArray())
    }

    @Test
    fun shouldReturnBFS__(){
        var root = BFS.Node("A")
        var nodeX = BFS.Node("C")
        nodeX.children = mutableListOf(BFS.Node("M"),BFS.Node("N"),BFS.Node("O"))
        root.children = mutableListOf<BFS.Node>(nodeX,BFS.Node("M"))

        var expectedList = listOf<String>("A","C","M","M","N","O")

        Assert.assertArrayEquals(expectedList.toTypedArray(),root.breadthFirstSearch().toTypedArray())
    }


}