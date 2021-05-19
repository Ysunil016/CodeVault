package medium

import kotlin.math.abs

class MinCharacterWithWord {

    fun minimumCharactersForWords(words: List<String>): List<Char> {
        val listStore = mutableListOf<Char>();
        for (word in words) {
            mergeList(listStore, elements(word))
        }
        return listStore;
    }

    private fun mergeList(listStore: MutableList<Char>, elements: List<Char>) {
        var hashStore = mutableMapOf<Char, Int>()
        listStore.forEach {
            if (hashStore.containsKey(it))
                hashStore[it] = hashStore[it]!! + 1;
            else
                hashStore[it] = 1;
        }
        var elementStore = mutableMapOf<Char, Int>()
        elements.forEach {
            if (elementStore.containsKey(it))
                elementStore[it] = elementStore[it]!! + 1;
            else
                elementStore[it] = 1;
        }

        elementStore.forEach { (key, value) ->
            if (!hashStore.containsKey(key)) {
                listStore.add(key)
                return
            };
            if (value > hashStore[key]!!) {
                repeat(abs(hashStore[key]!! - value)) {
                    listStore.add(key);
                }
            }
        }
        println(listStore)
    }

    private fun elements(string: String): List<Char> {
        return string.map { it }
    }


}