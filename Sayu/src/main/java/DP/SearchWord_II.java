package DP;

import java.util.ArrayList;
import java.util.List;

public class SearchWord_II {
    final private char[][] board;
    final private String[] words;

    public SearchWord_II(char[][] board, String[] words) {
        this.board = board;
        this.words = words;
    }

    // Bruteforce
    public List<String> play() {
        List<String> listAnswer = new ArrayList<>();

        for (String wrd : words) {
            boolean foundWord = false;
            for (int idx = 0; idx < board.length; idx++) {
                for (int idy = 0; idy < board[0].length; idy++) {
                    if (wrd.charAt(0) == board[idx][idy] && findCheck(board, idx, idy, wrd, 0)) {
                        listAnswer.add(wrd);
                        foundWord = true;
                        break;
                    }
                }
                if (foundWord) break;
            }
        }
        return listAnswer;
    }

    private boolean findCheck(char[][] board, int idx, int idy, String toCheckWord, int sIdx) {
        if (idx < 0 || idy < 0 || idx >= board.length || idy >= board[0].length) return false;
        if (board[idx][idy] == '-') return false;

        int currentChar = board[idx][idy];
        char strChar = toCheckWord.charAt(sIdx);
        if (currentChar == strChar) {
            if (sIdx == toCheckWord.length() - 1)
                return true;
            else {
                board[idx][idy] = '-';

                boolean foundInSuccessorValue = findCheck(board, idx + 1, idy, toCheckWord, sIdx + 1)
                        || findCheck(board, idx - 1, idy, toCheckWord, sIdx + 1)
                        || findCheck(board, idx, idy + 1, toCheckWord, sIdx + 1)
                        || findCheck(board, idx, idy - 1, toCheckWord, sIdx + 1);

                board[idx][idy] = strChar;
                return foundInSuccessorValue;
            }
        } else
            return false;
    }
}
