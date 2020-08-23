package August;

import java.util.Deque;
import java.util.LinkedList;

public class StreamOfCharacter {

	public static void main(String[] args) {
		StreamChecker sC = new StreamChecker(new String[] { "cd", "f", "kl" });
		System.out.println(sC.query('f'));
		System.out.println(sC.query('c'));
		System.out.println(sC.query('d'));
		System.out.println(sC.query('f'));
		System.out.println(sC.query('l'));
		System.out.println(sC.query('k'));
	}

	static class StreamChecker {

		class Trie {
			Trie[] children;
			boolean endOfWord;

			public Trie() {
				this.endOfWord = false;
				this.children = new Trie[26];
			}

			private void insertIntoTrie(String S) {
				Trie t = this;
				for (char c : S.toCharArray()) {
					if (t.children[c - 'a'] == null) {
						t.children[c - 'a'] = new Trie();
					}
					t = t.children[c - 'a'];
				}
				t.endOfWord = true;
			}

			private boolean search(Deque<Character> S) {
				Trie t = this;
				for (char c : S) {
					if (t.children[c - 'a'] == null) {
						return false;
					}
					t = t.children[c - 'a'];
					if (t.endOfWord) {
						return true;
					}
				}
				return false;
			}

		}

		public Trie t = new Trie();
		Deque<Character> dequeue = new LinkedList<>();

		public StreamChecker(String[] words) {
			for (String s : words) {
				String w_Rev = new StringBuilder(s).reverse().toString();
				t.insertIntoTrie(w_Rev);
			}
		}

		public boolean query(char letter) {
			dequeue.addFirst(letter);
			return t.search(dequeue);
		}
	}

}
