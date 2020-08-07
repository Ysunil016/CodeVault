package August;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class VerticalOrder {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val) {
			this.val = val;
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		for (List<Integer> x : verticalTraversal(root)) {
			for (int a : x) {
				System.out.print(a + " ");
			}
			System.out.println();
		}
	}

	public static List<List<Integer>> verticalTraversal(TreeNode root) {
		List<List<Integer>> res = new LinkedList<>();

		class QNode {
			int x;
			int y;
			TreeNode node;

			public QNode(TreeNode node, int x, int y) {
				this.x = x;
				this.y = y;
				this.node = node;
			}
		}
		TreeMap<Integer, ArrayList<QNode>> hash = new TreeMap<>();
		Queue<QNode> queue = new LinkedList<>();
		queue.add(new QNode(root, 0, 0));
		while (true) {
			int size = queue.size();
			if (size == 0)
				break;
			while (size > 0) {
				QNode cNode = queue.poll();
				if (hash.containsKey(cNode.x)) {
					ArrayList<QNode> arrayList = hash.get(cNode.x);
					arrayList.add(cNode);
					Collections.sort(arrayList,
							(P1, P2) -> (P1.x == P2.x) ? (P1.y == P2.y) ? (P1.node.val - P2.node.val) : (P2.y - P1.y)
									: (P1.x - P2.x));
					hash.put(cNode.x, arrayList);
				} else {
					ArrayList<QNode> arrayList = new ArrayList<QNode>();
					arrayList.add(cNode);
					Collections.sort(arrayList,
							(P1, P2) -> (P1.x == P2.x) ? (P1.y == P2.y) ? (P1.node.val - P2.node.val) : (P2.y - P1.y)
									: (P1.x - P2.x));
					hash.put(cNode.x, arrayList);
				}
				if (cNode.node.left != null) {
					queue.add(new QNode(cNode.node.left, cNode.x - 1, cNode.y - 1));
				}
				if (cNode.node.right != null) {
					queue.add(new QNode(cNode.node.right, cNode.x + 1, cNode.y - 1));
				}
				size--;
			}
		}

		for (Map.Entry<Integer, ArrayList<QNode>> X : hash.entrySet()) {
			ArrayList<Integer> tArray = new ArrayList<>();
			for (QNode qX : X.getValue()) {
				tArray.add(qX.node.val);
			}
			res.add(tArray);
		}

		return res;
	}
}
