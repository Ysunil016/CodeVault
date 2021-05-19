package September;

import java.util.ArrayList;
import java.util.List;

public class BullsCows {

    public static void main(String[] args) {

        System.out.println(getHint("1123", "0111"));
        System.out.println(getHintOptamized("1123", "0111"));
    }

    public static String getHint(String secret, String guess) {
        // Check for Bulls
        // O(N) -> Compare Digits and Check if They are Equal -> Mark -1
        char[] sArray = secret.toCharArray();
        char[] gArray = guess.toCharArray();

        int Bulls = 0;
        List<Character> secSet = new ArrayList<Character>();
        for (int i = 0; i < sArray.length; i++) {
            if (sArray[i] == gArray[i]) {
                gArray[i] = 'X';
                sArray[i] = 'X';
                Bulls++;
            }
            secSet.add(sArray[i]);
        }

        // Check for Cows Now,
        int Cows = 0;
        for (int i = 0; i < gArray.length; i++) {
            if (gArray[i] != 'X') {
                if (secSet.contains(gArray[i])) {
                    secSet.remove((Object) gArray[i]);
                    Cows++;
                }
            }
        }

        return Bulls + "A" + Cows + "B";
    }

    // Optamized -> Without Using ArrayList -> Linear Time Complexity
    public static String getHintOptamized(String secret, String guess) {
        int[] numbers = new int[10];

        // Storing Unequal Occurances
        for (int i = 0; i < secret.length(); ++i) {
            if (secret.charAt(i) != guess.charAt(i)) {
                numbers[secret.charAt(i) - 48]++;
            }
        }

        int Bulls = 0, Cows = 0;
        // Checking for Bull and Cow
        for (int i = 0; i < secret.length(); ++i) {
            if (secret.charAt(i) == guess.charAt(i))
                Bulls++;
            else {
                if (numbers[guess.charAt(i) - 48] > 0) {
                    Cows++;
                    numbers[guess.charAt(i) - 48]--;
                }
            }
        }
        return Bulls + "A" + Cows + "B";
    }

}
