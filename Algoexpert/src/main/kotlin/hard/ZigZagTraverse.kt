package hard

class ZigZagTraverse {

    fun zigzagTraverse(array: List<List<Int>>): List<Int> {
        val n = array.size
        val m = array[0].size
        var topDown = true;

        // TOP to BOTTOM

        for (i in 0 until n) {
            var x = i;
            var y = 0;
            while (x >= 0 && y >= 0 && y < array.size && x < array[0].size) {
                print("${array[x][y]} ")
                if (topDown) {
                    y += 1;
                    x -= 1;
                } else {
                    y -= 1;
                    x += 1;
                }
                topDown = !topDown
            }
            println()
        }

        // BOTTOM to UP
//        for (i in 0 until n) {
//            if (topDown) {
//
//            } else {
//
//            }
//        }


        return listOf()
    }
}