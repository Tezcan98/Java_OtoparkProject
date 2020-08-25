package oto;

public class Time {
	
	private int hour, minute;
	
	public Time(int hour, int minute) {
		this.hour = hour;
		this.minute = minute;
	}
	
	public int getDifference(Time other) {
		
		int diff = 0;
		
		diff += this.hour - other.hour;
		diff *= 60;
		diff += this.minute - other.minute;
		
		return diff;
	}
	
	

}
