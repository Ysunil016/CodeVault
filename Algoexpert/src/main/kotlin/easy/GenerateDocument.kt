package easy

class GenerateDocument {

    fun generateDocument(characters: String, document: String): Boolean {
        val charStoreMap = mutableMapOf<Char, Int>()
        characters.toCharArray().map {
            if (charStoreMap.containsKey(it)) {
                charStoreMap[it] = charStoreMap[it]!! + 1
            } else {
                charStoreMap[it] = 1
            }
        }

        val documentStoreMap = mutableMapOf<Char, Int>()
        document.toCharArray().map {
            if (documentStoreMap.containsKey(it)) {
                documentStoreMap[it] = documentStoreMap[it]!! + 1
            } else {
                documentStoreMap[it] = 1
            }
        }

        document.forEach {
            if (!charStoreMap.containsKey(it)) return false;
            else if (documentStoreMap[it]!! > charStoreMap[it]!!) return false;
        }
        return true
    }

}