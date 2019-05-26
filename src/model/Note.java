package model;

public class Note {
	
	private int num;
	private String note;
	
	public Note(int num, String note) {
		this.num = num;
		this.note = note;
	}

	/**returns the current value of num
	 * @return the num
	 */
	public int getNum() {
		return num;
	}

	/**changes the value of num for the parameter
	 * @param num the num to set
	 */
	public void setNum(int num) {
		this.num = num;
	}

	/**returns the value of note
	 * @return the note
	 */
	public String getNote() {
		return note;
	}

	/**Changes the value of note for the parameter
	 * @param note the note to set
	 */
	public void setNote(String note) {
		this.note = note;
	}

}
