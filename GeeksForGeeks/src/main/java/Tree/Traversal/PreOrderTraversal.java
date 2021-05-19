package Tree.Traversal;

import Tree.TNode;

public class PreOrderTraversal {

	public static void main(String[] args) {

		TNode rootNode = new TNode(20);
		preOrderTraversal(RandomTreeGeneration.getRandomTreeGeneration(rootNode, 4, 0));

	}

	// PreOrder Traversal using Recursion
	public static void preOrderTraversal(TNode root) {
		if (root == null)
			return;
		System.out.print("-> " + root.data);
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);
	}

}
