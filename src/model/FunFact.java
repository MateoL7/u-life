package model;

public class FunFact {

	private String number;
	private String fact;
	
	private FunFact right;
	private FunFact left;
	
	public FunFact(String num, String f) {
		number = num;
		fact = f;
	}

	/**
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(String number) {
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

	/**
	 * @return the right
	 */
	public FunFact getRight() {
		return right;
	}

	/**
	 * @param right the right to set
	 */
	public void setRight(FunFact right) {
		this.right = right;
	}

	/**
	 * @return the left
	 */
	public FunFact getLeft() {
		return left;
	}

	/**
	 * @param left the left to set
	 */
	public void setLeft(FunFact left) {
		this.left = left;
	}
}
