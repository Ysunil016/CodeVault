package DP;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SearchWord_IITest {

    @Test
    public void act() {
        char[][] board = new char[][]{{'o', 'a', 'b', 'n'}, {'o', 't', 'a', 'e'}, {'a', 'h', 'k', 'r'}, {'a', 'f', 'l', 'v'}};
        String[] words = new String[]{"oa", "oaa"};

        List<String> actualResult = new SearchWord_II(board, words).play();
        List<String> expectedResult = List.of("oa", "oaa");

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void act2() {
        char[][] board = new char[][]{{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        String[] words = new String[]{"oath", "pea", "eat", "rain"};

        List<String> actualResult = new SearchWord_II(board, words).play();
        List<String> expectedResult = List.of("oath", "eat");

        assertEquals(expectedResult, actualResult);
    }

}