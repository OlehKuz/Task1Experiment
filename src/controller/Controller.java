package controller;

import model.entity.*;
import model.service.TrainService;


public class Controller {
    public void run (){
        TrainService trainService = new TrainService();
        Train train = trainService.buildPassengerTrain();
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
