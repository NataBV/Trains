package com.training.trains.view;

import java.util.List;
import com.training.trains.bean.*;
import com.training.trains.logic.Sorting;

public class ShowTrains {

	public String printTrainSchedule(List<Train> trains) {
		String res = "";

		for (Train t : trains) {
			res = res + ((t.getDestination()) + " " + (t.getTrainNumber() + " " + t.getDepartureTime().getHour() + "h "
					+ t.getDepartureTime().getMin() + "m " + "\n"));

		}

		return res;
	}

	public String printTrain(List<Train> trains, int trainNumber) {
		Sorting sorted = new Sorting();
		int index = sorted.findTrainByNumber(trains, trainNumber);
		
		System.out.println("index=" + index);
		
		Train t = trains.get(index);
		String res;
		
		
		res = ("Train's information:" + "\n" + t.getDestination()) + " " + (t.getTrainNumber() + " " + t.getDepartureTime().getHour() + "h "
			+ t.getDepartureTime().getMin() + "m " + "\n");
		
		return res;
		
	}

}
