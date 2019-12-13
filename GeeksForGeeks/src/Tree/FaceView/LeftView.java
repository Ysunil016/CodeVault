package Tree.FaceView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.TreeMap;

import Tree.TNode;
import Tree.Traversal.RandomTreeGeneration;

public class LeftView {

	public static void main(String[] args) {

		TNode rootNode = new TNode(69);
		TNode root = RandomTreeGeneration.getRandomTreeGeneration(rootNode, 10, 0);
		System.out.println();

		// TreeMap because it is implemented using Red-Black Tree, that return Sorted
		// Entry
		TreeMap<Integer, ArrayList<TNode>> node = new TreeMap<Integer, ArrayList<TNode>>();
		treeRightView(root, 0, node);

		System.out.println();

		// Left Face
		System.out.println("Left Face View");
		for (Entry<Integer, ArrayList<TNode>> tNode : node.entrySet()) {
			int rightFace = 0;
			int leftFace = -1;
			Iterator<TNode> levelNodeIterator = tNode.getValue().iterator();
			while (levelNodeIterator.hasNext()) {
				rightFace = levelNodeIterator.next().data;
				if (leftFace == -1)
					leftFace = rightFace;
			}
			System.out.print("-> " + leftFace);
		}

	}

	public static void treeRightView(TNode node, int level, TreeMap<Integer, ArrayList<TNode>> allNodesData) {
		if (node == null)
			return;

		ArrayList<TNode> currentLevelNodes = allNodesData.get(level);
		if (currentLevelNodes == (null)) {
			currentLevelNodes = new ArrayList<TNode>();
		}
		currentLevelNodes.add(node);
		allNodesData.put(level, currentLevelNodes);

		treeRightView(node.left, level + 1, allNodesData);
		treeRightView(node.right, level + 1, allNodesData);

	}

}
