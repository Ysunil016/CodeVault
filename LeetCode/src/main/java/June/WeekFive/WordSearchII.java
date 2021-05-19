package June.WeekFive;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {

	static class Trie {
		Trie[] Children;
		String word;

		public Trie() {
			Children = new Trie[26];
			word = null;
		}
	}

	public static void main(String[] args) {
		char[][] board = { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' }, { 'i', 'h', 'k', 'r' },
				{ 'i', 'f', 'l', 'v' } };
		String[] words = { "oath", "pea", "eat", "rain" };
		for (String S : findWords(board, words)) {
			System.out.println(S);
		}
	}

	public static List<String> findWords(char[][] board, String[] words) {
		List<String> res = new ArrayList<>();

		Trie root = new Trie();
		buildTries(root, words);

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				char C = board[i][j];
				if (root.Children[C - 'a'] != null)
					dfs(board, i, j, root, res);
			}
		}
		return res;
	}

	private static void dfs(char[][] board, int i, int j, Trie cur, List<String> res) {
		if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1) {
			return;
		}

		if (board[i][j] == '#') {
			return;
		}
		char C = board[i][j];
		if (cur.Children[C - 'a'] == null) {
			return;
		}
		cur = cur.Children[C - 'a'];
		if (cur.word != null) {
			res.add(cur.word);
			cur.word = null;
		}

		board[i][j] = '#';
		dfs(board, i + 1, j, cur, res);
		dfs(board, i - 1, j, cur, res);
		dfs(board, i, j + 1, cur, res);
		dfs(board, i, j - 1, cur, res);
		board[i][j] = C;
	}

	private static void buildTries(Trie root, String[] words) {
		for (String w : words) {
			Trie Cur = root;
			for (char C : w.toCharArray()) {
				int index = (int) (C - 'a');
				if (Cur.Children[index] == null) {
					Cur.Children[index] = new Trie();
				}
				Cur = Cur.Children[index];
			}
			Cur.word = w;
		}
	}
}
