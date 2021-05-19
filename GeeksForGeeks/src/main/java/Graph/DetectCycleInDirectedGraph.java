package Graph;

import java.util.ArrayList;
import java.util.HashMap;

public class DetectCycleInDirectedGraph {

	static class Node {
		int data;
		boolean isVisited = false;

		public void setVisited(boolean value) {
			this.isVisited = value;
		}

		public boolean isVisited() {
			return isVisited;
		}

		Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {

		HashMap<Node, ArrayList<Node>> graphStore = new HashMap<Node, ArrayList<Node>>();
		Node _Node_1 = new Node(1);
		Node _Node_2 = new Node(2);
		Node _Node_3 = new Node(3);
		Node _Node_4 = new Node(4);
		Node _Node_5 = new Node(5);
		Node _Node_6 = new Node(6);
		Node _Node_7 = new Node(7);
		Node _Node_8 = new Node(8);
		Node _Node_9 = new Node(9);
		Node _Node_10 = new Node(10);

		ArrayList<Node> neighbour_1 = new ArrayList<Node>();
		neighbour_1.add(_Node_2);
		ArrayList<Node> neighbour_2 = new ArrayList<Node>();
		neighbour_2.add(_Node_3);
		ArrayList<Node> neighbour_3 = new ArrayList<Node>();
		neighbour_3.add(_Node_4);
		neighbour_3.add(_Node_8);
		ArrayList<Node> neighbour_4 = new ArrayList<Node>();
		neighbour_4.add(_Node_5);
		ArrayList<Node> neighbour_5 = new ArrayList<Node>();
		neighbour_5.add(_Node_6);
		ArrayList<Node> neighbour_6 = new ArrayList<Node>();
		neighbour_6.add(_Node_7);
		ArrayList<Node> neighbour_7 = new ArrayList<Node>();
		neighbour_7.add(_Node_8);
		ArrayList<Node> neighbour_8 = new ArrayList<Node>();
//		neighbour_8.add(_Node_9);
//		neighbour_8.add(_Node_10);
//		ArrayList<Node> neighbour_9 = new ArrayList<Node>();
//		neighbour_9.add(_Node_10);
//		ArrayList<Node> neighbour_10 = new ArrayList<Node>();

		graphStore.put(_Node_1, neighbour_1);
		graphStore.put(_Node_2, neighbour_2);
		graphStore.put(_Node_3, neighbour_3);
		graphStore.put(_Node_4, neighbour_4);
		graphStore.put(_Node_5, neighbour_5);
		graphStore.put(_Node_6, neighbour_6);
		graphStore.put(_Node_7, neighbour_7);
		graphStore.put(_Node_8, neighbour_8);
//		graphStore.put(9, neighbour_9);
//		graphStore.put(10, neighbour_10);

		int[] visitedNodes = new int[11];
		for (Node source : graphStore.keySet())
			System.out.println(hasCycle(graphStore, source, visitedNodes));

	}

	static boolean hasCycle(HashMap<Node, ArrayList<Node>> graph, Node source, int[] visitedNode) {
		boolean hasloop = false;

		System.out.println("************* " + source.data);
		for (int i : visitedNode)
			System.out.print(i + " ");
		System.out.println("*************");

		ArrayList<Node> allNeighbours = graph.get(source);
		for (Node node : allNeighbours)
			hasloop = hasCycle(graph, node, visitedNode) || hasloop;

		if (visitedNode[source.data] == 1)
			hasloop = true;
		else
			visitedNode[source.data] = 1;

		return hasloop;
	}
}
