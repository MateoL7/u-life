package threads;


import userInterface.ProAppGUI;
/** 
 *@author: Mateo Loaiza
 *@author: Juan Pablo Herrera
 *@version: 26/05/2019
 *ThreadClass MoveLightsThread
 */
public class MoveLightsThread extends Thread{

	private ProAppGUI pr;
	/**
	 * This is the method that instantiates a MoveLightsThread, the builder of the thread 
	 * @param p ProAppGUI the GUI to work with
	 */
	public MoveLightsThread(ProAppGUI p) {
		pr = p;
	}
	public void run() {
		while(pr.getBlinker2() != null) {
			pr.move1();
			try {
				sleep(100);
			} catch(InterruptedException e) {
				System.out.println("Interrupted");
			}
			pr.move1();
			try {
				sleep(100);
			} catch(InterruptedException e) {
				System.out.println("Interrupted");
			}
			pr.move1();
			try {
				sleep(100);
			} catch(InterruptedException e) {
				System.out.println("Interrupted");
			}
			pr.move1();
			try {
				sleep(100);
			} catch(InterruptedException e) {
				System.out.println("Interrupted");
			}
			pr.move1();
			try {
				sleep(100);
			} catch(InterruptedException e) {
				System.out.println("Interrupted");
			}
			pr.move1();
			try {
				sleep(500);
			} catch(InterruptedException e) {
				System.out.println("Interrupted");
			}
			//CHANGE MOVEMENT
			pr.move2();
			try {
				sleep(100);
			} catch(InterruptedException e) {
				System.out.println("Interrupted");
			}
			pr.move2();
			try {
				sleep(100);
			} catch(InterruptedException e) {
				System.out.println("Interrupted");
			}
			pr.move2();
			try {
				sleep(100);
			} catch(InterruptedException e) {
				System.out.println("Interrupted");
			}
			pr.move2();
			try {
				sleep(100);
			} catch(InterruptedException e) {
				System.out.println("Interrupted");
			}
			pr.move2();
			try {
				sleep(100);
			} catch(InterruptedException e) {
				System.out.println("Interrupted");
			}
			pr.move2();
			try {
				sleep(100);
			} catch(InterruptedException e) {
				System.out.println("Interrupted");
			}
			//CHANGE MOVEMENT
		}	
	}
}
