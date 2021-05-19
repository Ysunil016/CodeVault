package July;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AllPathFromSource {

	public static void main(String[] args) {
		int[][] graph = { { 1, 2 }, { 3 }, { 3 }, {} };

		for (List<Integer> r : allPathsSourceTarget(graph)) {
			System.out.println(r);
		}
	}

	static List<List<Integer>> resultList = new LinkedList<>();

	public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		List<Integer> ar = new ArrayList<>();
		dfsSearch(graph, 0, graph.length - 1, ar);
		return resultList;
	}

	private static void dfsSearch(int[][] graph, int currentIndex, int finalIndex, List<Integer> currentList) {
		if (currentIndex == finalIndex) {
			@SuppressWarnings("unchecked")
			ArrayList<Integer> foundPath = (ArrayList<Integer>) ((ArrayList<Integer>) currentList).clone();
			resultList.add(foundPath);
			return;
		}
		if (currentIndex == 0) {
			currentList.add(0);
		}

		for (int num : graph[currentIndex]) {
			currentList.add(num);
			dfsSearch(graph, num, finalIndex, currentList);
			currentList.remove(currentList.size() - 1);
		}
	}

}
