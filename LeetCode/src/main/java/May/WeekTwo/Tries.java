package May.WeekTwo;

import java.util.HashSet;

public class Tries {

	public static void main(String[] args) {
		Trie tr = new Trie();
		tr.insert("hello");
		System.out.println(tr.search("hell")); // True
		System.out.println(tr.search("helloa")); // False
		System.out.println(tr.search("hello")); // True
		System.out.println(tr.search("helloa")); // False
		System.out.println(tr.startsWith("hell")); // True
		System.out.println(tr.startsWith("helloa")); // True
		System.out.println(tr.startsWith("hello")); // True

	}

	// Optamised for RunTime, But Takes Space (30ms for apple, app and ... )
	static class Trie {
		private Trie children[];
		boolean isEndOfWord;

		public Trie() {
			children = new Trie[26];
			isEndOfWord = false;
		}

		public void insert(String word) {
			Trie current = this;
			for (char x : word.toCharArray()) {
				if (current.children[x - 'a'] == null) {
					current.children[x - 'a'] = new Trie();
				}
				current = current.children[x - 'a'];
			}
			current.isEndOfWord = true;
		}

		public boolean search(String word) {
			Trie current = this;
			for (char x : word.toCharArray()) {
				current = current.children[x - 'a'];
				if (current == null) {
					return false;
				}
			}
			if (current.isEndOfWord == true)
				return true;
			return false;
		}

		public boolean startsWith(String prefix) {
			Trie current = this;
			for (char x : prefix.toCharArray()) {
				current = current.children[x - 'a'];
				if (current == null) {
					return false;
				}
			}
			return true;
		}
	}


	// Brute Force for Space, But Takes Time (511ms for apple, app and ... )
	static class TrieNieve {

		HashSet<String> store;

		public TrieNieve() {
			store = new HashSet<>();
		}

		public void insert(String word) {
			store.add(word);
		}

		public boolean search(String word) {
			if (store.contains(word))
				return true;
			return false;
		}

		public boolean startsWith(String prefix) {
			boolean hasItem = false;
			for (String item : store) {
				boolean isEqual = true;
				if (prefix.length() > item.length()) {
					isEqual &= false;
				} else
					for (int i = 0; i < prefix.length(); i++) {
						if (prefix.charAt(i) == item.charAt(i)) {
							isEqual &= true;
						} else {
							isEqual &= false;
						}
					}
				hasItem |= isEqual;
			}
			return hasItem;
		}
	}

}
