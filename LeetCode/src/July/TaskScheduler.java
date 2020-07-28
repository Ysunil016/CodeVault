package July;

import java.util.Arrays;

public class TaskScheduler {

	public static void main(String[] args) {
		char[] arr = { 'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
		int r = 2;
		System.out.println(leastInterval(arr, r));
	}

	public static int leastInterval(char[] tasks, int n) {
		char[] task_frequncy = new char[26];
		for (char x : tasks) {
			task_frequncy[x - 'A']++;
		}
		Arrays.sort(task_frequncy);
		int maxFreq = task_frequncy[25] - 1;
		int idleSlots = maxFreq * n;

		for (int i = 24; i >= 0; i--) {
			idleSlots -= Math.min(maxFreq, task_frequncy[i]);
		}
		return (idleSlots > 0) ? idleSlots + tasks.length : tasks.length;

	}

}
