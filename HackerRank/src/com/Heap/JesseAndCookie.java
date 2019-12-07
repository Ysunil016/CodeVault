package com.Heap;

public class JesseAndCookie {

	static private int[] head;
	static private int size;
	final static int FRONT = 1;

	static public void MinHeap(int maxSize) {
		head = new int[maxSize];
		head[0] = Integer.MIN_VALUE;
		size = 0;
	}

	public static void main(String[] args) {
		int[] arr = new int[100000];
		for (int i = 0; i < 100000; i++) {
			arr[i] = 1;
		}
		MinHeap(arr.length + 1);
		for (int i = 0; i < arr.length; i++)
			insert(arr[i]);
		System.out.println("Operations " + JesseCookie(105823341, head));
	}

	static int JesseCookie(int K, int[] arr) {
		int operation = 0;
		int KES = remove();
		while (KES < K) {
			try {
				int SUM = 1 * KES + 2 * remove();
				insert(SUM);
				KES = remove();
				operation++;
			} catch (Exception e) {
				return -1;
			}
		}
		return operation;
	}

	static private int leftChild(int pos) {
		return pos * 2;
	}

	static private int rightChild(int pos) {
		return pos * 2 + 1;
	}

	static private int parent(int pos) {
		return pos / 2;
	}

	static private boolean isLeaf(int pos) {
		if (pos >= size / 2 && pos <= size) {
			return true;
		}
		return false;

	}

	static private void swap(int fpos, int spos) {
		int tmp;
		tmp = head[spos];
		head[spos] = head[fpos];
		head[fpos] = tmp;
	}

	static private void insert(int element) {
		head[++size] = element;
		int current = size;
		while (head[current] < head[parent(current)]) {
			swap(current, parent(current));
			current = parent(current);
		}
	}

	static private int remove() {
		int pop = head[FRONT];
		head[FRONT] = head[size--];
		minHeapify(FRONT);
		return pop;
	}

	static private void minHeapify(int pos) {

		if (!isLeaf(pos)) {
			if (head[pos] > head[leftChild(pos)] || head[pos] > head[rightChild(pos)]) {

				if (head[leftChild(pos)] < head[rightChild(pos)]) {
					swap(pos, leftChild(pos));
					minHeapify(leftChild(pos));
				} else {
					swap(pos, rightChild(pos));
					minHeapify(rightChild(pos));
				}

			}

		}

	}

//	static private void printHeap(int[] arr) {
//		for (int i = 1; i < arr.length; i++)
//			System.out.print(arr[i] + " ");
//	}
}
