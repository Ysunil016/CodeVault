package easy

class RunLengthEncoding {

    fun runLengthEncoding(string: String): String {
        if(string.isEmpty()) return ""
        var prevChar = string[0]
        var prevCount = 0

        var counter = 0
        var finalStringBuilder = StringBuilder()
        while(counter < string.length){
            if(prevCount < 9 && string[counter] == prevChar){
                prevCount += 1
            }else{
                finalStringBuilder.append(prevCount,prevChar)
                prevCount = 1
            }
            prevChar = string[counter]
            counter += 1
        }
        finalStringBuilder.append(prevCount,string[counter-1])

        return String(finalStringBuilder)
    }

}