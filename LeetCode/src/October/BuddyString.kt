package October

import java.util.*


fun main(){
    println(BuddyString().buddyStrings("ab", "ba"))
    println(BuddyString().buddyStrings("ab", "ab"))
    println(BuddyString().buddyStrings("aa", "aa"))
    println(BuddyString().buddyStrings("aaaaaaabc", "aaaaaaacb"))
    println(BuddyString().buddyStrings("", "aa"))
}

class BuddyString {
    fun buddyStrings(A: String, B: String):Boolean {
        if(A.length!=B.length)
            return false

        if (A==B) {
            val set: MutableSet<Char> = HashSet<Char>()
            for (c in A.toCharArray()) {
                if (set.contains(c)) return true
                set.add(c)
            }
            return false
        }

        val index: MutableList<Int> = ArrayList<Int>()
        for (i in A.indices) {
            if (A[i] != B[i]) index.add(i)
            if (index.size > 2) return false
        }
        return index.size == 2 && A[index[0]] == B[index[1]] && A[index[1]] == B[index[0]]
    }
}