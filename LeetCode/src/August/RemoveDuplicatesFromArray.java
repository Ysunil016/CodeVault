package August;

public class RemoveDuplicatesFromArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static List<Integer> findDuplicates(int[] nums) {
		int[] fra = new int[nums.length + 1];
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int n : nums)
			fra[n]++;
		for (int i = 0; i < fra.length; i++) {
			if (fra[i] == 2)
				result.add(i);
		}
		return result;
	}

}
