package Working;

public class HeapSort {

	static int[] heapArr = new int[10];

	public static void main(String[] args) {

		int[] arr = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
//		int[] arr = { 4, 1, 3, 9, 7 };

		for (int i = 0; i < arr.length; i++)
			buildHeap(arr[i]);

		readHeap();
	}

	static void readHeap() {
		for (int i : heapArr)
			System.out.print(" " + i);
	}

	static void heapify(int index, int end) {
		if (index < end) {
			return;
		} else {
			int leftChild = getLeftChildIndex(index);
			int rightChild = getRightChildIndex(index);

			if (heapArr[index] <= heapArr[leftChild]) {
				int indexElement = heapArr[index];
				heapArr[index] = heapArr[leftChild];
				heapArr[leftChild] = indexElement;
				heapify(leftChild, end);
			} else {
				int indexElement = heapArr[index];
				heapArr[index] = heapArr[rightChild];
				heapArr[rightChild] = indexElement;
				heapify(rightChild, end);
			}
		}
	}

	static void buildHeap(int n) {
		int counter = 0;
		while (heapArr[counter] != 0) {
			counter++;
		}
		heapArr[counter] = n;

		int temp = heapArr[0];
		// Swapping Last Element to Head
		heapArr[0] = n;
		heapArr[counter] = temp;
		heapify(0, heapArr.length);
	}

	static int getLeftChildIndex(int index) {
		return index * 2 + 1;
	}

	static int getRightChildIndex(int index) {
		return index * 2 + 2;
	}

	static int getParentIndex(int index) {
		return index / 2;
	}

}
