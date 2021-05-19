package July;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BottomTreeTraversal {

	static class Node {
		int Val;
		Node left = null;
		Node right = null;

		Node(int data) {
			this.Val = data;
		}
	}

	public static void main(String[] args) {
		Node root = new Node(3);
		root.left = new Node(9);
		root.right = new Node(20);
		root.right.left = new Node(15);
		root.right.right = new Node(7);

		List<List<Integer>> res = new ArrayList<List<Integer>>();

		findBottomUpTraversal(root, res);
		Collections.reverse(res);

		for (List<Integer> x : res) {
			for (int y : x) {
				System.out.print(y + " ");
			}
			System.out.println();
		}
	}

	static void findBottomUpTraversal(Node root, List<List<Integer>> res) {
		Queue<Node> Q = new LinkedList<>();
		Q.add(root);
		int rC = 0;
		res.add(rC, Arrays.asList(root.Val));
		rC++;
		while (true) {
			int Counter = Q.size();
			if (Counter == 0) {
				break;
			}

			List<Integer> xRes = new ArrayList<>();
			while (Counter > 0) {
				Node pVal = Q.poll();
				if (pVal.left != null) {
					xRes.add(pVal.left.Val);
					Q.add(pVal.left);
				}
				if (pVal.right != null) {
					xRes.add(pVal.right.Val);
					Q.add(pVal.right);
				}
				Counter--;
			}
			if (xRes.size() != 0) {
				res.add(rC, xRes);
				rC++;
			}
		}
	}

}
