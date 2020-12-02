package medium

class SingleCycleCheck {

    fun hasSingleCycle(array: List<Int>): Boolean {
        var booleanArray = BooleanArray(array.size)
        var initPoint = array[0]
        if(initPoint < 0) initPoint = array.size - initPoint
        while(true){
            initPoint %= array.size
            booleanArray[initPoint] = true
            initPoint += array[initPoint]
            initPoint %= array.size
            if(initPoint < 0) initPoint += array.size
            if(initPoint >= array.size) initPoint -= array.size
            if(booleanArray[initPoint]){
                break;
            }
        }
        for(v in booleanArray) if(!v) return false
        return true
    }

}