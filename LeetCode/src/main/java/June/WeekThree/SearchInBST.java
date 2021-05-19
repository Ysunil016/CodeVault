package June.WeekThree;

public class SearchInBST {

	static class TreeNode {
		int val;
		TreeNode right = null;
		TreeNode left = null;

		public TreeNode(int val) {
			this.val = val;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static TreeNode searchBST(TreeNode root, int val) {
		if (root == null) {
			return null;
		}
		return hasFound(root, val);
	}

	private static TreeNode hasFound(TreeNode root, int val) {
		if (root == null) {
			return null;
		}
		if (root.val == val) {
			return root;
		}
		if (val > root.val) {
			return hasFound(root.right, val);
		} else {
			return hasFound(root.left, val);
		}
	}

}
