package May.WorkOne;

import java.util.Arrays;
import java.util.HashMap;

public class MajorityElement {

	public static void main(String[] args) {
		int[] arr = {2,3,4,2,2,2,2,};
		System.out.println(majorityElement_(arr));
	}

	// O(n)
	public static int majorityElement(int[] nums) {
		int majorOrder = nums.length/2;
		
		if(majorOrder==0)
			return nums[0];
		
		HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
		for(int i=0;i<nums.length;i++) {
			if(hash.containsKey(nums[i])) {
				int hashContain = hash.get(nums[i]);
				hash.put(nums[i], hashContain+1);
				if(hashContain+1>majorOrder) {
					return nums[i];
				}
			}else {
				hash.put(nums[i], 1);
			}
		}
		return -1;
	}

	
	// O(nlogn)
	public static int majorityElement_(int[] nums) {
		Arrays.sort(nums);
		return nums[nums.length/2];
	}
	
	
	
}
