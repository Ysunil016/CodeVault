package August;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PascalTriangle {

	public static void main(String[] args) {
		for (int x : getRow(3)) {
			System.out.print(x + " ");
		}
	}

	public static List<Integer> getRow(int rowIndex) {
		List<List<Integer>> list = new LinkedList<>();
		if (rowIndex == 0)
			return Arrays.asList(1);
		;

		list.add(Arrays.asList(1));
		for (int i = 1; i <= rowIndex; i++) {
			ArrayList<Integer> innerList = new ArrayList<>();
			innerList.add(1);
			for (int j = 1; j < i; j++) {
				innerList.add(list.get(i - 1).get(j - 1) + list.get(i - 1).get(j));
			}
			innerList.add(1);
			list.add(innerList);
		}
		return list.get(rowIndex);
	}

}
