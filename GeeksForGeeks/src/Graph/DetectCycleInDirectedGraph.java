package Graph;

import java.util.ArrayList;
import java.util.Arrays;

public class DetectCycleInDirectedGraph {

	public static void main(String[] args) {

		ArrayList<ArrayList<Integer>> graphM = new ArrayList<ArrayList<Integer>>();
		graphM.add(new ArrayList<Integer>(Arrays.asList(1)));
		graphM.add(new ArrayList<Integer>(Arrays.asList(2)));
		graphM.add(new ArrayList<Integer>(Arrays.asList(3)));
		graphM.add(new ArrayList<Integer>());

		boolean result = true;

		for (int i = 0; i <= graphM.size(); i++) {
			result = result && isCyclic(i, graphM);
		}
		System.out.println(result);
	}

	static boolean isCyclic(int start, ArrayList<ArrayList<Integer>> list) {
		boolean hasCycle = true;
		ArrayList<Integer> zList = list.get(start);
		System.out.println(zList);
		for (int i = 0; i < zList.size(); i++) {
			if (start == zList.get(i))
				return true;

			hasCycle = isCyclic(zList.get(i), list);
		}

		return hasCycle;
	}
}
