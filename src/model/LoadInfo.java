package model;

import java.io.IOException;

public interface LoadInfo {

	public final static String PATHFACTS = "data\\funFacts.txt";
	public final static String PATHTIPS = "data\\randomTips.txt";
	
	public String loadRandomInfo(String r) throws IOException;
}
