package August;

public class MinimumCostTicket {

	public static void main(String[] args) {
		int[] days = {};
		int[] costs = {};
		System.out.println(mincostTickets(days, costs));
	}

	public static int mincostTickets(int[] days, int[] costs) {
		// Dynamic Programming
		int[] dp = new int[days.length];
		int result = recursion(days, costs, 0, dp);
		return result;
	}

	private static int recursion(int[] days, int[] costs, int index, int[] dp) {
		if (index >= days.length)
			return 0;
		if (dp[index] > 0)
			return dp[index];

		int basicOne = costs[0] + recursion(days, costs, index + 1, dp);

		int k = index;
		for (; k < days.length; k++) {
			if (days[k] >= days[index] + 7) {
				break;
			}
		}
		int basicTwo = costs[1] + recursion(days, costs, k, dp);
		for (; k < days.length; k++) {
			if (days[k] >= days[index] + 30) {
				break;
			}
		}
		int basicThree = costs[2] + recursion(days, costs, k, dp);

		int result = Math.min(basicOne, Math.min(basicTwo, basicThree));
		dp[index] = result;
		return result;
	}

}
