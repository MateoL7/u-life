package model;
/** 
*@author: Mateo Loaiza
*@author: Juan Pablo Herrera
*@version: 26/05/2019
*Class Tip
*/
public class Tip {

	private int number;
	private String tip;
	
	private Tip right;
	private Tip left;
	
	/**
	 * This is the method that instantiates a Tip, the builder of the class
	 * @param num int with the number of the tip
	 * @param t String with the tip itself
	 */
	public Tip(int num, String t) {
		number = num;
		tip = t;
	}

	/**returns the current value of numbers
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}

	/** Changes the value of numbers for the parameters
	 * @param number the number to set
	 */
	public void setNumber(int number) {
		this.number = number;
	}

	/**returns the current value of tip
	 * @return the tip
	 */
	public String getTip() {
		return tip;
	}

	/**Changes the value of tip for the parameters
	 * @param tip the tip to set
	 */
	public void setTip(String tip) {
		this.tip = tip;
	}

	/**returns the value of right
	 * @return the right
	 */
	public Tip getRight() {
		return right;
	}

	/**Changes the value of right for the paramters
	 * @param right the right to set
	 */
	public void setRight(Tip right) {
		this.right = right;
	}

	/**returns the value of left
	 * @return the left
	 */
	public Tip getLeft() {
		return left;
	}

	/**Changes the value of left for the parameters
	 * @param left the left to set
	 */
	public void setLeft(Tip left) {
		this.left = left;
	}
}
