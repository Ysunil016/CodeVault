package LinkedList;

public class FlatteningLinkedList {

	static class Node {
		int data;
		Node next = null;
		Node bottom = null;

		Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		Node root = new Node(5);
		Node rootb1 = root.bottom = new Node(7);
		Node rootb2 = rootb1.bottom = new Node(8);
		rootb2.bottom = new Node(30);
		Node root2 = root.next = new Node(10);
		root2.bottom = new Node(20);
		Node root3 = root2.next = new Node(19);
		Node root3b1 = root3.bottom = new Node(22);
		root3b1.bottom = new Node(50);
		Node root4 = root3.next = new Node(28);
		Node root4b1 = root4.bottom = new Node(35);
		Node root4b2 = root4b1.bottom = new Node(40);
		root4b2.bottom = new Node(45);

		printFlatLinkedList(root);

		System.out.println();

		Node result = getFlatteningList(root);
		System.out.println("Printing Flat");
		printFlatLinkedList(result);
	}

	static Node getFlatteningList(Node head) {
		if (head == null)
			return null;
		Node currentNode = head;
		Node prevTarget = null;
		Node result = null;
		while (currentNode != null) {

			Node newTarget = getButtom(currentNode);
			result = MERGE(newTarget, prevTarget);
			prevTarget = result;
			currentNode = currentNode.next;
		}

		return result;
	}

	static Node MERGE(Node headA, Node headB) {
		Node finalNode = new Node(-1);
		Node result = finalNode;
		while (headA != null && headB != null) {
			if (headA.data <= headB.data) {
				result.bottom = headA;
				headA = headA.bottom;
			} else {
				result.bottom = headB;
				headB = headB.bottom;
			}
			result = result.bottom;
		}

		if (headA != null)
			result.bottom = headA;

		if (headB != null)
			result.bottom = headB;

		return finalNode.bottom;

	}

	static Node getButtom(Node head) {
		Node currentScene = head;
		Node result = new Node(-1);
		Node finalRes = result;
		while (currentScene != null) {
			result.bottom = currentScene;
			result = result.bottom;
			currentScene = currentScene.bottom;
		}

		return finalRes.bottom;
	}

	static void printFlatLinkedList(Node root) {
		while (root != null) {
			System.out.print("-> " + root.data);
			root = root.bottom;
		}
	}

}
