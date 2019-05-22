package model;

public class ULife {

	private Account firstUser;
	
	public ULife() {
		
	}
	/**
	 * @return the firstUser
	 */
	public Account getFirstUser() {
		return firstUser;
	}

	/**
	 * @param firstUser the firstUser to set
	 */
	public void setFirstUser(Account firstUser) {
		this.firstUser = firstUser;
	}
	
	public Account searchAccount(String username, String password) {
		boolean keep = true;
		Account found = null;
		if(firstUser != null) {
			Account current = firstUser;
			while(current.getNext() != firstUser && keep) {
				if(current.getUsername().equalsIgnoreCase(username)) {
					if(current.getPassword().equalsIgnoreCase(password)) {
						found = current;
					}
				}
				current = current.getNext();
			}
		}
		return found;
	}
}
