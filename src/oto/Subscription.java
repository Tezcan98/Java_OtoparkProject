package oto;

import java.util.Calendar;

public class Subscription {
	
	private Date begin, end;
	private SubscribedVehicle subscribedVehicle;
	
	public Subscription(Date begin, Date end, String plate) {
		
		subscribedVehicle = new SubscribedVehicle(plate, this);
		this.begin=begin;
		this.end = end;
	}
	
	public boolean isValid() {
		return ( end.isAfterThan( Date.getToday() ) );
	}

	public SubscribedVehicle getSubscribedVehicle() {
		return subscribedVehicle;
	}

	public void setBegin(Date begin) {
		this.begin = begin;
	}

	public void setEnd(Date end) {
		this.end = end;
	}
	
	
	
}
