package Processes;

public class Start {

	public static void main(String[] args) throws InterruptedException {
		Process_One processThread = new Process_One(1);
		Process_Two process2Thread = new Process_Two(10);
		Thread processTThread = new Thread(processThread);

		
		processTThread.start();
		process2Thread.start();
			
		
	}

}
