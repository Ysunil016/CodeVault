package June.WeekFour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class ReconstructItinerary {

	public static void main(String[] args) {

		List<List<String>> al = new ArrayList<List<String>>();
		al.add(Arrays.asList("MUC", "LHR"));
		al.add(Arrays.asList("JFK", "MUC"));
		al.add(Arrays.asList("SFO", "SJC"));
		al.add(Arrays.asList("LHR", "SFO"));

//		al.add(Arrays.asList("JFK", "SFO"));
//		al.add(Arrays.asList("JFK", "ATL"));
//		al.add(Arrays.asList("SFO", "ATL"));
//		al.add(Arrays.asList("ATL", "JFK"));
//		al.add(Arrays.asList("ATL", "SFO"));

		for (String x : findItinerary(al)) {
			System.out.println(x);
		}
		;
	}

	public static List<String> findItinerary(List<List<String>> tickets) {
		List<String> fResult = new ArrayList<>();
		HashMap<String, PriorityQueue<String>> list = new HashMap<>();

		for (int i = 0; i < tickets.size(); i++) {
			if (!list.containsKey(tickets.get(i).get(0))) {
				PriorityQueue<String> ad = new PriorityQueue<>();
				ad.add(tickets.get(i).get(1));
				list.put(tickets.get(i).get(0), ad);
			} else {
				list.get(tickets.get(i).get(0)).add(tickets.get(i).get(1));
			}
		}
//		fResult.add("JFK");
		dfs(list, "JFK", fResult);
		return fResult;
	};

	private static void dfs(HashMap<String, PriorityQueue<String>> list, String currentIndex, List<String> str) {
		PriorityQueue<String> arivals = list.get(currentIndex);
		while (arivals != null && !arivals.isEmpty()) {
			String X = arivals.poll();
			dfs(list, X, str);
		}
		str.add(0, currentIndex);
	}

}
