package Array;

public class ServiceLane {

	public static void main(String[] args) {
		System.out.println(serviceLane(30, new int[][] {}, new int[] {}));
	}

	static int[] serviceLane(int n, int[][] cases, int[] widths) {
		int[] result = new int[cases.length];
		int counter = 0;
		for (int[] x : cases) {
			int M = x[0];
			int N = x[1];

			System.out.println(x[0] + " and " + x[1]);

			int minCount = Integer.MAX_VALUE;
			for (int i = M; i <= N; i++) {
				minCount = Math.min(minCount, widths[i]);
			}
			result[counter] = minCount;
			counter++;
		}

		return result;
	}

}
