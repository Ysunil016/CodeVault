package medium

class ThreeSum {
    fun threeNumberSum(array: MutableList<Int>, targetSum: Int): List<List<Int>> {
        array.sort()
        var resultList = mutableListOf<List<Int>>()
        var hashSet = HashSet<Int>()
        for(x in array)
            hashSet.add(x)
        var i = 0
        var j = 0
        while(i < array.size){
            j = i + 1
            while(j < array.size){
                var requiredValue = targetSum - (array[i] + array[j])
                if(hashSet.contains(requiredValue) && array[i] < requiredValue && array[i] < array[j] && requiredValue > array[j]){
                    resultList.add(listOf(array[i] ,array[j], requiredValue))
                }
                j++
            }
            i++
        }

        return resultList
    }
}