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

	/**returns the current value of number
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}

	/**changes the current value of number for the parameter
	 * @param number the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	/**returns the current value of fact
	 * @return the fact
	 */
	public String getFact() {
		return fact;
	}

	/**changes the value of fact for the parameter
	 * @param fact the fact to set
	 */
	public void setFact(String fact) {
		this.fact = fact;
	}

	/**returns the value of right
	 * @return the right
	 */
	public FunFact getRight() {
		return right;
	}

	/**changes the value of right for the parameter
	 * @param right the right to set
	 */
	public void setRight(FunFact right) {
		this.right = right;
	}

	/**returns the value of left
	 * @return the left
	 */
	public FunFact getLeft() {
		return left;
	}

	/**Changes the value of left for the parameter
	 * @param left the left to set
	 */
	public void setLeft(FunFact left) {
		this.left = left;
	}
}
