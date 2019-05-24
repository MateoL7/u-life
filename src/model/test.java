package model;

public class test {
	
	public static void main(String [] args) {
		String u = "juan";
		Account a = new Account(u,u,18,2.4,2.4,u,u,u);
		int num = 5;
		int num2 = 4;
		boolean [] days = new boolean[6];
		boolean m = true;
		a.addAlarm(num, num2, u, m, days);
		String c = a.CheckAlarm(5, 5);
		if(c.isEmpty()) {
			System.out.println("funciono");
		}
	}

}
