package Basic;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class Anagram {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		int testC = scan.nextInt();
		for (int i = 0; i < testC; i++) {
			String a = scan.next();
			String b = scan.next();
			System.out.println(makeAnagram(a, b));
		}
	}

	static int makeAnagram(String a, String b) {
		int sum = 0;
		HashMap<Character, Integer> storageProgram = new HashMap<Character, Integer>();
		for (int i = 0; i < a.length(); i++) {
			char v = a.charAt(i);
			if (storageProgram.get(v) == null) {
				storageProgram.put(v, 1);
			} else {
				int tr = storageProgram.get(v);
				storageProgram.put(v, ++tr);
			}
		}
		for (int i = 0; i < b.length(); i++) {
			char v = b.charAt(i);
			if (storageProgram.get(v) == null) {
				sum++;
			} else {
				int tr = storageProgram.get(v);
				if (tr == 1)
					storageProgram.remove(v);
				else
					storageProgram.put(v, --tr);
			}
		}

		for (Entry<Character, Integer> m : storageProgram.entrySet()) {
			sum += m.getValue();
		}
		return sum;
	}

}
