package easy

class ProductSum {
    fun productSum(array: List<*>): Int {
        return productSum(array,1)
    }

    private fun productSum(rV : List<*>, count:Int): Int {
        var finalProductSum = 0
        for(x in rV){
            if(x is Int){
                finalProductSum += x
            }else{
                finalProductSum += productSum(x as List<*>,count+1)
            }
        }
        return finalProductSum * count;
    }
}