package medium

open class MinBstO(value: Int) {
    var value = value
    var left: MinBstO? = null
    var right: MinBstO? = null

    fun insert(value: Int) {
        if (value < this.value) {
            if (this.left == null) {
                this.left = MinBstO(value)
            } else {
                this.left!!.insert(value)
            }
        } else {
            if (this.right == null) {
                this.right = MinBstO(value)
            } else {
                this.right!!.insert(value)
            }
        }
    }
}

class MinBST{

    fun minHeightBst(array: List<Int>): MinBstO {
        var mid = (array.size)/2
        var root = MinBstO(array[mid])
        root.left = make(root,array,0,mid)
        root.right = make(root,array,mid+1,array.size-1)


        return root
    }

    private fun make(root: MinBstO?,array:List<Int>, start: Int,end:Int):MinBstO {
        var mid = start + (end-start)/2
        root.let { root?.left = make(root?.left,array,start,mid) }
        root.let { root?.right = make(root?.right,array,mid+1,end) }
        return MinBstO(array[mid])
    }



}


