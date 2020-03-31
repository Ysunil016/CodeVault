package Ignite;

public class SwapNumberWithoutVariable {

	public static void main(String[] args) {
		swapTwoNumbers();
	}

	static void swapTwoNumbers() {
		int A = 20, B = 30;
		// Swapping Logic
		A = A + B;
		B = A - B;
		A = A - B;
		System.out.println("A : " + A + "\nB : " + B);
	}

}
