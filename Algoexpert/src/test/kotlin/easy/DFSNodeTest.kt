package easy

import org.junit.Assert
import org.junit.Test

class DFSNodeTest{

    @Test
    fun shouldReturnList(){
        var nodeX = DFSNode("A")
        nodeX.children.addAll(mutableListOf(DFSNode("B"),DFSNode("C"),DFSNode("D"),DFSNode("E"),DFSNode("F")))

        var expectedResult = nodeX.depthFirstSearch()

        Assert.assertEquals(expectedResult.toMutableList(), mutableListOf<String>("A","B","C","D","E","F").toMutableList())
    }

    @Test
    fun shouldReturnList_(){
        var nodeX = DFSNode("Z")
        nodeX.children.addAll(mutableListOf(DFSNode("B"),DFSNode("C"),DFSNode("D"),DFSNode("E"),DFSNode("F")))

        var expectedResult = nodeX.depthFirstSearch()

        Assert.assertEquals(expectedResult.toMutableList(), mutableListOf<String>("Z","B","C","D","E","F").toMutableList())
    }

    @Test
    fun shouldReturnList__(){
        var nodeX = DFSNode("P")
        nodeX.children.addAll(mutableListOf(DFSNode("B"),DFSNode("C"),DFSNode("D"),DFSNode("E"),DFSNode("F")))

        var expectedResult = nodeX.depthFirstSearch()

        Assert.assertEquals(expectedResult.toMutableList(), mutableListOf<String>("P","B","C","D","E","F").toMutableList())
    }
}