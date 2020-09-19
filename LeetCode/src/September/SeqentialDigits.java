package September;

import java.util.ArrayList;
import java.util.List;

public class SeqentialDigits {

    public static void main(String[] args) {
        System.out.println(sequentialDigits(100, 300));
    }

    public static List<Integer> sequentialDigits(int low, int high) {
        List<Integer> resultList = new ArrayList<>();

        int lowDigits = 0;
        int highDigits = 0;

        int lowC = low;
        while (lowC != 0) {
            lowC /= 10;

            lowDigits++;
        }
        int highC = high;
        while (highC != 0) {
            highC /= 10;
            highDigits++;
        }

        for (int i = lowDigits; i <= highDigits; i++) {
            getForCount(resultList, i, low, high);
        }
        return resultList;
    }

    private static void getForCount(List<Integer> resultList, int digitCount, int low, int high) {
        int[] digits = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        for (int i = 0; i < digits.length - digitCount + 1; i++) {
            int numberFormation = 0;
            for (int j = i; j < digitCount+i; j++) {
                numberFormation *= 10;
                numberFormation += digits[j];
            }
            if (numberFormation >= low && numberFormation <= high) {
                resultList.add(numberFormation);
            }
        }

    }
}

