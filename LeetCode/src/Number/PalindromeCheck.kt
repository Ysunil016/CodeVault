package Number

fun main(args: Array<String>) {
	println("Given Palindrome - ${isPalindrome(1000000001)}");
}


fun isPalindrome(temp: Int): Boolean {

	if (temp < 0) return false;

	var divisor = 1;
	while (temp / divisor >= 10)
		divisor *= 10;


	var input: Int = temp;

	while (divisor != 0) {
		var pre: Int = input / divisor;
		var post: Int = input % 10;

		if (pre != post)
			return false;

		input = (input % (divisor)) / 10;

		divisor /= 100;
	}


	return true;
}
