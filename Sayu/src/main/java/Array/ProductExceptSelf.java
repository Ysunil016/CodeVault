package Array;

import util.Helper;

import java.util.Arrays;

/*
Given an integer array nums, return an array answer such that answer[i] is equal
to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit
integer.

You must write an algorithm that runs in O(n) time and without using the
division operation.



Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
*/
public class ProductExceptSelf {
    public static void main(String[] args) {
//        int[] array = new int[]{1,2,3,4};
        int[] array = new int[]{-1, 1, 0, -3, 3};

        int[] result = productExceptSelf(array);
        Helper.print(result);
    }

    static private int[] productExceptSelf(int[] arr) {
        int[] result = new int[arr.length];
        Arrays.fill(result, 1);

        int runningMultiple = 1;
        // Left to Right
        for (int idx = 0; idx < arr.length; idx++) {
            result[idx] = runningMultiple;
            runningMultiple *= arr[idx];
        }

        // Right to Left
        runningMultiple = 1;
        for (int idx = arr.length - 1; idx >= 0; idx--) {
            result[idx] *= runningMultiple;
            runningMultiple *= arr[idx];
        }

        return result;
    }
}
