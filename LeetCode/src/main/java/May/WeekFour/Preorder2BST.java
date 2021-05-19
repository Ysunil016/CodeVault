package May.WeekFour;

class Solution {
	TreeNode root;

	public TreeNode bstFromPreorder(int[] preorder) {
		root = new TreeNode(preorder[0]);
		for (int i = 1; i < preorder.length; i++) {
			InsertDataInBST(root, preorder[i]);
		}
		return root;
	}

	public void InsertDataInBST(TreeNode root, int data) {
		if (root == null)
			return;
		if (data < root.val) {
			if (root.left == null)
				root.left = new TreeNode(data);
			else
				InsertDataInBST(root.left, data);
		}
		if (data > root.val) {
			if (root.right == null)
				root.right = new TreeNode(data);
			else
				InsertDataInBST(root.right, data);
		}
	}
}


public class Preorder2BST {

	public static void main(String[] args) {
		Solution sol = new Solution();
		sol.bstFromPreorder(new int[] {1,2,3,4,5});
	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

