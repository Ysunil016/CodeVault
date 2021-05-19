package Tree.Problems;

public class SumAtBT {

	static class Node {
		int data;
		Node left = null;
		Node right = null;

		Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {

	}

	static int sum = 0;
	static void getSum(Node root) {
		if (root == null)
			return;

		sum += root.data;
		getSum(root.left);
		getSum(root.right);
	}
}
