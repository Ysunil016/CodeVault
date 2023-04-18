package Array;

public class PlusOne {
    final int[] digits;
    public PlusOne(int[] digits) {
        this.digits = digits;
    }

    int[] play() {
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
