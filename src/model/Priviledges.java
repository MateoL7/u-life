package model;

public interface Priviledges {

	public void addActivity(String name, int minutes, int hours);
	public void addAlarm(int hour, int min, String time, boolean vibrate);
	public void addSport(String name, int minutes, int hours, double cal, SportType st);
}
