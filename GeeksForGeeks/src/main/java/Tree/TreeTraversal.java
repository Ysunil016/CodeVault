package Tree;

public class TreeTraversal {

	public static void main(String[] args) {

		TNode rootNode = new TNode(69);
		TNode root = RandomTreeGeneration.getRandomTreeGeneration(rootNode, 2, 0);
		System.out.println();
		System.out.println("PreOrder Tree Traversal");
		PreOrderTraversal.preOrderTraversal(root);

		System.out.println();
		System.out.println();
		System.out.println("PostOrder Tree Traversal");
		PostOrderTraversal.postOrderTraversal(root);

		System.out.println();
		System.out.println();
		System.out.println("InOrder Tree Traversal");
		InOrderTraversal.inOrderTraversal(root);

		System.out.println();
		System.out.println();
		System.out.println("LevelOrder Tree Traversal from Left 2 Right");
		LevelOrderTraversal.levelOrderTraversal_Left2Right(root);

		System.out.println();
		System.out.println();
		System.out.println("LevelOrder Tree Traversal from Right 2 Left");
		LevelOrderTraversal.levelOrderTraversal_Right2Left(root);

		System.out.println();
		System.out.println();
		System.out.println("LevelOrder Tree Traversal from Left 2 Right Reverse");
		LevelOrderTraversal.levelOrderTraversal_Left2Right_Bottom2Up(root);

		System.out.println();
		System.out.println();
		System.out.println("LevelOrder Tree Traversal from Right 2 Left Reverse");
		LevelOrderTraversal.levelOrderTraversal_Right2Left_Bottom2Up(root);

	}

}
