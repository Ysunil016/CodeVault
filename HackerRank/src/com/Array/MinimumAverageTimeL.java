package com.Array;

import java.util.List;

public class MinimumAverageTimeL {

	static class Node {
		long arrivalTime;
		long prepTime;
		Node next;

		public Node(long arrivalTime, long prepTime) {
			this.arrivalTime = arrivalTime;
			this.prepTime = prepTime;
			this.next = null;
		}
	}

	public static void main(String[] args) {
		int[][] pizzaOrder = { { 961148050, 385599125 }, { 951133776, 376367013 }, { 283280121, 782916802 },
				{ 317664929, 898415172 }, { 980913391, 847912645 } };
		
		Node head = null;
		for (int i = 0; i < pizzaOrder.length; i++) {
			Node newNode = new Node(pizzaOrder[i][0], pizzaOrder[i][1]);
			head = addingNewNodeToLinkedList(head, newNode);
		}
		printLinkedList(head);
		System.out.println();
		long result = findMinAverageTime(head) / pizzaOrder.length;
		System.out.println(result);
	}

	public static long findMinAverageTime(Node head) {
		Node bingoNode = null;
		Node newLinkedList = head;
		long prepCummulativeTime = 0;
		long waitingTime = 0;
		long totalWaitingTime = 0;

		bingoNode = findAppropriateOrder(newLinkedList, null, 0);
		System.out.println(bingoNode.arrivalTime);

		while (newLinkedList != null) {

			long arrivalTime = bingoNode.arrivalTime;
			long prepTime = bingoNode.prepTime;
			prepCummulativeTime += prepTime;
			waitingTime = prepCummulativeTime - arrivalTime;

			totalWaitingTime += waitingTime;

			newLinkedList = removeNode(newLinkedList, bingoNode);
			bingoNode = findAppropriateOrder(newLinkedList, bingoNode, prepCummulativeTime);

			if (bingoNode != null)
				System.out.println(bingoNode.arrivalTime);
			System.out.println();
		}
		return totalWaitingTime;
	}

	public static Node findAppropriateOrder(Node lList, Node lastNode, long prepCummulativeTime) {
		Node selectedNode = lList;

		if (selectedNode == null)
			return null;

		if (lastNode == null) {
			Node lowestArrival = lList;
			while (lList != null) {
				if (lList.arrivalTime < lowestArrival.arrivalTime)
					lowestArrival = lList;
				lList = lList.next;
			}
//			System.out.println("This is Selected " + lowestArrival.arrivalTime);

			return lowestArrival;
		} else {

			long latestSelected = Integer.MAX_VALUE;
			while (lList != null) {
				if (lList.arrivalTime < prepCummulativeTime && lList.prepTime < latestSelected) {
					selectedNode = lList;
					latestSelected = lList.prepTime;
				}
				lList = lList.next;
			}
		}

		return selectedNode;
	}

	public static Node removeNode(Node head, Node thisNode) {
		Node currentNode = head;
		Node preNode = null;

		if (currentNode == null) {
			return null;
		}

		while (currentNode != null) {
			if (currentNode == thisNode) {
				if (preNode != null)
					preNode.next = currentNode.next;
				else
					head = currentNode.next;
			}
			preNode = currentNode;
			currentNode = currentNode.next;
		}

		return head;
	}

	public static Node addingNewNodeToLinkedList(Node head, Node node) {
		Node currentNode = head;
		if (currentNode == null) {
			return node;
		}
		while (currentNode.next != null) {
			currentNode = currentNode.next;
		}
		currentNode.next = node;

		return head;
	}

	public static void printLinkedList(Node head) {
		Node currentNode = head;
		while (currentNode != null) {
			System.out.println(currentNode.arrivalTime + " Takes " + currentNode.prepTime);
			currentNode = currentNode.next;
		}
	}

}
