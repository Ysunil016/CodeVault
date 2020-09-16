package Array;

public class MinimumAverageTime {

	public static void main(String[] args) {
		int[][] pizzaOrder = { { 0, 3 }, { 1, 9 }, { 2, 6 } };
		System.out.println(minimumAverage(pizzaOrder));
	}

	static int minimumAverage(int[][] customers) {
		int ordersLength = customers.length;

		int overAllWaiting = 0;

		int cummuativeTime = 0;
		int orderCounter = 0;

		int processNumber = customers[0][0];
		int processArrival = customers[0][0];
		int processTime = customers[0][1];
		makeOrderPrepared(customers, 0);
		cummuativeTime += processTime;

		for (int i = 1; i < ordersLength; i++) {
			findingRemainingOrders(customers, processTime);
		}

		return 0;
	}

	static int[][] findingRemainingOrders(int[][] customers, int time) {
		for (int i = 0; i < customers.length; i++) {
			if (customers[i] != null)
				if (customers[i][0] <= time) {
					System.out.println(customers[i][0]);
				}
		}

		return customers;
	}

	static int[][] makeOrderPrepared(int[][] customers, int orderId) {
		customers[orderId] = null;
		return customers;
	}

}
