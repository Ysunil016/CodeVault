package medium

import java.util.*

class BFS {

    class Node(name: String) {
        val name: String = name
        var children = mutableListOf<Node>()

        fun breadthFirstSearch(): List<String> {
            var finalList = mutableListOf<String>()
            var queue = LinkedList<Node>()
            queue.add(this)

            while(!queue.isEmpty()){
                var size = queue.size
                while(size > 0){
                    var n = queue.poll()
                    finalList.add(n.name)
                    for(child in n.children){
                        print(child.name)
                        queue.add(child)
                    }
                    size--
                }
            }

            return finalList
        }
    }

}