package Start;

import java.util.HashMap;
import java.util.Scanner;

public class DecodingWay {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		HashMap<Integer, Character> storeCode = alphaCoding();
		String inputString = scan.next();
		System.out.println(deCoding(storeCode, inputString, inputString.length()));
	}

	public static HashMap<Integer, Character> alphaCoding() {
		HashMap<Integer, Character> codingStore = new HashMap<Integer, Character>();
		codingStore.put(1, 'a');
		codingStore.put(2, 'b');
		codingStore.put(3, 'c');
		codingStore.put(4, 'd');
		codingStore.put(5, 'e');
		codingStore.put(6, 'f');
		codingStore.put(7, 'g');
		codingStore.put(8, 'h');
		codingStore.put(9, 'i');
		codingStore.put(10, 'j');
		codingStore.put(11, 'k');
		codingStore.put(12, 'l');
		codingStore.put(13, 'm');
		codingStore.put(14, 'n');
		codingStore.put(15, 'o');
		codingStore.put(16, 'p');
		codingStore.put(17, 'q');
		codingStore.put(18, 'r');
		codingStore.put(19, 's');
		codingStore.put(20, 't');
		codingStore.put(21, 'u');
		codingStore.put(22, 'v');
		codingStore.put(23, 'w');
		codingStore.put(24, 'x');
		codingStore.put(25, 'y');
		codingStore.put(26, 'z');
		return codingStore;
	}

	public static int deCoding(HashMap<Integer, Character> hashStore, String alpha, int ext) {
		
		
		
		return 0;
	}
}
