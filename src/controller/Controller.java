package controller;

import model.entity.*;
import model.service.NotEnoughDetailsException;
import model.service.TrainService;
import model.service.VehicleDB;
import java.util.Optional;


public class Controller {
    public void run (){
        TrainService trainService = new TrainService();
        Optional<Train> train = constructTrain(trainService);
        System.out.println(train);
        int lug = trainService.getNumberLuggage(train.get());
        int pas = trainService.getNumberPassengers(train.get());
        System.out.println("Lug " + lug + " Pas " + pas);

        trainService.filterByNumberPassengers(train.get(), 50);
        System.out.println(train);
        trainService.sortWagonsByComfort(train.get());
        System.out.println(train);


    }

    public Optional<Train> constructTrain(TrainService trainService){
        try{
            return Optional.of(trainService.constructTrain(VehicleDB.PASSENGER_TRAIN));
        }catch (NotEnoughDetailsException e){
           e.printStackTrace();
        }
        return Optional.empty();
    }
}
