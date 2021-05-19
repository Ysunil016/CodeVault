package July;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PrisonCellsAfterNDays {

	public static void main(String[] args) {
		int[] arr = { 1, 1, 0, 0, 0, 0, 0, 1 };

		for (int x : prisonAfterNDays(arr, 10)) {
			System.out.print(x);
		}
	}

	public static int[] prisonAfterNDays(int[] cells, int N) {
		if (N == 0) {
			return cells;
		}
		HashSet<Integer> hSet = new HashSet<>();
		List<int[]> aStore = new ArrayList<>();
		int T = 0;
		for (T = 0; T < N; T++) {
			int prevElement = cells[0];
			cells[0] = 0;
			int calV = 0;
			int i = 1;
			for (i = 1; i < 7; i++) {
				if (prevElement == cells[i + 1]) {
					prevElement = cells[i];
					cells[i] = 1;
					calV += Math.pow(2, (8 - i));
				} else {
					prevElement = cells[i];
					cells[i] = 0;
				}
			}
			cells[i] = 0;
			aStore.add(cells.clone());
			if (hSet.contains(calV)) {
				break;
			}

			hSet.add(calV);
		}

		if (N < 8) {
			return cells;
		}
		int Rem = N % T;
		if (Rem == 0) {
			return aStore.get(T - 1);
		}
		return aStore.get(Rem - 1);
	}
}
