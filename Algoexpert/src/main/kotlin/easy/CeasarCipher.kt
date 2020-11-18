package easy

class CeasarCipher {

    fun caesarCipherEncryptor(string: String, key: Int): String {
        var finalString = ""
        for(i in string.indices){
            var currentValue = string[i].toInt() + (key%26)
            if(currentValue > 122){
                finalString += (currentValue - 122 + 97 - 1).toChar()
            }else{
                finalString += currentValue.toChar()
            }
        }
        return finalString
    }


}