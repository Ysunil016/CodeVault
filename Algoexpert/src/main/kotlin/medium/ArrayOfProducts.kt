package medium

class ArrayOfProducts{

    fun arrayOfProducts(array: List<Int>): List<Int> {
        var products = 1
        var zeroCounts = 0
        var zeroIndex = 0

        for((x, v) in array.withIndex()) {
            if (v != 0)
                products *= v
            else {
                zeroCounts++
                zeroIndex = x
            }
        }

        var finalArray = mutableListOf<Int>()

        if(zeroCounts > 1) {
            for (v in array) {
                finalArray.add(0)
            }
            return finalArray
        }else if (zeroCounts == 1){
            for (v in array) {
                finalArray.add(0)
            }
            finalArray[zeroIndex] = products
            return finalArray
        }

        var counter = 0
        while(counter < array.size){
            finalArray.add(products/array[counter])
            counter++
        }
        return finalArray
    }

    fun arrayOfProducts_BF(array: List<Int>): List<Int> {
        var x = mutableListOf<Int>()
        for(i in array.indices){
            x.add(getTheProduct(array,i))
        }
        return x
    }
    private fun getTheProduct(array:List<Int>,index:Int):Int{
        var product = 1
        for(i in array.indices){
            if(i != index)
                product *= array[i]
        }
        return product
    }

}