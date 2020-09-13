package Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;

public class ClimbingTheLeaderShip {

	public static void main(String[] args) {
		System.out.println(climbingLeaderboard(Arrays.asList(1, 5, 3, 1, 4), Arrays.asList(5, 3, 4, 2)));
	}

	public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
		// Sorted TreeSet
		TreeSet<Integer> treeSet = new TreeSet<>();
		for (int x : ranked) {
			treeSet.add(x);
		}

		NavigableSet<Integer> treereverse = treeSet.descendingSet();
		System.out.println(treereverse);

		List<Integer> resultArray = new ArrayList<>();

		for (int x : player) {
			Iterator<Integer> iterator = treereverse.iterator();
			int rank = 1;
			while (iterator.hasNext() && x < iterator.next()) {
				rank++;
			}
			resultArray.add(rank);
		}

		return resultArray;
	}

}
