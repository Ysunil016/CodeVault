package Basic

//We Need to Use fun as Function in Java and No Need to Specify ReturnType for Void ||
//public static void main(String[] args)
//String[] is Array<String>

fun main(args: Array<String>) {
	print("Sum of A and B " + sumOfNumber(4, 3));
}

//For Loop Works Like in Python as for(t in Z)

//fun printAllMembersOfArray(allUser: ArrayList<Person>) {
//	for (person in allUser)
//		println("I am " + person.name + " and has Age " + person.age);
//}

fun sumOfNumber(a: Int, b: Int): Int {
	return (a + b);
}