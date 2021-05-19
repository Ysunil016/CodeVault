package LinkedList;

public class Matrix2LinkedList {
	static class Node {
		int data;
		Node right = null;
		Node down = null;

		Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {

		int[][] ar = { { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 } };
		printArray(ar);
		Node head = (getLinkedList(ar, 0, 0, ar.length));
		printLinkedList(head);
	}

	static Node getLinkedList(int[][] ar, int x, int y, int len) {
		if (x > len - 1 || y > len - 1)
			return null;

		Node node = new Node(ar[x][y]);
		node.right = getLinkedList(ar, x, y+1, len);
		node.down = getLinkedList(ar, x+1, y, len);
		return node;
	}

	static void printLinkedList(Node head) {
		if (head == null)
			return;
		if (head.right == null && head.down == null)
			System.out.println(head.data + " has Noting");
		else if (head.right != null && head.down != null)
			System.out.println(head.data + " has " + head.right.data + " and " + head.down.data);
		else if (head.right == null)
			System.out.println(head.data + " has Down " + head.down.data);
		else if (head.down == null)
			System.out.println(head.data + " has Right " + head.right.data);

		printLinkedList(head.right);
		printLinkedList(head.down);
	}

	static void printArray(int[][] ar) {
		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar.length; j++) {
				System.out.print(ar[i][j] + " ");
			}
			System.out.println();
		}
	}

}
