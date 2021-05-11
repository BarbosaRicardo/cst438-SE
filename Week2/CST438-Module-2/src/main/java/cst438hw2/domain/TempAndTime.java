package cst438hw2.domain;

public class TempAndTime {
	public double temp;
	public long time;
	public int timezone;

public TempAndTime(double temp, long time, int timezone){
	this.temp = temp;
	this.time = time;
	this.timezone = timezone;
}
	
	public String timeToString() {
		return Long.toString(time);
	}
}