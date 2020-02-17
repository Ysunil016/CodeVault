package Number

fun main(args: Array<String>) {
	println(isPowerOf2(1));
	println(isPowerOf2(83));

}


fun isPowerOf2(data: Int): String {
	if (data == 1) return "YES";
	if (checkDiv(data) != 2) return "NO";
	else return "YES";
}

fun checkDiv(data: Int): Int {
	if (data == 0 || data % 2 != 0) return 0;
	if (data == 2) return data;
	else
		return checkDiv(data / 2);
}
