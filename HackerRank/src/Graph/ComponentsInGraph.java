package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ComponentsInGraph {

	static Scanner scan = new Scanner(System.in);

	static int tempElementCount = 0;
	static int maxComponent = Integer.MIN_VALUE;
	static int minComponent = Integer.MAX_VALUE;

	public static void main(String[] args) {

		int amount = scan.nextInt();
		int[][] arr = new int[amount][2];
		for (int i = 0; i < amount; i++) {
			arr[i][0] = scan.nextInt();
			arr[i][1] = scan.nextInt();
		}

//		int[][] arr = { { 1, 17 }, { 5, 13 }, { 7, 12 }, { 5, 17 }, { 5, 12 }, { 2, 17 }, { 1, 18 }, { 8, 13 },
//				{ 2, 15 }, { 2, 20 } };
		componentsInGraph(arr);
		System.out.println(minComponent);
		System.out.println(maxComponent);
	}

	private static void componentsInGraph(int[][] arr) {
		HashMap<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();
		for (int i = 0; i < arr.length; i++) {
			ArrayList<Integer> neighboursLeft = graph.get(arr[i][0]);
			ArrayList<Integer> neighboursRight = graph.get(arr[i][1]);

			if (neighboursLeft == null) {
				neighboursLeft = new ArrayList<Integer>();
			}
			neighboursLeft.add(arr[i][1]);
			graph.put(arr[i][0], neighboursLeft);

			if (neighboursRight == null) {
				neighboursRight = new ArrayList<Integer>();
			}
			neighboursRight.add(arr[i][0]);
			graph.put(arr[i][1], neighboursRight);
		}
		boolean[] isVisited = new boolean[arr.length * 2 + 1];

		for (int i = 0; i < arr.length; i++)
//		for (int key : graph.keySet())
			findMaxMinComponents(graph, arr[i][0], isVisited);

	}

	private static void findMaxMinComponents(HashMap<Integer, ArrayList<Integer>> graph, int source,
			boolean[] isVisited) {

		tempElementCount = 0;
		traverseGraph(graph, source, isVisited);
		if (tempElementCount != 0) {
			maxComponent = Math.max(maxComponent, tempElementCount);
			minComponent = Math.min(minComponent, tempElementCount);
		}
	}

	static void traverseGraph(HashMap<Integer, ArrayList<Integer>> graph, int cNode, boolean[] isVisited) {
		if (isVisited[cNode])
			return;

		isVisited[cNode] = true;

		tempElementCount++;

		ArrayList<Integer> neighbour = graph.get(cNode);
		for (int N : neighbour) {
			if (!isVisited[N]) {
				traverseGraph(graph, N, isVisited);
			}
		}
	}

}
