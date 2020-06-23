package June.WeekFour;

public class CountCompleteTreeNodes {

	static class TreeNode {
		int val;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		System.out.println(countNodes(root));
	}

	public static int countNodes(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return 1 + countNodes(root.left) + countNodes(root.right);
	}

}
