package Tree;

public class PostOrderTraversal {

	public static void main(String[] args) {

		TNode rootNode = new TNode(20);
		postOrderTraversal(RandomTreeGeneration.getRandomTreeGeneration(rootNode, 4, 0));

	}

	// PostOrder Traversal using Recursion
	public static void postOrderTraversal(TNode root) {
		if (root == null)
			return;
		postOrderTraversal(root.left);
		postOrderTraversal(root.right);
		System.out.print("-> " + root.data);
	}

}
