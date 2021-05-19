package October

fun main() {
    println(findRepeatedDnaSequences("AAAAAAAAAAAA"))
}

fun findRepeatedDnaSequences(s: String): List<String> {
    if(s.isEmpty())
        return mutableListOf()

    val hashMap = HashMap<String,Int>()
    val resultA = mutableListOf<String>()
    var i = 0;
    while(i+10<=s.length){
        val subString = s.substring(i,i+10)
        hashMap[subString] = hashMap.getOrDefault(subString,0)+1
        if(hashMap.getOrDefault(subString,0) == 2)
            resultA.add(subString)
        i++
    }
    return resultA
}