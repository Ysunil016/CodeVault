package _30Days.WeekThree;

public class BST_Preorder {

	static class TreeNode {
		int data;
		TreeNode left = null;
		TreeNode right = null;

		TreeNode(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		int[] arr = { 8, 5, 1, 7, 10, 12 };
		buildBST(arr);
	}

	static TreeNode buildBST(int[] preorder) {
		TreeNode root = new TreeNode(preorder[0]);
		for (int i = 1; i < preorder.length; i++)
			insertInBST(root, preorder[i]);
		return root;
	}

	static void insertInBST(TreeNode root, int data) {
		if (data < root.data) {
			if (root.left == null) {
				root.left = new TreeNode(data);
				System.out.println("Data Left " + data);
			} else
				insertInBST(root.left, data);
		} else {
			if (root.right == null) {
				root.right = new TreeNode(data);
				System.out.println("Data Right " + data);
			} else
				insertInBST(root.right, data);
		}
	}

}
