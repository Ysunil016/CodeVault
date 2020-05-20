package May.WeekThree;

public class SmallestInBST {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.left.left.left = new TreeNode(1);
		System.out.println(kthSmallest(root, 2));
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	static int Counter = 0;
	static int KthSmallest = Integer.MIN_VALUE;

	public static int kthSmallest(TreeNode root, int k) {
		traverse(root, k);
		return KthSmallest;
	}

	static void traverse(TreeNode root, int k) {
		if (root == null) {
			return;
		}
		traverse(root.left, k);
		Counter++;
		if (Counter == k) {
			KthSmallest = root.val;
		}
		traverse(root.right, k);
	}

}
