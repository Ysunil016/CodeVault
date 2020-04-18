package LinkedList;

import java.util.Scanner;

public class InsertInSortedCircular {

	static class Node {
		int data;
		Node next = null;

		Node(int data) {
			this.data = data;
		}
	}

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		int count = scan.nextInt();
		Node root = new Node(-1);
		Node head = root;
		for (int i = 0; i < count; i++) {
			int val = scan.nextInt();
			head.next = new Node(val);
			head = head.next;
		}

		Node startNode = root.next;

		// Making List Circular
		head.next = startNode;

		// Actual LinkedList
		displayList(startNode);

		// Getting Started
		startNode = insertNode(startNode, scan.nextInt());

		// Final Linked List
		displayList(startNode);
	}

	static Node insertNode(Node cList, int key) {
		Node start = cList;
		Node nNode = new Node(key);

		Node prevNode = null;
		// Checking if List ROund Up or there exist place for a new Element.
		while (cList.data < key && cList.next != start) {
			prevNode = cList;
			cList = cList.next;
		}

		if (prevNode == null) {
			while (cList.next != start) {
				cList = cList.next;
			}
			cList.next = nNode;
			nNode.next = start;
			return nNode;

		}

		if (cList.next == start && key > cList.data) {
			cList.next = nNode;
			nNode.next = start;
		} else {
			prevNode.next = nNode;
			nNode.next = cList;
		}
		return start;
	}

	static void displayList(Node head) {
		Node start = head;
		while (head.next != start) {
			System.out.print("-> " + head.data);
			head = head.next;
		}
		System.out.print("-> " + head.data);
		System.out.println();
	}

}
