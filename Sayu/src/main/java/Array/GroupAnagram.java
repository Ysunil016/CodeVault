package Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
*/
public class GroupAnagram {

    public static void main(String[] args) {
        String[] strings = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        for (List<String> list : groupAnagrams(strings)) {
            System.out.println(list);
        }
    }

    private static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<Integer, List<String>> anagramStore = new HashMap<>();

        for (String str : strs) {
            int asciiValue = getAsciiSum(str);
            if (anagramStore.containsKey(asciiValue))
                anagramStore.get(asciiValue).add(str);
            else anagramStore.put(asciiValue, new ArrayList<>() {{
                add(str);
            }});
        }

        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<Integer, List<String>> entry : anagramStore.entrySet())
            res.add(entry.getValue());

        return res;
    }

    private static int getAsciiSum(String str) {
        int asciiSum = 0;
        for (int idx = 0; idx < str.toCharArray().length; idx++) {
            asciiSum += (int) (str.charAt(idx) - 'a');
        }
        return asciiSum;
    }

}
