package July;

import java.util.ArrayList;
import java.util.List;

public class UglyNumber2 {

	public static void main(String[] args) {
		System.out.println(nthUglyNumber(1500));
	}

	public static int nthUglyNumber(int n) {
		if (n == 1) {
			return 1;
		}
		List<Integer> stack = new ArrayList<>();
		stack.add(1);
		int i = 0, j = 0, k = 0;
		while (stack.size() < n) {
			stack.add(Math.min(stack.get(i) * 2, Math.min(stack.get(j) * 3, stack.get(k) * 5)));
			if (stack.get(stack.size() - 1) == stack.get(i) * 2)
				i++;
			if (stack.get(stack.size() - 1) == stack.get(j) * 3)
				j++;
			if (stack.get(stack.size() - 1) == stack.get(k) * 5)
				k++;
		}
		return stack.get(stack.size() - 1);
	}
}
