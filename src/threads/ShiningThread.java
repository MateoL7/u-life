package threads;


import userInterface.ProAppGUI;
/** 
 *@author: Mateo Loaiza
 *@author: Juan Pablo Herrera
 *@version: 26/05/2019
 *ThreadClass ShiningThread
 */
public class ShiningThread extends Thread{
	private ProAppGUI pr;
	/**
	 * This is the method that instantiates a MoveLightsThread, the builder of the thread 
	 * @param p ProAppGUI the GUI to work with
	 */
	public ShiningThread(ProAppGUI p) {
		pr = p;
	}

	public void run() {
		while(pr.getShinning()) {
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
