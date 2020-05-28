package May.WeekFour;

import java.util.ArrayList;
import java.util.Arrays;

public class PossibleBipartition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = { { 1, 2 }, { 1, 3 }, { 2, 4 } };
		System.out.println(possibleBipartition(4, arr));
	}

	public static boolean possibleBipartition(int N, int[][] dislikes) {
		int[] visited = new int[N];
		Arrays.fill(visited, -1);
		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] adjArray = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			adjArray[i] = new ArrayList<Integer>();
		}
		// Populating ADG List
		for (int i = 0; i < dislikes.length; i++) {
			adjArray[dislikes[i][0] - 1].add(dislikes[i][1] - 1);
			adjArray[dislikes[i][1] - 1].add(dislikes[i][0] - 1);
		}
		for (int i = 0; i < N; i++) {
			if (visited[i] == -1 && !dfs(adjArray, visited, i, 0))
				return false;
		}

		return true;
	}
	static boolean dfs(ArrayList<Integer>[] adjArray, int[] visited, int index, int grp) {
		if (visited[index] == -1) {
			visited[index] = grp;
		} else
			return visited[index] == grp;
		for (int X : adjArray[index]) {
			if (!dfs(adjArray, visited, X, 1 - grp))
				return false;
		}
		return true;
	}

}
