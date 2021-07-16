package com.training.trains.logic;

import java.util.*;
import com.training.trains.bean.*;
import com.training.trains.view.ShowTrains;

public class Sorting {

	public List<Train> sortByTrainNumber(List<Train> trains) {
		List<Train> result = new ArrayList<Train>();
		result.addAll(trains);

		for (int i = 0; i < result.size(); i++) {
			result = (upMinTrainNumber(result));
		}

		return result;
	}

	public static List<Train> upMinTrainNumber(List<Train> tr) {

		for (int i = tr.size() - 1; i > 0; i--) {

			if (tr.get(i).getTrainNumber() < tr.get(i - 1).getTrainNumber()) {
				Train tmp = tr.get(i - 1);
				tr.set(i - 1, tr.get(i));
				tr.set(i, tmp);
			}
		}
		return tr;
	}

	public int findTrainByNumber(List<Train> trains, int trainNumber) {
		int index = -1;
		for (Train t : trains) {
			if (t.getTrainNumber() == trainNumber) {
				index = trains.indexOf(t);
			}
		}
		if (index == -1) {
			throw new RuntimeException("There is no train with entered number.");
		}
		return index;
	}

	public List<Train> selectByDestination(String dest, List<Train> trains) {
		List<Train> trainsByDestination = new ArrayList<Train>();
		
		for(Train t: trains) {
			if (t.getDestination().equals(dest)) {
				trainsByDestination.add(t);
			}
		}
		
		return trainsByDestination;
		// add exception for incorrect value
	}
	
	public List<Train> sortByDepartureTime(List<Train> trains) {
		List<Train> result = new ArrayList<Train>();
		result.addAll(trains);

		for (int i = 0; i < result.size(); i++) {
			result = (upMinDepartuteTime(result));
		}

		return result;
	}
	
	public static List<Train> upMinDepartuteTime(List<Train> tr) {

		for (int i = tr.size() - 1; i > 0; i--) {
			int hourLast = tr.get(i).getDepartureTime().getHour();
			int hourNext = tr.get(i - 1).getDepartureTime().getHour();
			
			int minLast = tr.get(i).getDepartureTime().getMin();
			int minNext = tr.get(i - 1).getDepartureTime().getMin();
			
			if ( hourLast < hourNext) {
				Train tmp = tr.get(i - 1);
				tr.set(i - 1, tr.get(i));
				tr.set(i, tmp);
			} else if (hourLast == hourNext) {
				
				if (minLast < minNext) {
					Train tmp = tr.get(i - 1);
					tr.set(i - 1, tr.get(i));
					tr.set(i, tmp);
				}
				
			}
		}
		return tr;
	}
}
