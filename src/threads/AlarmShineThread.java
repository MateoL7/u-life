package threads;

import userInterface.ProAppGUI;

public class AlarmShineThread extends Thread{

	private ProAppGUI pr;
	private boolean act;
	
	public AlarmShineThread(ProAppGUI p, boolean activate) {
		pr = p;
		act = activate;
	}
	public void run() {
		while(act == true) {
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
