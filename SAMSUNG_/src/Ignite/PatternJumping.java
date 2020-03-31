package Ignite;

public class PatternJumping {

	public static void main(String[] args) {
		System.out.println("Frog Will Reach to 1 :: " + hasReachedLeaf(1));
		System.out.println("Frog Will Reach to 7 :: " + hasReachedLeaf(7));
		System.out.println("Frog Will Reach to 64 :: " + hasReachedLeaf(64));
	}

	// Checking if Akki Frog will Ever Reach to Distance, since he only can move x
	// distance after 1
	static boolean hasReachedLeaf(int distance) {
		int counter = 1;

		// Base Condition
		while (counter < distance) {
			counter += counter;
		}

		// Finalising Solution
		if (counter == distance)
			return true;

		return false;
	}

}
