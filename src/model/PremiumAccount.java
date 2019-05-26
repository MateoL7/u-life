package model;
import java.io.*;

public class PremiumAccount extends Account implements LoadInfo, Serializable{

	private static final long serialVersionUID = 1L;
	private FunFact rootF;
	private Tip rootT;

	private Note[] notes;

	public PremiumAccount(String username, String password, int age, double weight, double height, String gender, String nickName, String name) {
		super(username, password, age, weight, height, gender, nickName, name);
		
	}

	/**returns the value of rootf
	 * @return the rootF
	 */
	public FunFact getRootF() {
		return rootF;
	}

	/**changes the value of rootf for the parameter
	 * @param rootF the rootF to set
	 */
	public void setRootF(FunFact rootF) {
		this.rootF = rootF;
	}

	/**returns the current value of rootT
	 * @return the rootT
	 */
	public Tip getRootT() {
		return rootT;
	}

	/**changes the value of rootT to the paramter
	 * @param rootT the rootT to set
	 */
	public void setRootT(Tip rootT) {
		this.rootT = rootT;
	}

	/**
	 * This method reads the information from a txt and then allows you to retrieve it
	 * so you can separate in by FunFacts and by Tips
	 */
	@Override
	public String loadRandomInfo(String path) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File(path)));
		String line = br.readLine();
		String separate = "";
		while(line != null) {
			String parts[] = line.split(";");
			String num = parts[0];
			String info = parts[1];
			separate += num + ";" + info + ",";

			line = br.readLine();
		}
		br.close();
		return separate;
	}
	/**
	 * This method is in charge of adding a new FunFact to the tree
	 * @param num the number of the fun fact
	 * @param info the fun fact itself
	 */
	public void addFunFact(String num, String info) {
		FunFact ff = new FunFact(num, info);
		if(rootF == null) {
			rootF = ff;
		}
		else {
			addFunFact(ff, rootF);
		}
	}
	/**
	 * This method is in charge of adding the new FunFact to the tree in a recursive way,
	 * it compares the new FunFact with the one in the parameter
	 * @param ff the FunFact to add
	 * @param current the FunFact to compare to
	 */
	private void addFunFact(FunFact ff, FunFact current) {
		if(ff.getNumber().compareTo(current.getNumber()) > 0) {
			if(current.getRight() == null) {
				current.setRight(ff);
			}
			else {
				addFunFact(ff, current.getRight());
			}
		}
		if(ff.getNumber().compareTo(current.getNumber()) < 0) {
			if(current.getLeft() == null) {
				current.setLeft(ff);
			}
			else {
				addFunFact(ff, current.getLeft());
			}
		}
	}
	/**
	 * Adds a tip to the binary tree tips
	 * @param num the number of the tip
	 * @param info the content of the tip
	 */
	
	public void addTip(String num, String info) {
		Tip tp = new Tip(Integer.parseInt(num), info);
		if(rootT == null) {
			rootT = tp;
		}
		else {
			addTip(tp, rootT);
		}
	}
	
	/**
	 * traverses the binary tree to add the tip
	 * @param tp the tip that is going to be added to the tree
	 * @param current the root of the binary tree
	 */
	private void addTip(Tip tp, Tip current) {
		if(tp.getNumber() > current.getNumber()) {
			if(current.getRight() == null) {
				current.setRight(tp);
			}
			else {
				addTip(tp, current.getRight());
			}
		}
		if(tp.getNumber() < current.getNumber()) {
			if(current.getLeft() == null) {
				current.setLeft(tp);
			}
			else {
				addTip(tp, current.getLeft());
			}
		}
	}
 /**
  * adds a note to the array of notes
  * @param num the number of the note
  * @param note the content of teh note
  * @return a boolean indicating wether it was added or not
  */
	public boolean addNote(int num, String note) {
		Note n = new Note(num, note);
		notes = new Note[20];
		boolean added = false;
		for(int i = 0; i < notes.length-1 && !added; i++) {
			if(notes[i] == null) {
				notes[i] = n;
				added = true;
			}
		}
		return added;
	}

	public Note[] getNotes() {		
		return notes;
	}
	
//	public void sortNotes() {
//		for(int I = 0; I < notes.length-1; I++) {
//			int minPos = I;
//			int num = notes[I].getNum();
//			for(int J = I+1; J < notes.length; J++) {
//				int compareNum = notes[J].getNum();
//				if(compareNum < num ) {
//					minPos = J;
//					num = compareNum;
//				}
//			}
//			Note temp = notes[minPos];
//			notes[minPos] = notes[I];
//			notes[I] = temp;
//		}
//	}
}
