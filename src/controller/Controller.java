package controller;

import model.entity.*;
import model.service.TrainService;
import model.service.VehicleDB;

import java.util.Arrays;
import java.util.List;


public class Controller {
    public void run (){
        TrainService trainService = new TrainService();
        //List<Wagon> trainScheme = trainService.getTrainBuildingScheme(VehicleDB.PASSENGER_TRAIN);
        trainService.constructTrain(VehicleDB.PASSENGER_TRAIN);
        System.out.println(train);
        int lug = trainService.getNumberLuggage(train);
        int pas = trainService.getNumberPassengers(train);
        System.out.println("Lug " + lug + " Pas " + pas);

        trainService.filterByNumberPassengers(train, 50);
        System.out.println(train);
        trainService.sortWagonsByComfort(train);
        System.out.println(train);


    }
}
