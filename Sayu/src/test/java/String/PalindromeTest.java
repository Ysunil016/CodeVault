package String;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeTest {

    @Test
    public void act() {
        String input = "ababc";
        String actualPalindrome = new Palindrome().longestPalindrome(input);
        assertEquals("aba", actualPalindrome);
    }

    public void act2() {
        String input = "ac";
        String actualPalindrome = new Palindrome().longestPalindrome(input);
        assertEquals("a", actualPalindrome);
    }

}