package October

import java.util.*
import kotlin.collections.HashMap

class Node(var `val`: Int) {
 var neighbors: ArrayList<Node?> = ArrayList<Node?>()
}

fun main() {

}

fun cloneGraph(node:Node?):Node?{
    if(node==null){
        return null
    }
    val queue = LinkedList<Node>()
    queue.add(node)
    val mapNode = HashMap<Node,Node>()
    mapNode[node] = Node(node.`val`)
    while (!queue.isEmpty()){
        val currentNode = queue.poll()
        for(nodeX in currentNode.neighbors){
            if(!mapNode.containsKey(nodeX)){
                mapNode[nodeX!!] = Node(nodeX.`val`)
                queue.add(nodeX)
            }
            mapNode[currentNode]?.neighbors?.add(mapNode[nodeX])
        }
    }
    return mapNode[node]
}