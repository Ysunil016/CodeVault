package Array;

public class PerfectSumProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = { { 1 }, { 2 }, { 3 }, { 4 }, { 5 }, { 1, 2 }, { 1, 3 }, { 1, 4 }, { 1, 5 }, { 2, 3 }, { 2, 4 },
				{ 2, 5 }, { 3, 4 }, { 3, 5 }, { 4, 5 }, { 1, 2, 3 }, { 1, 2, 4 }, { 1, 2, 5 }, { 1, 3, 4 }, { 1, 3, 5 },
				{ 1, 4, 5 }, { 2, 3, 4 }, { 2, 3, 5 }, { 2, 4, 5 }, { 3, 4, 5 }, { 1, 2, 3, 4 }, { 1, 2, 4, 5 },
				{ 1, 3, 4, 5 }, { 2, 3, 4, 5 }, { 1, 2, 3, 4, 5 } };
		System.out.println(countForVal(arr, 10));
	}

	static int countForVal(int[][] arr, int key) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			int tCount = 0;
			for (int j = 0; j < arr[i].length; j++) {
				tCount += arr[i][j];
			}
			if (tCount == key) {
				System.out.println();
				for (int z = 0; z < arr[i].length; z++)
					System.out.print(arr[i][z] + " ");
				count++;
			}
		}
		System.out.println();
		return count;
	}

	static int[][] findAllUniqueSubSet(int[] arr) {
		int[][] result = new int[][];
	}

}
