package model;

public class Tip {

	private int number;
	private String tip;
	
	private Tip right;
	private Tip left;
	
	public Tip(int num, String t) {
		number = num;
		tip = t;
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
	 * @return the tip
	 */
	public String getTip() {
		return tip;
	}

	/**
	 * @param tip the tip to set
	 */
	public void setTip(String tip) {
		this.tip = tip;
	}

	/**
	 * @return the right
	 */
	public Tip getRight() {
		return right;
	}

	/**
	 * @param right the right to set
	 */
	public void setRight(Tip right) {
		this.right = right;
	}

	/**
	 * @return the left
	 */
	public Tip getLeft() {
		return left;
	}

	/**
	 * @param left the left to set
	 */
	public void setLeft(Tip left) {
		this.left = left;
	}
}
