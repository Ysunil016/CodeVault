package interviews

class Blocks {

    fun findBestBlock(blocks: List<HashMap<String,Boolean>>, requirements: List<String>){

    }

    private fun findNearestDistanceBlock(currentBlockIndex:Int, blocks: List<HashMap<String,Boolean>>, requirements: List<String>): MutableMap<String, Int> {
        val currentBlock = blocks[currentBlockIndex]
        val currentBlockDistance = requirements.map { Pair(it,-1) }.toMap().toMutableMap()
        for((key,value ) in currentBlock){
            if(value)
                currentBlockDistance[key] = 0
        }
        if(checkIfAllAmenitiesAreDone(currentBlockDistance = currentBlockDistance)) return currentBlockDistance

        for(i in currentBlockIndex + 1 until blocks.size){
            val neighbourBlock = blocks[i]
            for((key,value ) in neighbourBlock){
                if(value && currentBlockDistance[key] != -1)
                    currentBlockDistance[key]?.plus(i)?.let { currentBlockDistance.put(key, it) }
            }
        }
        for(i in currentBlockIndex - 1 until 0){
            val neighbourBlock = blocks[i]
            for((key,value ) in neighbourBlock){
                if(value && currentBlockDistance[key] != -1)
                    currentBlockDistance[key]?.plus(i)?.let { currentBlockDistance.put(key, it) }
            }
        }
        return currentBlockDistance
    }

    private fun checkIfAllAmenitiesAreDone(currentBlockDistance: MutableMap<String,Int>): Boolean {
        return currentBlockDistance.filter { (key,value) -> value== -1 }.isNotEmpty()
    }

}