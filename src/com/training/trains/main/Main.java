package com.training.trains.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.training.trains.bean.*;
import com.training.trains.logic.*;
import com.training.trains.view.*;

public class Main {

	public static void main(String[] args) {
		Schedule trains = new Schedule();

		trains.addTrain(new Train("Paris", 132, new Time(22, 30)));
		trains.addTrain(new Train("London", 142, new Time(7, 00)));
		trains.addTrain(new Train("London", 137, new Time(21, 20)));
		trains.addTrain(new Train("Minsk", 127, new Time(11, 14)));
		trains.addTrain(new Train("Paris", 542, new Time(16, 45)));

		Sorting sort = new Sorting();
		ShowTrains view = new ShowTrains();
		
		//sort table by Train Number
		List<Train> trSorted;
		trSorted = sort.sortByTrainNumber(trains.getTrains());
		System.out.println(view.printTrainSchedule(trSorted));

		//entering Train Number to search
		System.out.print("Pleas enter train's number to search:  \n");
		Scanner sc = new Scanner(System.in);
		int trainNumber = sc.nextInt();
		sc.close();
		
		//try to find train by number
		try {
		System.out.println(view.printTrain(trains.getTrains(), trainNumber));
		} catch (IndexOutOfBoundsException e) {}
				
		//sort table by Destination with sorted Time
		trSorted = sort.sortByDestination(trains.getTrains());
		System.out.println(view.printTrainSchedule(trSorted));
		
	}

}
