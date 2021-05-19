package Tree;

public class PathSumTree {

	static class Node {
		int data;
		Node left = null;
		Node right = null;

		Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(8);
		root.left.left = new Node(3);
		root.left.right = new Node(5);
		root.right = new Node(2);
		root.right.left = new Node(2);
//		root.right.right = new Node(2);

		System.out.println(hasPath(root, 21, 0));

	}

	static boolean hasPath(Node root, int result, int sum) {

		if (root == null)
			return false;

		if (root.left == null && root.right == null && result == sum + root.data)
			return true;

		return hasPath(root.left, result, sum + root.data) || hasPath(root.right, result, sum + root.data);
	}

}
