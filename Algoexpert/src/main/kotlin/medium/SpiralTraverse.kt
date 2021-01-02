package medium


fun main() {
    spiralTraverse(listOf(listOf(1,2,3,4), listOf(12,13,14,5), listOf(11,16,15,6), listOf(10,9,8,7)))
}

fun spiralTraverse(array: List<List<Int>>): List<Int> {
    var row = array.size
    var col = array[0].size
    var counter = 0
    while(counter < array.size/2){
        for(x in 0 until col-counter){
            println(array[counter][x])
        }
        for(x in 1 until row - counter){
            println(array[x - counter][col - 1 -counter])
        }
        for(x in (col - 1) downTo 1){
            println(array[row - 1 ][x-1])
        }
        for(x in (row - 1) downTo 2){
            println(array[x - 1][0])
        }
        counter++
    }

    return listOf<Int>()
}
