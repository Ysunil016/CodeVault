package Array

fun main(args: Array<String>) {
	var data: IntArray = intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7);
	findMaxArea(data);
}

fun findMaxArea(data: IntArray): Int {
	var maxArea: Int = 0;

	for (i in 0 until data.count()) {
		for (j in i + 1 until data.count()) {
			var first = data.get(i);
			var second = Math.abs(data.get(j));
			var area = (second - first) * (j - i);
			maxArea = if (maxArea < (area)) area else maxArea;


			println("Area for Loop is $area");
		}
	}



	return maxArea;
}

