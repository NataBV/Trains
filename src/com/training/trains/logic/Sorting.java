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

	
	private static List<Train> upMinTrainNumber(List<Train> tr) {
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
			System.out.println("There is no train with entered number. \n");
		}
		return index;
	}		

	
	public List<Train> sortByDestination(List<Train> trains) {
		List<Train> result = new ArrayList<Train>();
		result.addAll(trains);
		for (int i = 0; i < result.size(); i++) {
			result = (upMinDepartuteTime(result));
		}		
		for (int i = 0; i < result.size(); i++) {
			result = (upMinDestination(result));
		}		
		return result;
	}

	
	private static List<Train> upMinDestination(List<Train> tr) {
		for (int i = tr.size() - 1; i > 0; i--) {
			String firstDest = tr.get(i).getDestination();
			String nextDest = tr.get(i - 1).getDestination();
			
			if ((firstDest.compareTo(nextDest)) < 0) {
				Train tmp = tr.get(i - 1);
				tr.set(i - 1, tr.get(i));
				tr.set(i, tmp);
			} else if ((firstDest.compareTo(nextDest)) == 0) {
				
			}
		}
		return tr;
	}
	
	private static List<Train> upMinDepartuteTime(List<Train> tr) {

		for (int i = tr.size() - 1; i > 0; i--) {
			final int minInHour = 60;
			int hourLast = tr.get(i).getDepartureTime().getHour();
			int hourNext = tr.get(i - 1).getDepartureTime().getHour();
			
			int minLast = tr.get(i).getDepartureTime().getMin();
			int minNext = tr.get(i - 1).getDepartureTime().getMin();
			
			int timeLast = (hourLast * minInHour) + minLast;
			int timeNext = (hourNext * minInHour) + minNext;
			
			if ( timeLast < timeNext) {
				Train tmp = tr.get(i - 1);
				tr.set(i - 1, tr.get(i));
				tr.set(i, tmp);
				
			} 		
		}
		return tr;
	} 
	
}
