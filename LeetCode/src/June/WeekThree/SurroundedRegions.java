package June.WeekThree;

public class SurroundedRegions {

	public static void main(String[] args) {

		char[][] arr = { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' },
				{ 'X', 'O', 'X', 'X' } };

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		solve(arr);
		System.out.println();
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void solve(char[][] board) {
		if (board.length == 0 || board[0].length == 0) {
			return;
		}
		for (int i = 0; i < board.length; i++) {
			if (board[i][0] == 'O')
				DFS(board, i, 0);
			if (board[i][board[0].length - 1] == 'O')
				DFS(board, i, board[0].length - 1);
		}

		for (int i = 0; i < board[0].length; i++) {
			if (board[0][i] == 'O')
				DFS(board, 0, i);
			if (board[board.length - 1][i] == 'O')
				DFS(board, board.length - 1, i);
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 'O') {
					board[i][j] = 'X';
				} else if (board[i][j] == '*') {
					board[i][j] = 'O';
				}
			}
		}

	}

	private static void DFS(char[][] board, int I, int J) {
		if (I > board.length - 1 || I < 0 || J > board[0].length || J < 0)
			return;
		if (board[I][J] == 'O')
			board[I][J] = '*';
		if (I > 0 && board[I - 1][J] == 'O') {
			DFS(board, I - 1, J);
		}
		if (I < board.length - 1 && board[I + 1][J] == 'O') {
			DFS(board, I + 1, J);
		}
		if (J > 0 && board[I][J - 1] == 'O') {
			DFS(board, I, J - 1);
		}
		if (J < board[0].length - 1 && board[I][J + 1] == 'O') {
			DFS(board, I, J + 1);
		}
	}

}
