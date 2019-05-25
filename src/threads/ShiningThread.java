package threads;


import userInterface.ProAppGUI;

public class ShiningThread extends Thread{
	ProAppGUI pr;

	public ShiningThread(ProAppGUI p) {
		pr = p;
	}

	public void run() {
		while(true) {
			pr.shine();
			try {
				sleep(100);
			} catch(InterruptedException e) {
				System.out.println("Interrupted");
			}
			pr.shutDownLights();
			try {
				sleep(100);
			} catch(InterruptedException e) {
				System.out.println("Interrupted");
			}
		}
	}
}
