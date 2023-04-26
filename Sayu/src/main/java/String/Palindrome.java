package String;

public class Palindrome {

    public String longestPalindrome(String s) {
        int[] maxString = new int[]{-1, -1};
        int maxLen = 0;
        for (int idx = 0; idx < s.length(); idx++) {

            int[] currentOddLen = palindromicLength(s, idx - 1, idx + 1);
            int[] currentEvenLen = palindromicLength(s, idx, idx + 1);

            int len = currentOddLen[1] - currentOddLen[0];
            if (len > maxLen) {
                maxLen = len;
                maxString = currentOddLen;
            }

            len = currentEvenLen[1] - currentEvenLen[0];
            if (len > maxLen) {
                maxLen = len;
                maxString = currentEvenLen;
            }
        }

        return s.substring(maxString[0], maxString[1]);
    }

    private int[] palindromicLength(String s, int startIdx, int endIdx) {

        while (startIdx >= 0 && endIdx < s.length()) {
            char startChar = s.charAt(startIdx);
            char endChar = s.charAt(endIdx);
            if (startChar == endChar) {
                startIdx--;
                endIdx++;
            } else break;
        }
        return new int[]{startIdx + 1, endIdx};

    }
}
