package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class DFS {
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
		dfs(0, list, vis);
		System.out.println();

	}

	static void dfs(int src, ArrayList<ArrayList<Integer>> list, boolean vis[]) {
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.add(src);

		while (!queue.isEmpty()) {
			int currentNode = queue.poll();
			if (vis[currentNode] == false) {
				System.out.print(currentNode + " ");
				vis[currentNode] = true;
				ArrayList<Integer> adjNode = list.get(currentNode);
				for (int i = 0; i < adjNode.size(); i++) {
					if (vis[adjNode.get(i)] == false)
						queue.add(adjNode.get(i));
				}
			}
		}

	}

}
