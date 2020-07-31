package July;

import java.util.HashMap;

public class ClimbingStairs {

	public static void main(String[] args) {
		System.out.println(climbStairs(5));
	}

	public static int climbStairs(int n) {
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		return stair(n, 0, 0, hashMap);
	}

	private static int stair(int n, int pos, int path, HashMap<Integer, Integer> hashMap) {
		if (hashMap.containsKey(pos))
			return hashMap.get(pos);
		if (pos > n)
			return 0;
		if (pos == n)
			return 1;
		int result = stair(n, pos + 1, 1, hashMap) + stair(n, pos + 2, path + 2, hashMap);
		hashMap.putIfAbsent(pos, result);
		return result;
	}

}
