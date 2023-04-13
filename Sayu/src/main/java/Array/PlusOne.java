package Array;

import java.util.Arrays;

public class PlusOne {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{9, 9, 9, 9, 9, 9, 9}))); // [1, 0, 0, 0, 0, 0, 0, 0]
        System.out.println(Arrays.toString(plusOne(new int[]{8, 9, 9, 9, 9, 9, 9}))); // [9, 0, 0, 0, 0, 0, 0]
        System.out.println(Arrays.toString(plusOne(new int[]{9}))); // [1, 0]
        System.out.println(Arrays.toString(plusOne(new int[]{9, 8, 8, 7}))); // [9, 8, 8, 8]
    }

    private static int[] plusOne(int[] digits) {
        int carry = 1;
        for (int idx = digits.length - 1; idx >= 0; idx--) {
            int currentSum = digits[idx] + carry;
            if (currentSum < 10) carry = 0;
            digits[idx] = currentSum % 10;
        }
        if (carry == 1) {
            int[] newArray = new int[digits.length + 1];
            newArray[0] = 1;
            for (int idx = 0; idx < digits.length; idx++)
                newArray[idx + 1] = digits[idx];
            return newArray;
        }

        return digits;
    }
}
