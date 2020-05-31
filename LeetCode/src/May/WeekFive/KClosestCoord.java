package May.WeekFive;

import java.util.ArrayList;
import java.util.Collections;

public class KClosestCoord {

	public static void main(String[] args) {
		int[][] arr = new int[][] { { 3, 3 }, { 5, -1 }, { -2, 4 } };
		for (int[] a : kClosest(arr, 1)) {
			for (int x : a)
				System.out.print(" " + x);
		}
	}

	public static int[][] kClosest(int[][] points, int K) {
		class Node implements Comparable<Node> {
			int distance;
			int[] coord = new int[2];
			Node(int[] coord) {
				this.distance = coord[0] * coord[0] + coord[1] * coord[1];
				this.coord = coord;
			}
			@Override
			public int compareTo(Node t) {
				return (this.distance > t.distance) ? 1 : (this.distance < t.distance) ? -1 : 0;
			}
		}
		ArrayList<Node> store = new ArrayList<Node>();
		for (int i = 0; i < points.length; i++) {
			store.add(new Node(points[i]));
		}
		// Sorting Object
		Collections.sort(store);
		
		int[][] result = new int[K][2];
		int counter = 0;
		for (Node x : store) {
			result[counter] = (x.coord);
			counter++;
			if (counter >= K) {
				break;
			}
		}

		return result;
	}

}
