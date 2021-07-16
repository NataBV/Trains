package com.training.trains.bean;

import java.util.ArrayList;
import java.util.List;

public class Schedule {
	List<Train> trains;
	final int size = 5;

	public Schedule() {
		trains = new ArrayList<Train>(size);
	}

	public void setTrains(List<Train> trains) {
		this.trains = trains;
	}

	public List<Train> getTrains() {
		return trains;
	}

	public void addTrain(Train t) {
		trains.add(t);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((trains == null) ? 0 : trains.hashCode());
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
		Schedule other = (Schedule) obj;
		if (trains == null) {
			if (other.trains != null)
				return false;
		} else if (!trains.equals(other.trains))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Schedule [trains=" + trains + "]";
	}

}
