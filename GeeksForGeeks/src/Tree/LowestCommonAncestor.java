package Tree;

public class LowestCommonAncestor {

	static class Node {
		int data;
		Node left = null;
		Node right = null;

		public Node(int data) {
			this.data = data;
		}
	}

	static Node commonAnc = new Node(-1);

	public static void main(String[] args) {
		Node root = new Node(1);
		Node _1 = new Node(2);
		Node _2 = new Node(3);
		Node _3 = new Node(4);
		Node _4 = new Node(5);
		Node _5 = new Node(6);
		Node _6 = new Node(7);
		Node _7 = new Node(8);
		Node _8 = new Node(9);
		Node _9 = new Node(10);
		Node _10 = new Node(11);
		Node _11 = new Node(12);

		root.left = _1;
		root.right = _2;
		_1.left = _3;
		_3.left = _11;
		_2.left = _4;
		_2.right = _5;
		_4.left = _6;
		_4.right = _7;
		_7.left = _8;
		_7.right = _9;
		_5.right = _10;

		getCommonAncestor(root);
		System.out.println(commonAnc.data);
	}

	// This Works Only When Two Nodes are at Diff Sub Trees
	private static Node getCommonAncestor(Node root) {
		return (traverse(root, 7, 9, null));
	}

	private static Node traverse(Node root, int src, int dest, Node res) {
		if (root == null)
			return null;

		if (root.data == src || root.data == dest)
			return root;

		Node L = traverse(root.left, src, dest, res);
		Node R = traverse(root.right, src, dest, res);

		if (L != null && R != null) {
			if (res == null) {
				commonAnc = root;
				res = root;
			}
			return res;
		} else if (L == null && R != null) {
			return root.right;
		} else if (L != null && R == null) {
			return root.left;
		}

		return res;
	}

}
