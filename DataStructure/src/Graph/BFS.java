package Graph;

import java.util.LinkedList;

public class BFS {

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
		bfsTraversal(adjMatrix);
	}

	public static void bfsTraversal(int[][] adjMatrix) {

		int numOfVertices = adjMatrix.length;

		LinkedList<gNode> queue = new LinkedList<gNode>();

		gNode[] allNodeObjects = new gNode[numOfVertices];
		for (int i = 0; i < numOfVertices; i++) {
			gNode newNode = new gNode(i);
			allNodeObjects[i] = newNode;
		}
		queue.add(allNodeObjects[0]);
		allNodeObjects[0].setVisited(true);

		while (!queue.isEmpty()) {
			// Finding all the Adjacent Nodes of Element
			gNode top = queue.remove();
			System.out.print("->" + top.data + " ");
			for (int i = 0; i < numOfVertices; i++) {
				if (adjMatrix[top.data][i] == 1) {
					if (!allNodeObjects[i].visited) {
						queue.add(allNodeObjects[i]);
						allNodeObjects[i].visited = true;
					}
				}
			}
		}

	}

}
