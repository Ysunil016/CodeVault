package Array;

import java.util.*;

public class ThreeSum {
    private final int[] nums;

    public ThreeSum(int[] nums) {
        this.nums = nums;
    }

    public List<List<Integer>> play() {
        Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet<>();

        for (int idx = 0; idx < nums.length; idx++) {
            int pHolder = idx;
            int start = idx + 1;
            int end = nums.length - 1;

            while (start < end) {
                int totalSum = nums[pHolder] + nums[start] + nums[end];
                if (totalSum == 0) {
                    res.add(new ArrayList<>(List.of(nums[pHolder], nums[start], nums[end])));
                    start++;
                } else if (totalSum < 0) start++;
                else end--;
            }
        }
        return new ArrayList<>(res);
    }

}
