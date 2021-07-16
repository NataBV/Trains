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
		int index = 0;
		for(Train t: trains) {
			if (t.getTrainNumber() == trainNumber) {
				index = trains.indexOf(t);
				
			}
		}
		return index;
	}
}
