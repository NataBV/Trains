package com.training.trains.bean;

public class Time {
	private int hour;
	private int min;

	public Time(int hour, int min) {
		this.hour = hour;
		this.min = min;
	}

	public void setTime(int hour, int min) {
		this.hour = hour;
		this.min = min;
	}

	public Time getTime() {
		Time t = new Time(hour, min);
		return t;
	}

	public int getHour() {
		return hour;
	}

	public int getMin() {
		return min;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + hour;
		result = prime * result + min;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Time other = (Time) obj;
		if (hour != other.hour)
			return false;
		if (min != other.min)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Time [hour=" + hour + ", min=" + min + "]";
	}

}
