package javacore24;

public class Time{

	protected int min;
	protected int hour;

	public Time(int min, int hour) throws Exception {
		if (min < 0 || min > 60) {
			throw new Exception("invalid value");
		} else {
			this.min = min;
		}
		if (hour < 0 || hour > 24) {
			throw new Exception("invalid value");
		} else {
			this.hour = hour;
		}
	}
	
	public int getMin() {
		return min;
	}

	public void setMin(int min) throws Exception {
		if (min < 0 || min > 60) {
			throw new Exception("invalid value");
		} else {
			this.min = min;
		}
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) throws Exception {
		if (hour < 0 || hour > 24) {
			throw new Exception("invalid value");
		} else {
			this.hour = hour;
		}
	}

	

	@Override
	public String toString() {
		return "Time [hour=" + hour + ", min=" + min + "]";
	}

}
