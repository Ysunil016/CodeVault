package Graph;

import java.util.LinkedList;
import java.util.Stack;

public class DFS {

	static class gNode {
		int data;
		boolean visited = false;

		public gNode(int data) {
			this.data = data;
		}

		public boolean isVisited() {
			return visited;
		}

		public void setVisited(boolean visited) {
			this.visited = visited;
		}

	}

	public static void main(String[] args) {

		int[][] adjMatrix = { { 0, 1, 0, 1, 0, 0, 0 }, { 1, 0, 1, 1, 0, 1, 1 }, { 0, 1, 0, 1, 1, 1, 0 },
				{ 1, 1, 1, 0, 1, 0, 0 }, { 0, 0, 1, 1, 0, 0, 1 }, { 0, 1, 1, 0, 0, 0, 0 }, { 0, 1, 0, 0, 1, 0, 0 } };
		dfsTraversal(adjMatrix);
	}

	public static void dfsTraversal(int[][] adjMatrix) {

		int numOfVertices = adjMatrix.length;

		gNode[] allNodeObjects = new gNode[numOfVertices];
		for (int i = 0; i < numOfVertices; i++) {
			gNode newNode = new gNode(i);
			allNodeObjects[i] = newNode;
		}

		DFSTraversal(allNodeObjects[0], allNodeObjects, adjMatrix);

	}

	public static void DFSTraversal(gNode node, gNode[] allNodes, int[][] adjMatrix) {
		node.setVisited(true);
//		System.out.print(node.data + " ");
		for (int i = 0; i < adjMatrix.length; i++) {
			if (adjMatrix[node.data][i] == 1 && !allNodes[i].visited) {
				System.out.println("Node Traversing for "+allNodes[i].data);
				DFSTraversal(allNodes[i], allNodes, adjMatrix);
			}
		}

	}

}
