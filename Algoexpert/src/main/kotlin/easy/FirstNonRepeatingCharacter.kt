package easy

class FirstNonRepeatingCharacter {
    fun firstNonRepeatingCharacter(string: String): Int {
        val store = IntArray(26) { 0 };
        val stringCharArray = string.toCharArray()
        for (char in stringCharArray) {
            store[char - 'a']++
        }
        for (i in stringCharArray.indices) {
            if (store[stringCharArray[i] - 'a'] == 1) return i
        }
        return -1
    }
}