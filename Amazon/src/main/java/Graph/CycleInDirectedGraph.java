package Graph;

import java.util.ArrayList;
import java.util.Scanner;

public class CycleInDirectedGraph {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
//		int testCase = scan.nextInt();
		int V = scan.nextInt();
		int pairs = scan.nextInt();

		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < V; i++) {
			graph.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < pairs; i++) {
			int x = scan.nextInt();
			int y = scan.nextInt();
			ArrayList<Integer> arr = graph.get(x);
			arr.add(y);
			graph.add(arr);
		}

		System.out.println(isCyclic(graph, V));

	}

	static boolean isCyclic(ArrayList<ArrayList<Integer>> list, int V) {
		// Will be Holding the Array, Weather Node is Visited or Not
		boolean[] isVisited = new boolean[V];
		// Will be Holding the Array, for the Recursion Stack Holding
		boolean[] stack = new boolean[V];

		for (int i = 0; i < V; i++) {
			if (makeCycle(list, isVisited, i, stack))
				return true;
		}
		return false;

	}

	static boolean makeCycle(ArrayList<ArrayList<Integer>> list, boolean[] visited, int node, boolean[] stack) {

		// Checking if the Node is already Visited in the Current Stack
		if (stack[node])
			return true;

		// If the Node is already Visited, that Means Path is Clear without Loop
		if (visited[node])
			return false;

		ArrayList<Integer> neighbours = list.get(node);

		// Setting Node and Stack Visited
		visited[node] = true;
		stack[node] = true;

		for (int x : neighbours) {
			if (makeCycle(list, visited, x, stack))
				return true;
		}
		// Making Node Available for Next Recursion
		stack[node] = false;
		return false;
	}

}
