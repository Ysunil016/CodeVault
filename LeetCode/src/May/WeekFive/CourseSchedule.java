package May.WeekFive;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {

	public static void main(String[] args) {

		int[][] arr = new int[][] { { 0, 1 }, { 0, 2 }, { 1, 2 } };
		System.out.println(canFinish(3, arr));
	}

	public static boolean canFinish(int numCourses, int[][] prerequisites) {

		class Node {
			int val;
			int inBound = 0;
			int outBound = 0;
			ArrayList<Integer> neighbour = new ArrayList<Integer>();

			public Node(int val) {
				this.val = val;
			}

			public Node decrementInBound() {
				this.inBound--;
				return this;
			}

			public Node incrementInBound() {
				this.inBound++;
				return this;
			}

			public Node incrementOutBound() {
				this.outBound++;
				return this;
			}

			public void addNeighbour(int val) {
				ArrayList<Integer> neighbour = this.neighbour;
				neighbour.add(val);
				this.neighbour = neighbour;
			}
		}

		// Making Graph First
		Node[] nodeStore = new Node[numCourses];

		for (int i = 0; i < numCourses; i++) {
			nodeStore[i] = new Node(i);
		}

		for (int i = 0; i < prerequisites.length; i++) {
			nodeStore[prerequisites[i][0]].incrementOutBound().addNeighbour(prerequisites[i][1]);
			nodeStore[prerequisites[i][1]].incrementInBound();
		}

		Queue<Node> queue = new LinkedList<Node>();
		int crossCount = 0;

		for (int i = 0; i < numCourses; i++) {
			if (nodeStore[i].inBound == 0) {
				queue.add(nodeStore[i]);
				crossCount++;
			}
		}

		while (!queue.isEmpty()) {
			Node current = queue.poll();
			for (int x : current.neighbour) {
				nodeStore[x].decrementInBound();
				if (nodeStore[x].inBound == 0) {
					queue.add(nodeStore[x]);
					crossCount++;
				}
			}
		}
		return (crossCount == numCourses) ? true : false;
	}
}