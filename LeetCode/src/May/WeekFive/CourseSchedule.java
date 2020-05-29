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

/*

Course Schedule
Solution
There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.
 

*/
