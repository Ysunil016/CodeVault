package easy

class ValidateSubSequence {

    // O(n) - Time Complexity
    // O(n) - Space Complexity
    fun isValidSubsequence(array: List<Int>, sequence: List<Int>): Boolean {
        var pointerY = 0;

        for(x in array){
            if(x == sequence[pointerY]){
                pointerY++;
            }
            if(pointerY == sequence.size) return true;
        }
        print(pointerY)

        return pointerY == sequence.size
    }
}