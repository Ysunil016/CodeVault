package medium

class KadanesAlgorithm {

    fun kadanesAlgorithm(array: List<Int>): Int {
        var finalMaxSum = Int.MIN_VALUE
        var sum = 0

        for(x in array){
            if(sum < 0) sum = 0
            sum += x
            if(sum > finalMaxSum)
                finalMaxSum = sum
        }
        return finalMaxSum
    }

}