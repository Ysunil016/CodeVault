package _60Days.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

	public static void main(String[] args) {
		int[][] arr = { { 1, 2 }, { 2, 5 }, { 3 }, { 4 }, { 5 }, { 6 }, {} };
		for (int i = 0; i < arr.length; i++) {
			boolean[] isVisited = new boolean[arr.length];
			BFSTraverse(arr, i, isVisited);
		}
	}

	private static void BFSTraverse(int[][] adjList, int index, boolean[] isVisited) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(index);
		System.out.println();
		while (!queue.isEmpty()) {
			index = queue.poll();
			if (!isVisited[index]) {
				isVisited[index] = true;
				int[] neighbour = adjList[index];
				System.out.print(index + " ");
				for (int nums : neighbour) {
					queue.add(nums);
				}
			}
		}

	}

}
