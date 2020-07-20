package _60Days.LinkedList;

public class DeleteNode {

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
		deleteNode(root, 10);
		display(root);
	}

	private static void display(LLNode head) {
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
	}

	private static void deleteNode(LLNode head, int delNode) {
		LLNode PrevNode = head;
		while (head != null) {
			LLNode successor = head.next;
			if (head.val == delNode) {
				PrevNode.next = successor;
				return;
			}
			PrevNode = head;
			head = head.next;
		}
	}

}
