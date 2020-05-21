package May.WeekThree;

/*

Count Square Submatrices with All Ones
Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.

 

Example 1:

Input: matrix =
[
  [0,1,1,1],
  [1,1,1,1],
  [0,1,1,1]
]
Output: 15
Explanation: 
There are 10 squares of side 1.
There are 4 squares of side 2.
There is  1 square of side 3.
Total number of squares = 10 + 4 + 1 = 15.
Example 2:

Input: matrix = 
[
  [1,0,1],
  [1,1,0],
  [1,1,0]
]
Output: 7
Explanation: 
There are 6 squares of side 1.  
There is 1 square of side 2. 
Total number of squares = 6 + 1 = 7.
 

Constraints:

1 <= arr.length <= 300
1 <= arr[0].length <= 300
0 <= arr[i][j] <= 1

*/

public class CountSquareSubmatrices {

	public static void main(String[] args) {
		int[][] arr = { { 1, 0, 1 }, { 1, 1, 0 }, { 1, 1, 0 } };
		manipulateMaxSquareMatrix(arr);
	}

	static int manipulateMaxSquareMatrix(int[][] arr) {
		int count = 0;
		for (int i = 0; i < arr[0].length; i++) {
			count += arr[0][i];
		}

		for (int i = 1; i < arr.length; i++) {
			count += arr[i][0];
		}

		
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < arr[0].length; j++) {
				if (arr[i][j] != 0) {
					arr[i][j] = Math.min(arr[i - 1][j - 1], Math.min(arr[i][j - 1], arr[i - 1][j])) + 1;
				}
				count += arr[i][j];
			}
		}

		System.out.println(count);

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		return count;
	}

}
