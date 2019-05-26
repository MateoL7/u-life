package model;

import java.io.IOException;

public interface Information {

	public final static String PATHFACTS = "data\\funFacts.txt";
	public final static String PATHTIPS = "data\\randomTips.txt";
	
	public String loadInfo(String r) throws IOException;
}
