package Processes;

public class Process_Two extends Thread {

	private int val;

	public Process_Two(int val) {
		this.val = val;
	}

	@Override
	public void run() {
		System.out.println("Process Two is Running " + ProcessHandle.current().pid());
		System.out.println(Thread.currentThread().getId());
		for (int i = 0; i < 1000; i++)
			this.val++;
		System.out.println(val);

	}

}
