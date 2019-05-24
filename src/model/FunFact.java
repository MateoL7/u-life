package model;

public class FunFact {

	private int number;
	private String fact;
	
	public FunFact(int num, String f) {
		number = num;
		fact = f;
	}

	/**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(int number) {
		this.number = number;
	}

	/**
	 * @return the fact
	 */
	public String getFact() {
		return fact;
	}

	/**
	 * @param fact the fact to set
	 */
	public void setFact(String fact) {
		this.fact = fact;
	}
}
