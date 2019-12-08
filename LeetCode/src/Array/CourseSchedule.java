package Array;

import java.util.LinkedList;

public class CourseSchedule {

	public static void main(String[] args) {
		int[][] preRequisites = { { 1, 0 } };

		if (canFinish(2, preRequisites))
			System.out.println("Graph Doesn't have Cycle in It");
		else
			System.out.println("Graph has Any Cycle in It");
	}

	// Overall Sense of Making this Algo is to Find if a Graph has a Cycle in It.

	public static boolean canFinish(int numCourse, int[][] prerequisites) {

		// Managing Primary Exceptional Basic Cases
		int len = prerequisites.length;
		if (len == 0 || prerequisites[0].length == 0 || numCourse == 0)
			return true;

		// Counter for Prerequisites
		int[] pathCounter = new int[numCourse];
		for (int i = 0; i < len; i++) {
			pathCounter[prerequisites[i][0]]++;
		}

		// Storing All Courses having No Prerequisites
		LinkedList<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < numCourse; i++) {
			if (pathCounter[i] == 0)
				queue.add(i);
		}

		int numNoPre = queue.size();

		// Making BFS Attempt for Node's Running Feasibility
		while (!queue.isEmpty()) {
			int top = queue.remove();
			for (int i = 0; i < len; i++) {
				if (prerequisites[i][1] == top) {
					pathCounter[prerequisites[i][0]]--;
					if (pathCounter[prerequisites[i][0]] == 0) {
						numNoPre++;
						queue.add(prerequisites[i][0]);
					}
				}
			}
		}

		return numNoPre == numCourse;
	}

}
