package Ignite;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class DFS_Graph {

	public static void main(String[] args) {

		HashMap<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
		List<Integer> one_L = Arrays.asList(1, 2, 3);
		graph.put(0, one_L);
		List<Integer> two_L = Arrays.asList(0, 2);
		graph.put(1, two_L);
		List<Integer> three_L = Arrays.asList(0, 1);
		graph.put(2, three_L);
		List<Integer> four_L = Arrays.asList(0);
		graph.put(3, four_L);
//		List<Integer> five_L = Arrays.asList(2, 0);
//		graph.put(4, five_L);

		boolean[] vis = new boolean[4];

		getDFS(0, graph, vis);
	}

	static void getDFS(int source, HashMap<Integer, List<Integer>> graph, boolean vis[]) {
		// Make Source Node Visited
		vis[source] = true;

		// Traversing Graph Here
		System.out.println(source);

		// Traverse All the ArrayList
		List<Integer> neighbours = graph.get(source);
		// Iterating for Each Neighbour Node
		for (int i = 0; i < neighbours.size(); i++) {
			// If Node is Still Not Visited
			if (!vis[neighbours.get(i)]) {
				getDFS(neighbours.get(i), graph, vis);
			}
		}
		//
	}

}
