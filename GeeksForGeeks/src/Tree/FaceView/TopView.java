package Tree.FaceView;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import Tree.TNode;
import Tree.Traversal.RandomTreeGeneration;

public class TopView {

	public static void main(String[] args) {

		TNode rootNode = new TNode(69);
		TNode root = RandomTreeGeneration.getRandomTreeGeneration(rootNode, 2, 0);
		System.out.println();

		// TreeMap because it is implemented using Red-Black Tree, that return Sorted
		// Entry
		TreeMap<Integer, TNode> node = new TreeMap<Integer, TNode>();
		treeTopView(root, 0, node);

		System.out.println();

		// Left Face
		System.out.println("Left Face View");
		for (Map.Entry<Integer, TNode> tNode : node.entrySet()) {
			System.out.print("-> " + tNode.getValue().data);
		}

	}

	public static void treeTopView(TNode node, int level, TreeMap<Integer, TNode> allNodesData) {
		class QueueObj {
			TNode node;
			int hd;

			QueueObj(TNode node, int hd) {
				this.node = node;
				this.hd = hd;
			}
		}

		if (node == null)
			return;

		Queue<QueueObj> q = new LinkedList<QueueObj>();
		q.add(new QueueObj(node, 0));

		while (!q.isEmpty()) {
			QueueObj tmpNode = q.poll();
			if (!allNodesData.containsKey(tmpNode.hd)) {
				allNodesData.put(tmpNode.hd, tmpNode.node);
			}

			if (tmpNode.node.left != null) {
				q.add(new QueueObj(tmpNode.node.left, tmpNode.hd - 1));
			}
			if (tmpNode.node.right != null) {
				q.add(new QueueObj(tmpNode.node.right, tmpNode.hd + 1));
			}

		}
	}

}
