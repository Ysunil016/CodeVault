package leetcode

class LetterCombinations {

    fun letterCombinations(digits: String): List<String> {
        if(digits.isEmpty()) return listOf<String>()
        var mapping = HashMap<Char,String>()
        mapping['2'] = "abc"
        mapping['3'] = "def"
        mapping['4'] = "ghi"
        mapping['5'] = "jkl"
        mapping['6'] = "mno"
        mapping['7'] = "pqrs"
        mapping['8'] = "tuv"
        mapping['9'] = "wxyz"

        val finalResult = mutableListOf<String>()
        if(digits.length == 1){
            for(x in mapping[digits[0]]!!)
                finalResult.add(x.toString())
            return finalResult
        }

        for(index in digits.indices){
            for(x in index+1 until digits.length){
                finalResult.addAll(getMapping(mapping[digits[index]]!!,mapping[digits[x]]!!))
            }
        }
        return finalResult
    }
    private fun getMapping(X:String,Y:String):List<String>{
        val foundString = mutableListOf<String>()
        for(a in X){
            for(b in Y){
                foundString.add(a.toString()+b.toString())
            }
        }
        return foundString
    }
}