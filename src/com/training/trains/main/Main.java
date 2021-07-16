package com.training.trains.main;

import java.util.ArrayList;
import java.util.List;
import com.training.trains.bean.*;
import com.training.trains.logic.*;
import com.training.trains.view.*;

public class Main {

	public static void main(String[] args) {
		Schedule tr = new Schedule();

		tr.addTrain(new Train("Paris", 132, new Time(14, 30)));
		tr.addTrain(new Train("London", 142, new Time(7, 00)));
		tr.addTrain(new Train("London", 137, new Time(21, 20)));
		tr.addTrain(new Train("Minsk", 127, new Time(11, 14)));
		tr.addTrain(new Train("Paris", 542, new Time(16, 45)));

		Sorting sorted = new Sorting();
		ShowTrains view = new ShowTrains();

		List<Train> trSort;
		trSort = sorted.sortByTrainNumber(tr.getTrains());

		String p = view.printTrainSchedule(trSort);
		System.out.println(p + "\n");

		//System.out.println(view.printTrainSchedule(tr.getTrains()));

		int findTrain = 137;
		
		p = view.printTrain(tr.getTrains(), findTrain);
		System.out.println("\n" + p + "\n");
	

	}

}
