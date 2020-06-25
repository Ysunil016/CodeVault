package Array;

/**
 * 
 * @Author sunil016
 *
 */

// Assignment QUestion Given by Avinash Sir.

/*
 * Possible Approaches - 1 . Recursive 2 . Iterative 3 . Mathematical
 * 
 * In all these three Approaches we have to have a pivot point from which left
 * is div by 2 or 3 and right is div by 3 or 2. If the condition matches, it is
 * required to compare it with the MIN_DIFF we have already, if current
 * difference if the global min, then store the partition and update the MIN.
 * Complete the traversal and exit the program.
 * 
 * Recursive - Iterative, would need to convert this number into charArray, and
 * then to convert each partite buffers into number for the operation if too
 * much of work and also not efficient, so the best approach would to to go with
 * mathematical approach.
 * 
 * Here, I am dividing number from RIght to left and there after running the
 * logic.
 * 
 * Question is Fairly Straight Forward.
 * 
 * Constraints - No Negative Number Allowed. Number like 01221 will be Treated
 * as Octal Number.
 * 
 * Complexity - O(n) , where n is the number of Digit in the Number, since we
 * are traversing each one.
 */

public class NumberPartition {

	public static void main(String[] args) {
		int num = 234345332;
		
		if (!validateNumber(num)) {
			System.out.println("Invalid Input");
			return;
		}

		int[] arr = getNumbers(num, new int[2]);
		if (arr[0] == 0 || arr[1] == 0) {
			System.out.println("No Partition Possible");
			return;
		}
		System.out.println(arr[0] + " and " + arr[1]);
	}

	private static boolean validateNumber(int num) {
		if (num <= 0) {
			return false;
		}
		return (String.valueOf(num).toCharArray()[0] != '6') ? true : false;
	}

	// Logic *****
	private static int[] getNumbers(int num, int[] arr) {
		int left = num;
		int right = num;
		int counter = 1;

		int MIN_DIFF = Integer.MAX_VALUE;

		while (left != 0) {
			right = num % (10 * counter);
			left = num / (10 * counter);
			counter *= 10;
			if (left % 2 == 0 && right % 3 == 0 || left % 3 == 0 && right % 2 == 0)
				if (Math.abs(left - right) < MIN_DIFF) {
					MIN_DIFF = Math.abs(left - right);
					arr[0] = left;
					arr[1] = right;
				}
		}
		return arr;
	}

}
