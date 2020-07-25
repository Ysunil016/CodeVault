package _60Days.Graph;

public class DFS {

	public static void main(String[] args) {
		int[][] arr = { { 1, 2 }, { 2, 5 }, { 3 }, { 4 }, { 5 }, { 6 }, {} };
		for (int i = 0; i < arr.length; i++) {
			System.out.println();
			boolean[] isVisited = new boolean[arr.length];
			DFSTraverse(arr, i, isVisited);
		}
	}

	private static void DFSTraverse(int[][] adjList, int index, boolean[] isVisited) {
		if (isVisited[index])
			return;

		System.out.print(index + " ");

		for (int neigh : adjList[index]) {
			isVisited[index] = true;
			DFSTraverse(adjList, neigh, isVisited);
		}
	}

}
