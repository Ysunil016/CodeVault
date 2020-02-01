package Array;

public class CurrencyATMDispatch {

	public static void main(String[] args) throws NoteExhausted {
		int[] currency = { 2000, 1000, 500, 100 };
		int[] noteCount = { 5, 4, 2, 8 };

		int amout2Withdraw = 5800;

		withdrawMoney(amout2Withdraw, currency, noteCount);
		for (int i = 0; i < noteCount.length; i++)
			System.out.print(" " + noteCount[i]);
	}

	static int[] withdrawMoney(int amount, int[] currency, int[] noteCount) throws NoteExhausted {
		for (int i = 0; i < currency.length; i++) {
			int noteMul = amount / currency[i];
			for (int j = 0; j < noteMul && noteCount[i] != 0; j++) {
				noteCount[i]--;
				amount -= currency[i];
			}
		}

		if (amount != 0) {
			throw new NoteExhausted("Not Able to Withdraw");
		}

		return noteCount;
	}

	static class NoteExhausted extends Exception {
		/**
		 * 
		 */
		private static final long serialVersionUID = -5376249816839219293L;

		NoteExhausted(String s) {
			super(s);
		}
	}
}
