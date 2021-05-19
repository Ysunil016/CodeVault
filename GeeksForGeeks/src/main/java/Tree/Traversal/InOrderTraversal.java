package Tree.Traversal;

import Tree.TNode;

public class InOrderTraversal {

	public static void main(String[] args) {

		TNode rootNode = new TNode(20);
		inOrderTraversal(RandomTreeGeneration.getRandomTreeGeneration(rootNode, 4, 0));

	}

	// InOrder Traversal using Recursion
	public static void inOrderTraversal(TNode root) {
		if (root == null)
			return;
		inOrderTraversal(root.left);
		System.out.print("-> " + root.data);
		inOrderTraversal(root.right);
		}

}
