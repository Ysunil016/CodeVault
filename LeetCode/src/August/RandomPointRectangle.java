package August;

import java.util.ArrayList;
import java.util.Random;

public class RandomPointRectangle {

	public static void main(String[] args) {
		Solution sol = new Solution(new int[][] { { 1, 1, 5, 5 }, { -2, -2, -1, -1 } });
		int[] V = sol.pick();
		System.out.println(V[0]);
		System.out.println(V[1]);
	}

}

class Solution {
	int[][] rects;
	ArrayList<Integer> rect_cum_count;
	int num_pts = 0;

	public Solution(int[][] rects) {
		this.rects = rects;
		this.rect_cum_count = new ArrayList<>();

		for (int[] rect : rects) {
			num_pts += (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1);
			rect_cum_count.add(num_pts);
		}
	}

	public int[] pick() {

		int pt_idx = new Random().nextInt(num_pts);
		int l = 0, r = rects.length - 1;
		while (l < r) {
			int mid = l + (r - l) / 2;
			if (rect_cum_count.get(mid) <= pt_idx)
				l = mid + 1;
			else
				r = mid;
		}
		// l = rectangle index
		int[] rect = rects[l];
		int x_pts = rect[2] - rect[0] + 1;
		int y_pts = rect[3] - rect[1] + 1;
		int pts_in_rect = x_pts * y_pts;
		int pt_start = rect_cum_count.get(l) - pts_in_rect;
		int offset = pt_idx - pt_start;
		return new int[] { rect[0] + offset % x_pts, rect[1] + offset / x_pts };

	}
}

// 32/35
class Solution2 {
	int[][] rectangleSolution;
	int currentIndex = 0;

	public Solution2(int[][] rects) {
		rectangleSolution = rects;
	}

	public int[] pick() {
		currentIndex = currentIndex % rectangleSolution.length;
		return new int[] { pickRandomX(), pickRandomY() };
	}

	private int pickRandomX() {
		return new Random().nextInt((rectangleSolution[currentIndex][2] - rectangleSolution[currentIndex][0]) + 1)
				+ rectangleSolution[currentIndex][0];
	}

	private int pickRandomY() {
		return new Random().nextInt((rectangleSolution[currentIndex][3] - rectangleSolution[currentIndex][1]) + 1)
				+ rectangleSolution[currentIndex][1];
	}
}
