package Array

fun main(args: Array<String>) {

}

fun remove(arr: IntArray, value: Int): Int {
	var pointer: Int = 0;
	var counter = 0;
	for (i in 0 until arr.count()) {
		if (arr.get(pointer) == value) {
			
			counter++;
		}
	}
	return counter;
}