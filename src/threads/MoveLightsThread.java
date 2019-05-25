package threads;

import userInterface.ProAppGUI;

public class MoveLightsThread extends Thread{

	private ProAppGUI pr;
	public MoveLightsThread(ProAppGUI p) {
		pr = p;
	}
	public void run() {
		while(true) {
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
				sleep(500);
			} catch(InterruptedException e) {
				System.out.println("Interrupted");
			}
			//CHANGE MOVEMENT
		}
	}
}
