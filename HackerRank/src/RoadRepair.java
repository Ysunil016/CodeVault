import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class RoadRepair {

	public static void main(String[] args) {
		List<Integer> crew_id = new LinkedList<>(Arrays.asList(5, 3, 1, 4, 6));
		List<Integer> job_id = new LinkedList<>(Arrays.asList(9, 8, 3, 15, 1));
		System.out.println(getMinCost(crew_id, job_id));
	}

	public static long getMinCost(List<Integer> crew_id, List<Integer> job_id) {
		long minCost = 0;

		List<HashMap<Integer, Integer>> sortedKey = new ArrayList<>();

		int lenCrew = crew_id.size();
		while (lenCrew-- != 0) {
			// Calculating sortedKey
			for (int i = 0; i < crew_id.size(); i++) {
				int minOfColumn = Integer.MAX_VALUE;
				int indexOfMin = 0;
				for (int j = 0; j < job_id.size(); j++) {
					int foundM = Math.abs(crew_id.get(i) - job_id.get(j));
					if (foundM < minOfColumn) {
						minOfColumn = foundM;
						indexOfMin = j;
					}
				}
				System.out.print(crew_id.get(i) + " at " + job_id.get(indexOfMin));
				System.out.println();
			}
			System.out.println();

		}

		return minCost;
	}
}
