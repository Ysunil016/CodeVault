package July;

import java.util.Collections;
import java.util.LinkedList;

public class CourseScheduleII {

	public static void main(String[] args) {
		int[][] arr = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
		for (int X : findOrder(4, arr)) {
			System.out.print(X + " ");
		}
	}

	public static int[] findOrder(int numCourses, int[][] prerequisites) {
		@SuppressWarnings("unchecked")
		LinkedList<Integer>[] adj = new LinkedList[numCourses];
		for (int i = 0; i < numCourses; i++) {
			adj[i] = new LinkedList<Integer>();
		}
		for (int[] courses : prerequisites) {
			adj[courses[1]].add(courses[0]);
		}

		LinkedList<Integer> stack = new LinkedList<>();
		int[] visited = new int[numCourses];

		for (int i = 0; i < numCourses; i++) {
			if (visited[i] == 0 && dfs(i, adj, stack, visited)) {
				return new int[0];
			}
		}
		Collections.reverse(stack);

		int[] result = new int[stack.size()];
		int i = 0;
		for (int stk : stack) {
			result[i++] = stk;
		}
		return result;
	}

	private static boolean dfs(int index, LinkedList<Integer>[] adj, LinkedList<Integer> stackStore, int[] isVisited) {
		isVisited[index] = 1;

		for (int neighbours : adj[index]) {
			if (isVisited[neighbours] == 1)
				return true;
			if (isVisited[neighbours] == 0 && dfs(neighbours, adj, stackStore, isVisited))
				return true;
		}
		isVisited[index] = 2;
		stackStore.add(index);
		return false;
	}

}
