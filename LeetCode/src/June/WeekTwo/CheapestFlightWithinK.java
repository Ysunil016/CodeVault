package June.WeekTwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class CheapestFlightWithinK {

	public static void main(String[] args) {
		int[][] edges = { { 0, 1, 100 }, { 1, 2, 100 }, { 0, 2, 500 } };

		// Making Adj List
		HashMap<String, Integer> cHash = new HashMap<String, Integer>();
		HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<Integer, ArrayList<Integer>>();
		for (int i = 0; i < edges.length; i++) {
			int src = edges[i][0];
			int dest = edges[i][1];
			int cost = edges[i][2];

			if (adjList.containsKey(src)) {
				ArrayList<Integer> adj = adjList.get(src);
				adj.add(dest);
				adjList.put(src, adj);
			} else {
				ArrayList<Integer> adj = new ArrayList<Integer>();
				adj.add(dest);
				adjList.put(src, adj);
			}
			cHash.put(src + "" + dest, cost);
		}
//		findCheapestPath(adjList, cHash, 0, 2, 0, 0, 0);
//		System.out.println(MinPath);
		System.out.println(dP(3, edges, 0, 2, 2));
	}

	static int MinPath = Integer.MAX_VALUE;

	// O(k*N)
	private static int dP(int n, int[][] flights, int src, int dst, int K) {
		int MaxI = 1 << 30;
		int[][] dp = new int[K + 2][n];
		for (int i = 0; i < K + 2; i++) {
			Arrays.fill(dp[i], MaxI);
		}
		dp[0][src] = 0;
		for (int i = 1; i <= K + 1; ++i) {
			dp[i][src] = 0;
			for (int[] x : flights) {
				dp[i][x[1]] = Math.min(dp[i][x[1]], dp[i - 1][x[0]] + x[2]);
			}
		}
		return dp[K + 1][dst] >= MaxI ? -1 : dp[K + 1][dst];
	}

	// O(N)
	static int Optmized(int n, int[][] flights, int src, int dst, int K) {
		final int kInfCost = 1 << 30;
		int[] cost = new int[n];
		Arrays.fill(cost, kInfCost);
		cost[src] = 0;
		for (int i = 0; i <= K; ++i) {
			int[] tmp = cost.clone();
			for (int[] p : flights)
				tmp[p[1]] = Math.min(tmp[p[1]], cost[p[0]] + p[2]);
			cost = tmp;
		}

		return cost[dst] >= kInfCost ? -1 : cost[dst];
	}

	static void findCheapestPath(HashMap<Integer, ArrayList<Integer>> hash, HashMap<String, Integer> cHash, int src,
			int dst, int K, int currentK, int tCost) {

		if (currentK > K) {
			return;
		}

		if (hash.containsKey(src))
			for (int neigh : hash.get(src)) {
				int travelCost = cHash.get(src + "" + neigh);
				if (neigh == dst) {
					MinPath = Math.min(MinPath, tCost + travelCost);
				} else
					findCheapestPath(hash, cHash, neigh, dst, K, currentK + 1, tCost + travelCost);
			}
	}

}
