package May.WeekThree;

import java.util.Stack;

public class StockSpannerP {

	public static void main(String[] args) {
		StockSpanner sS = new StockSpanner();
		sS.next(10);
	}

}

class StockSpanner {

	private Stack<DailyQ> st;

	public StockSpanner() {
		st = new Stack<>();
	}

	public int next(int price) {
		int res = 1;
		while (!st.isEmpty() && st.peek().price <= price) {
			res += st.pop().spanNum;
		}
		st.push(new DailyQ(price, res));
		return res;
	}

	public class DailyQ {
		public final int price, spanNum;

		public DailyQ(int price, int spanNum) {
			this.price = price;
			this.spanNum = spanNum;
		}
	}
}
