package May.WeekFour;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SortCharacterByFrequency {

	public static void main(String[] args) {
		System.out.println(frequencySort("tree"));
	}

	public static String frequencySort(String s) {
		char[] arr = s.toCharArray();
		HashMap<Character, Integer> store = new LinkedHashMap<>();
		for (char x : arr) {
			if (store.containsKey(x)) {
				store.put(x, store.get(x) + 1);
			} else {
				store.put(x, 1);
			}
		}
		// Sorting w.r.t Values Stored in HashMap
		List<Map.Entry<Character, Integer>> list = new LinkedList<Map.Entry<Character, Integer>>(store.entrySet());
		Collections.sort(list, (Map.Entry<Character, Integer> arg0, Map.Entry<Character, Integer> arg1)-> arg1.getValue().compareTo(arg0.getValue()));
		StringBuilder str = new StringBuilder();
		for (Map.Entry<Character, Integer> x : list) {
			for (int y=0;y<x.getValue();y++) {
				str.append(x.getKey());
			}
		}
		return new String(str);
	}

}
