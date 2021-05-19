package August;

import java.util.ArrayList;
import java.util.List;

public class DeleteNodeBST {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val) {
			this.val = val;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public TreeNode deleteNode(TreeNode root, int key) {
		if (root == null)
			return root;
		if (root.val == key) {
			return getBST(root);
		}
		deleteNodeTree(root, key);
		return root;
	}

	private void deleteNodeTree(TreeNode root, int key) {
		if (root == null)
			return;

		if (root.left != null && root.left.val == key) {
			TreeNode rootHead = root.left;
			root.left = getBST(rootHead);
		} else if (root.right != null && root.right.val == key) {
			TreeNode rootHead = root.right;
			root.right = getBST(rootHead);
		}
		if (key > root.val) {
			deleteNodeTree(root.right, key);
		} else {
			deleteNodeTree(root.left, key);
		}
	}

	private TreeNode getBST(TreeNode root) {
		List<TreeNode> list = new ArrayList<>();
		getAllNodes(root, list);
		if (list.size() < 2)
			return null;

		TreeNode toor = null;
		for (int i = 1; i < list.size(); i++) {
			TreeNode curNode = list.get(i);
			toor = insert_Recursive(toor, curNode.val);
		}
		return toor;
	}

	TreeNode insert_Recursive(TreeNode root, int key) {
		if (root == null) {
			root = new TreeNode(key);
			return root;
		}
		if (key < root.val) // insert in the left subtree
			root.left = insert_Recursive(root.left, key);
		else if (key > root.val) // insert in the right subtree
			root.right = insert_Recursive(root.right, key);
		return root;
	}

	private void getAllNodes(TreeNode root, List<TreeNode> list) {
		if (root == null)
			return;
		list.add(root);
		getAllNodes(root.left, list);
		getAllNodes(root.right, list);
	}

}
