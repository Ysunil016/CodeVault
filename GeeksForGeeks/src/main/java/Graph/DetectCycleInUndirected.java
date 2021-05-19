package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class DetectCycleInUndirected {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		int nov = sc.nextInt();
		int edg = sc.nextInt();
		for (int i = 0; i < nov; i++)
			list.add(i, new ArrayList<Integer>());

		for (int i = 1; i <= edg; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			list.get(u).add(v);
			list.get(v).add(u);
		}
		boolean vis[] = new boolean[nov];
		for (int i = 0; i < nov; i++)
			vis[i] = false;
		System.out.println(isCyclic(list, nov));

	}

	static boolean isCyclic(ArrayList<ArrayList<Integer>> list, int V) {
		boolean[] vix = new boolean[V];
//		for (int i = 0; i < V; i++) {
//			vix[i] = false;
//		}

		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.add(0);
		while (!queue.isEmpty()) {
			int currentNode = queue.poll();
			if (vix[currentNode] == false) {
				vix[currentNode] = true;
				ArrayList<Integer> adjNode = list.get(currentNode);
				for (int i = 0; i < adjNode.size(); i++) {
					if (vix[adjNode.get(i)] == false) {
						queue.add(adjNode.get(i));
					} else {
						return true;
					}
				}
			}
		}
		return false;
	}
}
