package threads;

import userInterface.ProAppGUI;
/** 
*@author: Mateo Loaiza
*@author: Juan Pablo Herrera
*@version: 26/05/2019
*ThreadClass AlarmShineThread
*/
public class AlarmShineThread extends Thread{

	private ProAppGUI pr;
	private boolean act;
	
	 /**
	  * This is the method that instantiates an AlarmShineThread, the builder of the thread
	  * @param p ProAppGUI the GUI to work with
	  * @param activate boolean to determine if it is active or not
	  */
	public AlarmShineThread(ProAppGUI p, boolean activate) {
		pr = p;
		act = activate;
	}
	public void run() {
		int counter = 0;
		while(act == true && counter < 5) {
			pr.alarmShine();
			try {
				sleep(100);
			} catch(InterruptedException e) {
				System.out.println("Interrupted");
			}
			pr.alarmDown();
			try {
				sleep(1000);
			} catch(InterruptedException e) {
				System.out.println("Interrupted");
			}
			counter += 1;
			try {
				sleep(100);
			}
			catch(InterruptedException i) {
				System.out.println("Interrupted");
			}
		}
	}
}
