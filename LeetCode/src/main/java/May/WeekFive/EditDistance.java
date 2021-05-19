package May.WeekFive;

public class EditDistance {

	public static void main(String[] args) {
		System.out.println(minDistance("horse", "ros"));
	}

	public static int minDistance(String word1, String word2) {
		char[] arr2 = word1.toCharArray();
		char[] arr1 = word2.toCharArray();
		int[][] result = new int[arr2.length + 1][arr1.length + 1];
		for (int i = 0; i <= arr2.length; i++) {
			result[i][0] = i;
		}
		for (int i = 0; i <= arr1.length; i++) {
			result[0][i] = i;
		}
		for (int i = 1; i <= arr2.length; i++) {
			for (int j = 1; j <= arr1.length; j++) {
				if (arr1[j - 1] == arr2[i - 1]) {
					result[i][j] = result[i - 1][j - 1];
				} else
					result[i][j] = Math.min(Math.min(result[i - 1][j], result[i][j - 1]), result[i - 1][j - 1]) + 1;
			}
		}
//		for (int[] x : result) {
//			for (int v : x) {
//				System.out.print(v + " ");
//			}
//			System.out.println();
//		}
		return result[arr2.length][arr1.length];
	}

}



/*
 
 Edit Distance
Solution
Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.

You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character
Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
Example 2:

Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation: 
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')

 
 
 */
