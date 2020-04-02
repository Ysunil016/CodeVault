package Array;

import java.util.Scanner;

public class ArrayQuery {

	static class Node {
		int data;
		Node next = null;

		Node(int data) {
			this.data = data;
		}
	}

	static int difference = 0;

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		int N = scan.nextInt();
		int Q = scan.nextInt();

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = scan.nextInt();
		}

		// Making Linked List Out of Array , as Insertion and Modification is Cost
		// Effective in LinkedList
		Node head = new Node(-1);
		Node tHead = head;

		for (int i : arr) {
			head.next = new Node(i);
			head = head.next;
		}
		tHead = tHead.next;

		for (int i = 0; i < Q; i++) {
			int action = scan.nextInt();
			int startIndex = scan.nextInt();
			int endIndex = scan.nextInt();
			tHead = AlterList(tHead, startIndex, endIndex, (action == 1) ? true : false);

		}

		System.out.println(Math.abs(difference));
		displayLinkedList(tHead);
	}

	static Node AlterList(Node head, int startIndex, int endIndex, boolean atStart) {
		
		if(atStart && startIndex==1)
			return head;
		
		Node tHead = head;
		int indexCounter = 0;
		Node prevNode = null;

		Node prevStartNode = null;
		Node startNode = null;
		Node endNode = null;

		while (tHead != null) {
			indexCounter++;
			if (indexCounter == startIndex) {
				prevStartNode = prevNode;
				startNode = tHead;
			}
			if (indexCounter == endIndex) {
				endNode = tHead;
			}
			prevNode = tHead;
			tHead = tHead.next;
		}

		if (atStart && prevStartNode != null) {
			prevStartNode.next = endNode.next;
			endNode.next = head;
			head = startNode;
			difference = head.data - prevNode.data;
			return head;
		} else {
			if (prevStartNode == null) {
				head = endNode.next;
			} else {
				prevStartNode.next = endNode.next;
			}
			endNode.next = null;
			prevNode.next = startNode;

			difference = head.data - endNode.data;
			return head;
		}
	}

	static void displayLinkedList(Node head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}

}
