package August;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class AddAndSearchWord {

	public static void main(String[] args) {
		WordDictionary wD = new WordDictionary();
		wD.addWord("bad");
		wD.addWord("dad");
		wD.addWord("mad");
		System.out.println(wD.search("bad"));
		System.out.println(wD.search("pad"));
		System.out.println(wD.search("b.."));
		System.out.println(wD.search(".ad"));
	}

	static class WordDictionary {

		HashMap<Integer, HashSet<String>> hashMap;

		public WordDictionary() {
			hashMap = new HashMap<>();
		}

		public void addWord(String word) {
			int length = word.length();
			if (hashMap.containsKey(length)) {
				HashSet<String> res = hashMap.get(length);
				res.add(word);
				hashMap.put(length, res);
			} else {
				hashMap.put(length, new HashSet<>(Arrays.asList(word)));
			}
		}

		public boolean search(String word) {
			int len = word.length();
			if (!hashMap.containsKey(len))
				return false;

			if (hashMap.get(len).contains(word))
				return true;

			for (String str : hashMap.get(len)) {
				if (str.length() == word.length()) {
					if (str.matches(word)) {
						return true;
					}
				}
			}

			return false;
		}
	}

	static class Trie {
		Trie[] children;

		boolean isWord;

		public Trie() {
			this.children = new Trie[26];

			this.isWord = false;
		}
	}

	static class WordDictionary2 {

		Trie root;

		/** Initialize your data structure here. */
		public WordDictionary2() {
			this.root = new Trie();
		}

		/** Adds a word into the data structure. */
		public void addWord(String word) {
			Trie cur = root;

			for (char c : word.toCharArray()) {
				if (cur.children[c - 'a'] == null) {
					cur.children[c - 'a'] = new Trie();
				}
				cur = cur.children[c - 'a'];
			}

			cur.isWord = true;

		}

		/**
		 * Returns if the word is in the data structure. A word could contain the dot
		 * character '.' to represent any one letter.
		 */
		public boolean search(Trie cur, String word, int i) {
			if (i == word.length()) {
				return cur.isWord;
			}
			char c = word.charAt(i);

			if (c == '.') {
				for (Trie child : cur.children) {
					if (child != null && search(child, word, i + 1)) {
						return true;
					}
				}
				return false;
			} else {

				if (cur.children[c - 'a'] != null && search(cur.children[c - 'a'], word, i + 1)) {
					return true;
				}
			}

			return false;
		}

		public boolean search(String word) {

			return search(root, word, 0);
		}
	}

}
