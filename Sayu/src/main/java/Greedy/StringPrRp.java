package Greedy;

import java.util.Stack;

public class StringPrRp {
    private static String PR = "pr";
    private static String RP = "rp";

    public static void main(String[] args) {
        System.out.println("Max Sum " + findMaxValues(7, 7, "prpptppr"));
    }

    static long findMaxValues(int X, int Y, String S) {
        int totalValue = 0;
        String maxStringReq = X > Y ? PR : RP;
        Value maxValue = findMaxValue(S, maxStringReq, X);
        totalValue += maxValue.currentMax;

        String minStringReq = X <= Y ? PR : RP;
        String remaingString = maxValue.remainingString;
        Value minValue = findMaxValue(remaingString, minStringReq, Y);
        totalValue += minValue.currentMax;

        return totalValue;
    }

    private static Value findMaxValue(String str, String compareString, int value) {
        int totalValue = 0;
        Stack<Character> stack = new Stack<>();
        for (int idx = 0; idx < str.length(); idx++) {
            char currentChar = str.charAt(idx);
            if (stack.isEmpty()) {
                stack.push(currentChar);
                continue;
            }
            char topChar = stack.peek();
            if ((topChar + "" + currentChar).equals(compareString)) {
                stack.pop();
                totalValue += value;
            } else
                stack.push(currentChar);
        }
        StringBuilder strBuilder = new StringBuilder();
        while (!stack.isEmpty())
            strBuilder.append(stack.pop());
        return new Value(reverseString(strBuilder.toString()), totalValue);
    }

    static private String reverseString(String cString) {
        StringBuilder result = new StringBuilder();
        for (int idx = cString.length() - 1; idx >= 0; idx--) {
            result.append(cString.charAt(idx));
        }
        return result.toString();
    }

    private static class Value {
        String remainingString = "";
        int currentMax = 0;

        Value(String str, int currentMax) {
            this.remainingString = str;
            this.currentMax = currentMax;
        }

        @Override
        public String toString() {
            return "Value{" +
                    "remainingString='" + remainingString + '\'' +
                    ", currentMax=" + currentMax +
                    '}';
        }
    }
}
