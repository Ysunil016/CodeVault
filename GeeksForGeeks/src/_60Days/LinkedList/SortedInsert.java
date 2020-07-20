package _60Days.LinkedList;

public class SortedInsert {

	static class LLNode {
		int val;
		LLNode next;

		public LLNode(int val) {
			this.val = val;
		}
	}

	public static void main(String[] args) {
		LLNode root = new LLNode(2);
		root.next = new LLNode(5);
		root.next.next = new LLNode(7);
		root.next.next.next = new LLNode(10);
		root.next.next.next.next = new LLNode(15);
		display(root);
		System.out.println();
		root = insertNode(root, new LLNode(4));
		display(root);
	}

	private static void display(LLNode head) {
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
	}

	public static LLNode insertNode(LLNode head, LLNode node) {
		if (head == null) {
			return node;
		}
		if (head.val > node.val) {
			node.next = head;
			return node;
		}

		LLNode TNode = head;
		LLNode PrevNode = head;
		while (head != null && head.val < node.val) {
			PrevNode = head;
			head = head.next;
		}
		PrevNode.next = node;
		node.next = head;

		return TNode;
	}

}
