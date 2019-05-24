package model;
import java.io.*;

public class PremiumAccount extends Account implements LoadInfo {
	
	private static final long serialVersionUID = 1L;
	private FunFact rootF;
	private Tip rootT;

	public PremiumAccount(String username, String password, int age, double weight, double height, String gender,
			String nickName, String name) {
		super(username, password, age, weight, height, gender, nickName, name);
	}

	/**
	 * @return the rootF
	 */
	public FunFact getRootF() {
		return rootF;
	}

	/**
	 * @param rootF the rootF to set
	 */
	public void setRootF(FunFact rootF) {
		this.rootF = rootF;
	}

	/**
	 * @return the rootT
	 */
	public Tip getRootT() {
		return rootT;
	}

	/**
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
	
	public void addFunFact(String num, String info) {
		FunFact ff = new FunFact(num, info);
		if(rootF == null) {
			rootF = ff;
		}
		else {
			FunFact current = rootF;
			boolean added = false;
			while(!added) {
				if(ff.getNumber().compareTo(current.getNumber()) > 0) {
					if(current.getRight() == null) {
						current.setRight(ff);
						added = true;
					}
					else {
						current = current.getRight();
					}
				}
				else if(ff.getNumber().compareTo(current.getNumber())< 0) {
					if(current.getLeft() == null) {
						current.setLeft(ff);
						added = true;
					}
					else {
						current = current.getLeft();
					}
				}
			}
		}
	}
	public void addTip(String num, String info) {
		Tip tp = new Tip(Integer.parseInt(num), info);
		if(rootT == null) {
			rootT = tp;
		}
		else {
			Tip current = rootT;
			boolean added = false;
			while(!added) {
				if(tp.getNumber()>current.getNumber()) {
					if(current.getRight() == null) {
						current.setRight(tp);
						added = true;
					}
					else {
						current = current.getRight();
					}
				}
				else if(tp.getNumber()<current.getNumber()) {
					if(current.getLeft() == null) {
						current.setLeft(tp);
						added = true;
					}
					else {
						current = current.getLeft();
					}
				}
			}
		}
	}
	

	
}
