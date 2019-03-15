package controller;

import model.entity.*;
import model.service.NotEnoughDetailsException;
import model.service.TrainService;
import model.service.VehicleDB;
import java.util.Optional;
import static view.TextConstant.*;
import static view.View.bundle;

import view.View;
import view.View.*;


public class Controller {
    private View view;
    public Controller(View view){
        this.view = view;
    }
    public void run (){
        TrainService trainService = new TrainService();
        Optional<Train> train = constructTrain(trainService);
        view.pri
        int lug = trainService.getNumberLuggage(train.get());
        int pas = trainService.getNumberPassengers(train.get());
        System.out.println("Lug " + lug + " Pas " + pas);
        filterByPassengers(trainService,train.get());
        trainService.filterByNumberPassengers(train.get(), 50);
        System.out.println(train);
        trainService.sortWagonsByComfort(train.get());
        System.out.println(train);


    }

    private void filterByPassengers(TrainService trainService, Train train){
        trainService.filterByNumberPassengers(train, 50);
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
