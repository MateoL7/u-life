package model;

public interface Active {
	
	public String getName();
	
	public void setName(String n);
	
	public Activity getNext();
	
	public Activity getPrev();
	
	public void setNext(Activity n);
	
	public void setPrev(Activity p);
	
	public int getHours();
	
	public int getMinutes();
	
	public void setMinutes(int m);
	
	public void setHours(int h);
	

}
