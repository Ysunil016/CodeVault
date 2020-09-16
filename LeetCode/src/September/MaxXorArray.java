package September;

public class MaxXorArray {


    public static void main(String[] args) {
        System.out.println(findMaximumXOR(new int[]{4,3,5,6,3,2,7}));
    }

    public static int findMaximumXOR(int[] nums) {
        int maxVal = Integer.MIN_VALUE;
        if (nums.length == 0 || nums.length == 1)
            return 0;

        // O(n^2)
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                maxVal = Math.max(maxVal, (nums[i] ^ nums[j]));
            }
        }
        return maxVal;
    }


}
