package medium

fun main() {
    println(cycleInGraph(listOf(listOf(0), listOf(0,2), listOf())))
}

fun cycleInGraph(edges: List<List<Int>>): Boolean {
    val visitedNode = MutableList(edges.size) { false }
    val currentStack = MutableList(edges.size) { false }
    for(index in edges.indices){
        if(visitedNode[index]) continue
        if(cycle(index,edges,visitedNode,currentStack)) return true
    }
    return false
}
private fun cycle(node: Int, edges: List<List<Int>>, visitedNode: MutableList<Boolean>,currentStack:MutableList<Boolean>) :Boolean{
    visitedNode[node] = true
    currentStack[node] = true
    val neighbours = edges[node]
    for(neighbour in neighbours){
        if(!visitedNode[neighbour]){
            if(cycle(neighbour,edges,visitedNode,currentStack)) return true
        }else if(currentStack[neighbour]) return true
    }
    currentStack[node] = false
    return false
}

