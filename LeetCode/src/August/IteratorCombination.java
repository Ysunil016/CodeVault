package August;

import java.util.LinkedList;
import java.util.Queue;

public class IteratorCombination {

	public static void main(String[] args) {
		CombinationIterator cmbIterator = new CombinationIterator("abc", 2);
		while (cmbIterator.hasNext()) {
			System.out.println(cmbIterator.next());
		}
	}

	static class CombinationIterator {
		Queue<String> list;
		int cLength = 0;
		String characters;

		public CombinationIterator(String characters, int combinationLength) {
			list = new LinkedList<>();
			this.characters = characters;
			this.cLength = combinationLength;
			makeCombination("", 0);
		}

		private void makeCombination(String str, int index) {
			if (str.length() == cLength) {
				list.add(str);
				return;
			}

			for (int i = index; i < characters.length(); i++) {
				makeCombination(str + characters.charAt(i), i + 1);
			}
		}

		public String next() {
			return list.remove();
		}

		public boolean hasNext() {
			return !list.isEmpty();
		}
	}

}
