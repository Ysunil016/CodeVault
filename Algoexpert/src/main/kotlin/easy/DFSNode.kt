package easy

    class DFSNode(name: String) {
        val name: String = name
        val children = mutableListOf<DFSNode>()
        var list = mutableListOf<String>()

        fun depthFirstSearch(): List<String> {
            search(this)
            return list
        }

        fun search(node : DFSNode){
            list.add(node.name)
            for(cN in node.children){
                search(cN)
            }
        }
}