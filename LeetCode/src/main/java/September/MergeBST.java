package September;

import java.util.LinkedList;
import java.util.List;

public class MergeBST {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val) {
			this.val = val;
		}
	}

	public static void main(String[] args) {
		
	}

	public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
		LinkedList<Integer> lList = new LinkedList<>();
		LinkedList<Integer> rList = new LinkedList<>();

		getIntoList(root1, lList);
		getIntoList(root2, rList);

		return mergeList(lList, rList);
	}

	static void getIntoList(TreeNode root, LinkedList<Integer> list) {
		if (root == null)
			return;
		getIntoList(root.left, list);
		list.add(root.val);
		getIntoList(root.right, list);
	}

	static List<Integer> mergeList(LinkedList<Integer> lList, LinkedList<Integer> rList) {
		LinkedList<Integer> resultant = new LinkedList<>();
		while (!lList.isEmpty() && !rList.isEmpty()) {
			int L = lList.peekFirst();
			int R = rList.peekFirst();
			if (L < R) {
				resultant.add(lList.removeFirst());
			} else {
				resultant.add(rList.removeFirst());
			}
		}
		while (!lList.isEmpty()) {
			resultant.add(lList.removeFirst());
		}
		while (!rList.isEmpty()) {
			resultant.add(rList.removeFirst());
		}

		return resultant;
	}

}
