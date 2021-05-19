package Tree.Problems;

public class MinDepthOfTree {

	static class Node {
		int data;
		Node left = null;
		Node right = null;

		Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int minDepth(Node root) {
		if (root == null)
			return 0;
		return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
	}
}
