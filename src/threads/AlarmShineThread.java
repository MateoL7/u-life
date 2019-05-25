package threads;

import userInterface.ProAppGUI;

public class AlarmShineThread extends Thread{

	private ProAppGUI pr;
	
	public AlarmShineThread(ProAppGUI p) {
		pr = p;
	}
	public void run() {
		while(pr.active) {
			pr.alarmShine();
			try {
				sleep(100);
			} catch(InterruptedException e) {
				System.out.println("Interrupted");
			}
			pr.alarmDown();
			try {
				sleep(100);
			} catch(InterruptedException e) {
				System.out.println("Interrupted");
			}
		}
	}
}
