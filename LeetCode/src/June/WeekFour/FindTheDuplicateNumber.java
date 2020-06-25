package June.WeekFour;

public class FindTheDuplicateNumber {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 2, 5 };
		System.out.println(findDuplicate(arr));
	}

	static public int findDuplicate(int[] nums) {
		int slow = nums[0];
		int fast = nums[0];
		slow = nums[slow];
		fast = nums[nums[fast]];
		while (slow != fast) {
			slow = nums[slow];
			fast = nums[nums[fast]];
		}
		int x = nums[0];
		int y = slow;
		while (x != y) {
			x = nums[x];
			y = nums[y];
		}
		return x;
	}

}
