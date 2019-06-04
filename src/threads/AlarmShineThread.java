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
	
	 /**
	  * This is the method that instantiates an AlarmShineThread, the builder of the thread
	  * @param p ProAppGUI the GUI to work with
	  * @param activate boolean to determine if it is active or not
	  */
	public AlarmShineThread(ProAppGUI p, boolean activate) {
		pr = p;
	}
	public void run() {
		while(pr.getBlinker3() != null) {
			pr.alarmShine();
			try {
				sleep(200);
			} catch(InterruptedException e) {
				System.out.println("Interrupted");
			}
			pr.alarmDown();
			try {
				sleep(200);
			} catch(InterruptedException e) {
				System.out.println("Interrupted");
			}
		}
	}
}
