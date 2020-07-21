package July;

public class WordSearch {

	public static void main(String[] args) {
		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		System.out.println(exist(board, "ABCCED"));

	}

	public static boolean exist(char[][] board, String word) {
		char x = word.charAt(0);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == x) {
					if (dfs(board, i, j, word, 0)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public static boolean dfs(char[][] board, int i, int j, String word, int sIndex) {
		if (i > board.length - 1 || j > board[0].length - 1 || i < 0 || j < 0 || sIndex > word.length() - 1) {
			sIndex--;
			return false;
		}
		char foundChar = board[i][j];
		if (foundChar != word.charAt(sIndex) || foundChar == '1') {
			sIndex--;
			return false;
		}

		if (sIndex == word.length() - 1)
			return true;

		board[i][j] = '1';
		boolean result = dfs(board, i, j + 1, word, sIndex + 1) || dfs(board, i + 1, j, word, sIndex + 1)
				|| dfs(board, i, j - 1, word, sIndex + 1) || dfs(board, i - 1, j, word, sIndex + 1);

		board[i][j] = foundChar;

		return result;

	}

}
