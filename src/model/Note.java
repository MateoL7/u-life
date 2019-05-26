package model;
/** 
*@author: Mateo Loaiza
*@author: Juan Pablo Herrera
*@version: 26/05/2019
*Class Note
*/
public class Note {
	
	private int num;
	private String note;
	
	private Note next;
	private Note prev;
	
	/**
	 * This is the method that instantiates a Note, the builder of the class
	 * @param num int with the number of the note
	 * @param note String with the body of the note
	 */
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

	/**
	 * @return the next
	 */
	public Note getNext() {
		return next;
	}

	/**
	 * @param next the next to set
	 */
	public void setNext(Note next) {
		this.next = next;
	}

	/**
	 * @return the prev
	 */
	public Note getPrev() {
		return prev;
	}

	/**
	 * @param prev the prev to set
	 */
	public void setPrev(Note prev) {
		this.prev = prev;
	}

}
