package Graph;

import java.util.ArrayList;
import java.util.Scanner;

public class BFS {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		//Graph using Adjency List
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
		dfs(0, list, vis);
		System.out.println();

	}

	static void dfs(int src, ArrayList<ArrayList<Integer>> list, boolean vis[]) {
		if (vis[src] == false) {
			System.out.println(src);
			vis[src] = true;
			ArrayList<Integer> allNode = list.get(src);
			for (int i = 0; i < allNode.size(); i++) {
				if (vis[allNode.get(i)] == false) {
					dfs(allNode.get(i), list, vis);
				}
			}
		}
	}

}
