package July;

public class BinaryTree_In_Post {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int val) {
			this.val = val;
		}

	}

	public static void main(String[] args) {
		int[] inOrder = { 4, 8, 2, 5, 1, 6, 3, 7 };
		int[] postOrder = { 8, 4, 5, 2, 6, 7, 3, 1 };

		buildTree(inOrder, postOrder, inOrder.length);
	}

	static TreeNode buildTree(int[] inOrder, int[] postOrder, int n) {
		Index iIndex = new Index();
		iIndex.index = n - 1;
		return buildUtils(inOrder, postOrder, 0, n - 1, iIndex);
	}

	static class Index {
		int index;
	}

	static TreeNode buildUtils(int[] inOrder, int[] postOrder, int inStart, int inEnd, Index pIndex) {
		if (inStart > inEnd)
			return null;

		TreeNode tNode = new TreeNode(postOrder[pIndex.index]);
		(pIndex.index)--;

		if (inStart == inEnd)
			return tNode;

		int iIndex = searchIndex(inOrder, inStart, inEnd, tNode.val);

		tNode.right = buildUtils(inOrder, postOrder, iIndex + 1, inEnd, pIndex);
		tNode.left = buildUtils(inOrder, postOrder, inStart, iIndex - 1, pIndex);

		return tNode;
	}

	static int searchIndex(int[] inOrder, int inStart, int inEnd, int val) {
		for (int i = inStart; i <= inEnd; i++) {
			if (inOrder[i] == val)
				return i;
		}
		return -1;
	}

}
